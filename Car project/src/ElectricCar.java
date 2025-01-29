public class ElectricCar extends Car{
    private final byte batteryTotalCapacity=100;
    private byte batteryCurrentCapacity;

    public ElectricCar(Company company, String modelName, short modelYear, String color, long price, short horsePower, short maxSpeed, boolean isAutomatic, boolean isFourWheelDrive) {
        super(company, modelName, modelYear, color, price, horsePower, maxSpeed, isAutomatic, isFourWheelDrive);
        this.batteryCurrentCapacity=batteryTotalCapacity;
        this.currentDriveDistance=0;
    }
    public void charge(){
        ChargeBatteryThread chargeBatteryThread = new ChargeBatteryThread();
        chargeBatteryThread.pluginCharger(this.batteryTotalCapacity, this.batteryCurrentCapacity);
        chargeBatteryThread.start();
        try{
            chargeBatteryThread.join();
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
        this.batteryCurrentCapacity=chargeBatteryThread.plugOutCharger();
    }
    public void startDrive(int routeDistance){
        float batteryCycleCount=0;
        this.routeDistance=routeDistance;
        this.startEngine();
        if(engineStart && this.batteryCurrentCapacity!=0) {
            System.out.println("car is started driving");
            while (this.currentDriveDistance <= this.routeDistance && this.batteryCurrentCapacity != 0) {
                this.currentDriveDistance += this.currentSpeed;
                System.out.println("Speed : " + this.currentSpeed + " Km/h\tDistance covered : " + this.currentDriveDistance + "Km" + " \tBattery : " + this.batteryCurrentCapacity + "%");
                if ( this.currentSpeed < this.maxSpeed) {
                    this.currentSpeed++;
                }
                batteryCycleCount+= 1F;
                if (batteryCycleCount % 4 == 0) {
                    this.batteryCurrentCapacity--;
                }
                int percentageForBrakes = (this.currentDriveDistance * 100) / this.routeDistance;
                if (percentageForBrakes >= 80) {
                    System.out.println("You are near to your destination now applying brakes");
                    applyBrakes(batteryCycleCount);
                    break;
                } else if (this.batteryCurrentCapacity < 20) {
                    System.out.println("Warning!!  Battery low");
                    System.out.println("battery capacity : " + this.batteryCurrentCapacity);
                    System.out.println("The Car is applying brakes automatically");
                    applyBrakes(batteryCycleCount);
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
                System.out.println("battery remaining : " + this.batteryCurrentCapacity);
                this.currentDriveDistance = 0;
        }
        else
            System.out.println("You can not drive car because engine is off");
        engineStart=false;
    }
    public void applyBrakes(float batteryCycleCount){
        System.out.println("Applying brakes");
        while(this.currentSpeed>=0 && this.currentDriveDistance<=this.routeDistance ){
            System.out.println("Speed : "+this.currentSpeed+" Km/h\tDistance covered : "+this.currentDriveDistance+"Km" + " \tBattery : " + this.batteryCurrentCapacity + "%");
            this.currentSpeed--;
            batteryCycleCount+=0.5F;
            if (batteryCycleCount % 1 == 0) {
                this.batteryCurrentCapacity--;
            }
            this.currentDriveDistance+=this.currentSpeed;
            try {
                Thread.sleep(500);
            }catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
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
        System.out.println("\nbatteryTotalCapacity = " + batteryTotalCapacity);
        System.out.println("\nbatteryCurrentCapacity = " + batteryCurrentCapacity);
    }
}