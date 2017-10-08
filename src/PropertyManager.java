/**
 * Created by danieljordan on 02/10/2017.
 *
 * This class deals with creating properties, storing them in arraylists,
 * and performing operations on all of the properties
 * (calculateTotalIncome, printAllProperties etc)
 */

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileReader;
import java.util.Scanner;
import java.io.PrintWriter;

public class PropertyManager {


    private ArrayList<Apartment> apartmentList = new ArrayList<Apartment>();
    private ArrayList<House> houseList = new ArrayList<House>();
    private ArrayList<Villa> villaList = new ArrayList<Villa>();

    // Stores location of each property. Allows us to quickly find properties based on their IDs.
    private HashMap<Integer, Integer[]> locationMap = new HashMap();


    // Calculates income from all properties
    public int calculateTotalIncome() {
        int totalIncome = 0;

        for (Property property : this.apartmentList) {
            totalIncome += property.calculateIncome();
        }

        for (Property property : this.houseList) {
            totalIncome += property.calculateIncome();
        }

        for (Property property : this.villaList) {
            totalIncome += property.calculateIncome();
        }

        return totalIncome;
    }

    // Outputs contents of each arraylist to file (fileName)
    public void printAllProperties(String fileName) {
        try{
            PrintWriter myOutFile = new PrintWriter(fileName);

            for (Property property : this.apartmentList) {
                myOutFile.println(property);
            }
            for (Property property : this.houseList) {
                myOutFile.println(property);
            }
            for (Property property : this.villaList) {
                myOutFile.println(property);
            }

            myOutFile.close();

        } catch(Exception ex) {
            System.out.println("Error!" + ex.getMessage());
        }
    }

    // Reads info from input file (fileName) and creates relevant properties.
    public void readInputPropertyFile(String fileName) {

        try {
            FileReader readMyFile = new FileReader(fileName);
            Scanner scanMyFile = new Scanner(readMyFile);

            while (scanMyFile.hasNext()) {
                String[] row = scanMyFile.nextLine().split(" ");

                // Apartment
                if (row[0].equals("1")) {
                    // Parsing variables
                    int storeyNumber = Integer.parseInt(row[1]);
                    int bedsNumber = Integer.parseInt(row[2]);
                    int costPerDay = Integer.parseInt(row[3]);
                    int rentalDays = Integer.parseInt(row[4]);
                    String owner = row[5];
                    String address = row[6];

                    // create property, rent property, add to arraylist
                    Apartment newApartment = new Apartment(owner, address, costPerDay, storeyNumber, bedsNumber);
                    newApartment.rentProperty(rentalDays);
                    apartmentList.add(newApartment);

                    // Store new property's location
                    Integer[] location = {1, apartmentList.size() - 1};
                    locationMap.put(newApartment.getRegisterNumber(), location);
                }

                // House
                else if (row[0].equals("2")) {
                    int numberOfStoreys = Integer.parseInt(row[1]);
                    int ClearingFees = Integer.parseInt(row[2]);
                    int costPerDay = Integer.parseInt(row[3]);
                    int rentalDays = Integer.parseInt(row[4]);
                    String owner = row[5];
                    String address = row[6];

                    // create property, rent property, add to arraylist
                    House newHouse = new House(owner, address, costPerDay, numberOfStoreys, ClearingFees);
                    // Have to call rentProperty method, as the number of rentalDays isn't assigned on construction.
                    newHouse.rentProperty(rentalDays);
                    houseList.add(newHouse);

                    // Store new property's location
                    Integer[] location = {2, houseList.size() - 1};
                    locationMap.put(newHouse.getRegisterNumber(), location);

                }

                // Villa
                else if (row[0].equals("3")) {
                    // Parsing variables
                    int numberOfRooms = Integer.parseInt(row[1]);
                    int roomServiceCostPerDay = Integer.parseInt(row[2]);
                    int taxPerDay = Integer.parseInt(row[3]);
                    int costPerDay = Integer.parseInt(row[4]);
                    int rentalDays = Integer.parseInt(row[5]);
                    String owner = row[6];
                    String address = row[7];

                    // create property, rent property, add to arraylist
                    Villa newVilla = new Villa(owner, address, costPerDay, numberOfRooms, roomServiceCostPerDay, taxPerDay);
                    newVilla.rentProperty(rentalDays);
                    villaList.add(newVilla);

                    // Store new property's location
                    // location -> [property type, location in array]
                    Integer[] location = {3, villaList.size() - 1};
                    locationMap.put(newVilla.getRegisterNumber(), location);
                }
            }
        } catch(Exception ex) {
            System.out.println("Error! " + ex.getMessage());
        }
    }


    // Takes propertyID and rentalDays, finds the requested property, and then rents that property for
    // the number of days specified by rentalDays, minus one free day.
    public void giveRentalProperty() {

        try {
            int propertyID = 0;
            int rentalDays = 0;

            // Making the swing input pane
            // Code adapted from https://stackoverflow.com/questions/6555040/multiple-input-in-joptionpane-showinputdialog
            JTextField xField = new JTextField(5);
            JTextField yField = new JTextField(5);

            JPanel myPanel = new JPanel();
            myPanel.add(new JLabel("Property ID:"));
            myPanel.add(xField);
            myPanel.add(Box.createHorizontalStrut(15)); // a spacer
            myPanel.add(new JLabel("Number of Rental Days:"));
            myPanel.add(yField);

            int result = JOptionPane.showConfirmDialog(null, myPanel,
                    "Please Enter ID and number of Rental Days", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                propertyID = Integer.parseInt(xField.getText());
                rentalDays = Integer.parseInt(yField.getText());
            }


            // Getting the location of the requested property
            Integer[] location = locationMap.get(propertyID);

            int propertyType = location[0];
            int index = location[1];
            Property property;

            // Accessing property and adding extra rental days
            if (propertyType == 1) {
                property = apartmentList.get(index);
                property.rentProperty(rentalDays);

            } else if (propertyType == 2) {
                property = houseList.get(index);
                property.rentProperty(rentalDays);

            } else if (propertyType == 3) {
                property = villaList.get(index);
                property.rentProperty(rentalDays);
            }

        } catch(Exception ex) {
            System.out.println("Error! " + ex.getMessage());
        }

    }
}
