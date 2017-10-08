/**
 * Created by danieljordan on 02/10/2017.
 */
public class Main {
    public static void main(String args[]) {

        // ------ PROPERTY METHODS ------
        String propertyInputFile = "files/InputProperty.txt";
        String propertyOutputFile = "files/OutputProperty.txt";

        PropertyManager propertyManager = new PropertyManager();

        propertyManager.readInputPropertyFile(propertyInputFile);
        propertyManager.printAllProperties(propertyOutputFile);


        // ------ VEHICLE METHODS ------
        String vehicleInputFile = "files/InputVehicle.txt";
        String vehicleOutputFile = "files/OutputVehicle.txt";

        VehicleManager vehicleManager = new VehicleManager();

        vehicleManager.readInputVehicleFile(vehicleInputFile);
        vehicleManager.printAllVehicles(vehicleOutputFile);
    }
}
