/**
 * Created by danieljordan on 02/10/2017.
 *
 * This is an abstract class, to be extended by Apartment, House and Villa
 */


public abstract class Property implements RentalItem {
    private int registerNumber;
    private String ownerName;
    private String postalAddress;
    private int costPerDay;
    private int totalRentalDays = 0;

    // Incremented every time a property is created, allowing each property to have a unique
    private static int propertyCount = 0;


    // -------- CONSTRUCTOR ---------
    public Property(String ownerName, String postalAddress, int costPerDay) {

        // Give new registerNumber to object, increment propertyCount
        this.registerNumber = propertyCount++;

        this.registerNumber = registerNumber;
        this.ownerName = ownerName;
        this.postalAddress = postalAddress;
        this.costPerDay = costPerDay;
    }


    // -------- SETTERS AND GETTERS -----------

    public int getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(int registerNumber) {
        this.registerNumber = registerNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public int getCostPerDay() {
        return costPerDay;
    }

    public void setCostPerDay(int costPerDay) {
        this.costPerDay = costPerDay;
    }

    public int getTotalRentalDays() {
        return totalRentalDays;
    }

    public void setTotalRentalDays(int totalRentalDays) {
        this.totalRentalDays = totalRentalDays;
    }


    public void rentProperty(int rentalDays) {
        this.totalRentalDays += rentalDays;
    }



    // -------------- REQUIRED METHODS -------------

    // Calculates income from the cost of the property per day, and the total number of rental days
    public int calculateIncome() {
        int rentalIncome = this.costPerDay * this.totalRentalDays;
        return rentalIncome;
    }

    // Prints property type, property address, and property register number
    public String toString() {
        String propertyType = this.getClass().getName();
        return ("Property Type: " + propertyType + ", Address: \"" + this.postalAddress + "\", Register Number: " + this.registerNumber);
    }

    public void rentalItem(int rentalDays) {
        this.setTotalRentalDays(this.totalRentalDays + rentalDays - 1);
    }
}
