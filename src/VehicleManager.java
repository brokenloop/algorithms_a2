import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by danieljordan on 07/10/2017.
 *
 * This class deals with creating and storing Vehicle objects, and performing calculations on the
 * entire collection of vehicles (printAllVehicles, calculateVehicleTotalIncome) etc.
 */
public class VehicleManager {

    private ArrayList<Vehicle> vehicleList = new ArrayList<>();

    // Reads info from input file (fileName) and creates relevant properties.
    public void readInputVehicleFile(String fileName) {

        try {
            FileReader readMyFile = new FileReader(fileName);
            Scanner scanMyFile = new Scanner(readMyFile);

            while (scanMyFile.hasNext()) {
                String[] row = scanMyFile.nextLine().split(" ");

                // Car
                if (row[0].equals("1")) {
                    // Parsing variables
                    int passengersNumber = Integer.parseInt(row[1]);
                    int rentalCostPerDay = Integer.parseInt(row[2]);
                    int totalRentalDays = Integer.parseInt(row[3]);
                    String owner = row[4];

                    // create vehicle, rent vehicle, add to arraylist
                    Car vehicle = new Car(owner, totalRentalDays, rentalCostPerDay, passengersNumber);
                    vehicleList.add(vehicle);
                }

                // Truck
                if (row[0].equals("2")) {
                    // Parsing variables
                    int cargoWeight = Integer.parseInt(row[1]);
                    int rentalCostPerDay = Integer.parseInt(row[2]);
                    int totalRentalDays = Integer.parseInt(row[3]);
                    String owner = row[4];

                    // create vehicle, rent vehicle, add to arraylist
                    Truck vehicle = new Truck(owner, totalRentalDays, rentalCostPerDay, cargoWeight);
                    vehicleList.add(vehicle);
                }
            }
        } catch(Exception ex) {
            System.out.println("Error! " + ex.getMessage());
        }
    }

    // Creates some vehicles using hardcoded
    public void fillInVehicles() {
        Car car1 = new Car("Daniel", 1, 10, 5);
        Car car2 = new Car("Eoghan", 0, 10, 5);
        Car car3 = new Car("Mark", 0, 10, 5);

        Truck truck1 = new Truck("Daniel", 0, 10, 5);
        Truck truck2 = new Truck("Eoghan", 0, 10, 5);
        Truck truck3 = new Truck("Mark", 0, 10, 5);

        this.vehicleList.add(car1);
        this.vehicleList.add(car2);
        this.vehicleList.add(car3);
        this.vehicleList.add(truck1);
        this.vehicleList.add(truck2);
        this.vehicleList.add(truck3);
    }


    // Prints all vehicles that have been created
    public void printAllVehicles(String fileName) {
        try{
            PrintWriter myOutFile = new PrintWriter(fileName);

            for (Vehicle vehicle : this.vehicleList) {
                myOutFile.println(vehicle);
            }
            myOutFile.close();

        } catch(Exception ex) {
            System.out.println("Error!" + ex.getMessage());
        }
    }


    // Calculates income from all vehicles
    public int calculateVehicleTotalIncome() {
        int totalIncome = 0;

        for (Vehicle vehicle : this.vehicleList) {
            totalIncome += vehicle.calculateIncome();
        }

        return totalIncome;
    }
}
