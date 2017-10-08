/**
 * Created by danieljordan on 02/10/2017.
 */
public class Apartment extends Property {
    private int storeyNumber;
    private int numberOfBeds;


    // -------- CONSTRUCTOR ---------
    public Apartment(String ownerName, String postalAddress, int costPerDay, int storeyNumber, int numberOfBeds) {
        super(ownerName, postalAddress, costPerDay);
        this.storeyNumber = storeyNumber;
        this.numberOfBeds = numberOfBeds;
    }


    // -------- SETTERS AND GETTERS -----------

    public int getStoreyNumber() {
        return storeyNumber;
    }

    public void setStoreyNumber(int storeyNumber) {
        this.storeyNumber = storeyNumber;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }
}
