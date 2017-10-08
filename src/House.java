/**
 * Created by danieljordan on 02/10/2017.
 */
public class House extends Property{
    private int numberOfStoreys;
    private int clearingFee;

    // -------- CONSTRUCTOR ---------
    public House(String ownerName, String postalAddress, int costPerDay, int numberOfStoreys, int clearingFee) {
        super(ownerName, postalAddress, costPerDay);
        this.numberOfStoreys = numberOfStoreys;
        this.clearingFee = clearingFee;
    }


    // -------- SETTERS AND GETTERS -----------

    public int getNumberOfStoreys() {
        return numberOfStoreys;
    }

    public void setNumberOfStoreys(int numberOfStoreys) {
        this.numberOfStoreys = numberOfStoreys;
    }

    public int getClearingFee() {
        return clearingFee;
    }

    public void setClearingFee(int clearingFee) {
        this.clearingFee = clearingFee;
    }


    // -------------- REQUIRED METHODS -------------

    public int calculateIncome() {
        int rentalIncome = super.calculateIncome();

        // We assume here that clearingFee is a one time charge per rental.
        return rentalIncome + this.clearingFee;
    }

}
