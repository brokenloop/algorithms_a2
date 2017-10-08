/**
 * Created by danieljordan on 07/10/2017.
 */
public class Truck extends Vehicle {
    private int cargoWeight;

    // -------- CONSTRUCTOR ---------
    public Truck(String owner, int totalRentalDays, int rentalCostPerDay, int cargoWeight) {
        super(owner, totalRentalDays, rentalCostPerDay);
        this.cargoWeight = cargoWeight;
    }


    // ------SETTERS AND GETTERS-------

    public int getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(int cargoWeight) {
        this.cargoWeight = cargoWeight;
    }



    // -------------- REQUIRED METHODS -------------
    public int calculateIncome() {
        int rentalIncome = super.calculateIncome();
        rentalIncome += this.cargoWeight * this.getTotalRentalDays();
        return rentalIncome;
    }
}
