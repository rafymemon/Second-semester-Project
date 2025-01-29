public class ChargeBatteryThread extends Thread {
    private byte batteryCurrentCapacity;
    private byte batteryTotalCapacity;
    public void pluginCharger(byte batteryTotalCapacity, byte batteryCurrentCapacity){
        this.batteryCurrentCapacity=batteryCurrentCapacity;
        this.batteryTotalCapacity= batteryTotalCapacity;
    }
    public void run(){
        if(this.batteryCurrentCapacity < this.batteryTotalCapacity){
            System.out.println("Charging car");
            for(int i=this.batteryCurrentCapacity; batteryCurrentCapacity<this.batteryTotalCapacity; i++){
                System.out.println("\uD83D\uDD0B Battery : "+this.batteryCurrentCapacity+"%");
                this.batteryCurrentCapacity++;
                try {
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    System.out.println(e.getMessage());
                }
            }
            System.out.println("Battery is fully Charged");
        }
        else if(this.batteryCurrentCapacity==100) {
            System.out.println("Error Battery is already fully charged");
        }
        else {
            System.out.println("Error Charging : go to the repair shop OR mechanic to check the problem that happening with charging");
        }
    }
    public byte plugOutCharger(){
        return this.batteryCurrentCapacity;
    }
}