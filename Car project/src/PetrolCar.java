public class PetrolCar extends Car {
    private byte fuelCapacity;
    private byte currentFuel;

    public PetrolCar(Company company, String modelName, short modelYear, String color, long price, short horsePower, short maxSpeed, boolean isAutomatic, boolean isFourWheelDrive, byte fuelCapacity) {
        super(company, modelName, modelYear, color, price, horsePower, maxSpeed, isAutomatic, isFourWheelDrive);
        this.fuelCapacity = fuelCapacity;
        this.currentFuel=fuelCapacity;
    }

    public void refillFuel(byte addFuel) {
        RefillFuelThread refillFuel = new RefillFuelThread();
        refillFuel.addFuel(addFuel, this.fuelCapacity, this.currentFuel);
        refillFuel.start();
        try {
            refillFuel.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        this.currentFuel+=refillFuel.fuelRefilled();
    }

    public void startDrive(int routeDistance) {
        this.routeDistance=routeDistance;
        this.startEngine();
        float fuelDecreaseCount=0;
        if (engineStart) {
            System.out.println("car is started driving");
            while (this.currentDriveDistance <= this.routeDistance) {
                this.currentDriveDistance += this.currentSpeed;
                System.out.println("Speed : " + this.currentSpeed + " Km/h\tDistance covered : " + this.currentDriveDistance + "Km  Current Fuel : "+this.currentFuel);
                fuelDecreaseCount+=1F;
                if (this.currentSpeed < maxSpeed) {
                    this.currentSpeed++;
                }
                if (fuelDecreaseCount % 4 == 0) {
                    this.currentFuel--;
                }
                int percentageForBrakes = (this.currentDriveDistance * 100) / this.routeDistance;
                if (percentageForBrakes >= 80) {
                    System.out.println("You are near to your destination now applying brakes");
                    applyBrakes(fuelDecreaseCount);
                    break;
                }
                else if(this.currentFuel==0) {
                    System.out.println("Car Stopped due to lack of Fuel");
                    break;
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
                this.totalDistanceCovered += this.currentDriveDistance;
                System.out.println("You reached your destination");
                System.out.println("distance covered in current drive : " + this.currentDriveDistance + "Km");
                System.out.println("Total distance covered : " + this.totalDistanceCovered + "Km");
                System.out.println("Remaining Fuel : "+this.currentFuel);
                this.currentDriveDistance = 0;
                engineStart=false;
        }
        else
            System.out.println("You can not drive car because engine is off");
    }
    public void applyBrakes(float fuelDecreaseCount){
        System.out.println("Applying brakes");
        while(this.currentSpeed>=0 && this.currentDriveDistance<=this.routeDistance ){
            System.out.println("Speed : "+this.currentSpeed+" Km/h\tDistance covered : "+this.currentDriveDistance+"Km"+" Current Fuel : "+this.currentFuel);
            this.currentSpeed--;
            this.currentDriveDistance+=this.currentSpeed;
            if (fuelDecreaseCount % 2 == 0) {
                this.currentFuel--;
            }
            try {
                Thread.sleep(500);
            }catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
            fuelDecreaseCount+=0.5F;
        }
        System.out.println("The car is now Stopped");
    }

    public void displayInfo(){
        System.out.println("\nmodelName = " + modelName);
        System.out.println("\nmodelYear = " + modelYear);
        System.out.println("\ncolor = " + color);
        System.out.println("\nprice = " + price);
        System.out.println("\nhorsePower = " + horsePower);
        System.out.println("\nmaxSpeed = " + maxSpeed);
        System.out.println("\ncurrentSpeed = " + currentSpeed);
        System.out.println("\nisAutomatic = " + isAutomatic);
        System.out.println("\nisFourWheelDrive = " + isFourWheelDrive);
        System.out.println("\nFuel Capacity = " + fuelCapacity);
        System.out.println("\nCurrent Fuel Capacity = " + currentFuel);
    }
}