/**
 * Created by danieljordan on 02/10/2017.
 */
public class Villa extends Property {
    private int numberOfRooms;
    private int roomServiceCostPerDay;
    private int luxuryTaxPerDay;


    // -------- CONSTRUCTOR ---------
    public Villa(String ownerName, String postalAddress, int costPerDay, int numberOfRooms,
                 int roomServiceCostPerDay, int luxuryTaxPerDay) {
        super(ownerName, postalAddress, costPerDay);
        this.numberOfRooms = numberOfRooms;
        this.roomServiceCostPerDay = roomServiceCostPerDay;
        this.luxuryTaxPerDay = luxuryTaxPerDay;
    }


    // -------- SETTERS AND GETTERS -----------

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public int getRoomServiceCostPerDay() {
        return roomServiceCostPerDay;
    }

    public void setRoomServiceCostPerDay(int roomServiceCostPerDay) {
        this.roomServiceCostPerDay = roomServiceCostPerDay;
    }

    public int getLuxuryTaxPerDay() {
        return luxuryTaxPerDay;
    }

    public void setLuxuryTaxPerDay(int luxuryTaxPerDay) {
        this.luxuryTaxPerDay = luxuryTaxPerDay;
    }


    // -------------- REQUIRED METHODS -------------

    public int calculateIncome() {
        int rentalIncome = super.calculateIncome();
        int roomServiceIncome = this.getTotalRentalDays() * this.roomServiceCostPerDay;
        int luxuryTaxIncome = this.getTotalRentalDays() * this.luxuryTaxPerDay;

        return rentalIncome + roomServiceIncome + luxuryTaxIncome;
    }
}
