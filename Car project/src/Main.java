import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Company audi = new Company("Audi", (short) 1909, "Ingolstadt,Germany", "August Horch", 60000000000L, "audi@gmail.com");
        Company bmw = new Company("BMW", (short) 1916, "Munich, Germany", "Bayerische Motoren Werke AG", 15844400000L, "bmw@gmail.com");

        ElectricCar electricCar1 = new ElectricCar(audi, "Audi e-tron", (short) 2023, "Blue", 42000000L, (short) 350, (short) 190, true, true);
        ElectricCar electricCar2 = new ElectricCar(bmw, "BMW iX", (short) 2023, "Black", 82000000L, (short) 400, (short) 200, true, true);

        PetrolCar petrolCar1 = new PetrolCar(audi, "Audi A4", (short) 2019, "White", 25000000L, (short) 150, (short) 180, true, false, (byte) 55);
        PetrolCar petrolCar2 = new PetrolCar(bmw, "BMW X1", (short) 2019, "White", 15000000L, (short) 180, (short) 150, true, true, (byte) 60);


        Scanner sc = new Scanner(System.in);
        System.out.println("Register a driver to drive a car");
        System.out.println("Enter Name : ");
        String name = sc.nextLine();
        System.out.println("Enter Address : ");
        String address = sc.nextLine();
        System.out.println("Enter driving license Id : ");
        int licenseId = sc.nextInt();
        System.out.println("Enter gender : ");
        String gender = sc.next();

        Driver driver = new Driver(name, address, licenseId, gender);
        System.out.println("Driver registered successfully");

        Thread.sleep(1000);
        System.out.println("\n\n-------Display All available cars------");
        System.out.println("\n1. Electric car");
        System.out.println(electricCar1);
        System.out.println("\n\n2. Electric car");
        System.out.println(electricCar2);
        System.out.println("\n\n3. Petrol car");
        System.out.println(petrolCar1);
        System.out.println("\n\n4. petrol Car");
        System.out.println(petrolCar2);
        System.out.println("\n\nSelect a car : ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                driver.assignCar(electricCar1);
                break;
            case 2:
                driver.assignCar(electricCar2);
                break;
            case 3:
                driver.assignCar(petrolCar1);
                break;
            case 4:
                driver.assignCar(petrolCar2);
                break;
            default:
                System.out.println("Invalid input Try Again");
                break;
        }
        String choice2;
        if(driver.getElectricCar()!=null || driver.getPetrolCar()!=null) {
            do {
                System.out.println("---Start Drive---");
                System.out.println("Enter your current place : ");
                sc.nextLine();
                String currentPlace = sc.nextLine();
                System.out.println("Enter your destination place : ");
                String destination = sc.nextLine();
                System.out.println("Enter total distance : ");
                int totalDistance = sc.nextInt();

                System.out.println("---Your route---");
                System.out.println("Starting point : " + currentPlace);
                System.out.println("Destination : " + destination);
                System.out.println("Total route distance : " + totalDistance);
                System.out.println("Press y to start drive : ");
                choice2 = sc.next();
                if (choice2.equalsIgnoreCase("y")) {
                    driver.driveCar(currentPlace, destination, totalDistance);
                }
                else {
                    System.out.println("Error : Invalid input ");
                    continue;
                }
                System.out.println("Press y to Refuel car : ");
                choice2 = sc.next();
                if (choice2.equalsIgnoreCase("y")) {
                    System.out.println("Choose refuelling method");
                    System.out.println("1. charge Car");
                    System.out.println("2. Refuel car");
                    int option = sc.nextInt();
                    if (option == 1) {
                        driver.chargeCar();
                    } else if (option == 2) {
                        System.out.println("Enter amount of fuel : ");
                        int amount = sc.nextInt();
                        driver.refillFuel((byte) amount);
                    }
                }
                System.out.println("Do you want to continue ride Y ");
                choice2 = sc.next();
            }while (choice2.equalsIgnoreCase("y"));
        }
        else {
            System.out.println("Error : You have not selected a valid car");
        }
        System.out.println("program ended..............");
    }
}
