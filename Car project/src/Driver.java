public class Driver {
    private String name;
    private String address;
    private int drivingLicenseId;
    private ElectricCar electricCar;
    private PetrolCar petrolCar;
    private String gender;
    public Driver(String name, String address, int drivingLicenseId, String gender) {
        this.name = name;
        this.address = address;
        this.drivingLicenseId = drivingLicenseId;
        this.gender = gender;
    }
    public void assignCar(ElectricCar eCar){
        this.electricCar=eCar;
    }
    public void assignCar(PetrolCar pCar){
        this.petrolCar= pCar;
    }
    public void driveCar(String startingPlace, String destination,int routeDistance){
        System.out.println(this.name+" start driving from "+startingPlace+" to "+destination+"\tTotal distance : "+routeDistance+"Km");
        if(electricCar!=null){
            this.electricCar.startDrive(routeDistance);
        } else if (petrolCar!=null) {
            this.petrolCar.startDrive(routeDistance);
        }
    }
    public void chargeCar() {
        if(electricCar!=null){
            this.electricCar.charge();
        }
    }
    public void refillFuel(byte fuelAmount){
        if (petrolCar!=null) {
            this.petrolCar.refillFuel(fuelAmount);
        }
    }
    public void displayInfo(){
        System.out.println( "name : "+name+"\ngender : "+ gender + "\naddress : " +address+"drivingLicenseId : " + drivingLicenseId);
        if(electricCar!=null) {
            this.electricCar.displayInfo();
        }
        else if (petrolCar!=null) {
            petrolCar.displayInfo();
        }
    }


    public ElectricCar getElectricCar() {
        return electricCar;
    }

    public PetrolCar getPetrolCar() {
        return petrolCar;
    }
}