public class RefillFuelThread extends Thread{
    private byte addFuel;
    private byte fuelCapacity;
    private byte currentFuel;
    public void addFuel(byte addFuel, byte fuelCapacity, byte currentFuel){
        this.addFuel = addFuel;
        this.fuelCapacity= fuelCapacity;
        this.currentFuel= currentFuel;
    }
    public void run(){
        System.out.println(" ⛽ Refilling Fuel");
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        int fuel =  this.currentFuel + addFuel;
        if(fuel>this.fuelCapacity)
            System.out.println("Fuel capacity is exceeding\nplease add the fuel in limit");
        else {
            this.currentFuel += addFuel;
            System.out.println("fuel added successfully the current fuel is : " + this.currentFuel);
        }
    }
    public byte fuelRefilled(){
        return this.currentFuel;
    }
}