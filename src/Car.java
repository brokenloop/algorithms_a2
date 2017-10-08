/**
 * Created by danieljordan on 07/10/2017.
 */
public class Car extends Vehicle {
    private int passengersNumber;

    // -------- CONSTRUCTOR ---------
    public Car(String owner, int totalRentalDays, int rentalCostPerDay, int passengersNumber) {
        super(owner, totalRentalDays, rentalCostPerDay);
        this.passengersNumber = passengersNumber;
    }


    // ------SETTERS AND GETTERS-------

    public int getPassengersNumber() {
        return passengersNumber;
    }

    public void setPassengersNumber(int passengersNumber) {
        this.passengersNumber = passengersNumber;
    }
}
