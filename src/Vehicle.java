/**
 * Created by danieljordan on 07/10/2017.
 */
public class Vehicle implements RentalItem {

    private String owner;
    private int totalRentalDays;
    private int rentalCostPerDay;



    // -------- CONSTRUCTOR ---------
    public Vehicle(String owner, int totalRentalDays, int rentalCostPerDay) {
        this.owner = owner;
        this.totalRentalDays = totalRentalDays;
//        this.totalRentalDays = 100;
        this.rentalCostPerDay = rentalCostPerDay;
    }

    // -------- SETTERS AND GETTERS -----------
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getTotalRentalDays() {
        return totalRentalDays;
    }

    public void setTotalRentalDays(int totalRentalDays) {
        this.totalRentalDays = totalRentalDays;
    }

    public int getRentalCostPerDay() {
        return rentalCostPerDay;
    }

    public void setRentalCostPerDay(int rentalCostPerDay) {
        this.rentalCostPerDay = rentalCostPerDay;
    }



    // -------------- REQUIRED METHODS -------------
    public String toString() {
        String propertyType = this.getClass().getName();
        return ("Vehicle Type: " + propertyType + ", Owner: \"" + this.owner + "\"" );
    }

    public void rentalItem(int rentalDays) {
        this.setTotalRentalDays(this.totalRentalDays + rentalDays - 1);
    }

    public int calculateIncome() {
        int rentalIncome = this.rentalCostPerDay * this.totalRentalDays;
        return rentalIncome;
    }
}
