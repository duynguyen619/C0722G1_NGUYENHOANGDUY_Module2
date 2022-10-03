package Case_study_module2.model.facility;

public class House extends Facility {
    private String roomStandard;
    private int numOfFloor;

    public House() {
    }

    public House(String idService, String nameService, double usableArea, double rentalCosts, int maximumNumOfPeople, String rentalType, String roomStandard, int numOfFloor) {
        super(idService, nameService, usableArea, rentalCosts, maximumNumOfPeople, rentalType);
        this.roomStandard = roomStandard;
        this.numOfFloor = numOfFloor;
    }

    public House(String roomStandard, int numOfFloor) {
        this.roomStandard = roomStandard;
        this.numOfFloor = numOfFloor;
    }

    @Override
    public String getInfoToCSV() {
        return super.getInfoToCSV() + "," + this.roomStandard + "," + this.numOfFloor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getNumOfFloor() {
        return numOfFloor;
    }

    public void setNumOfFloor(int numOfFloor) {
        this.numOfFloor = numOfFloor;
    }

    @Override
    public String toString() {
        return "House{" +
                super.toString() +
                ";roomStandard='" + roomStandard + '\'' +
                ";numOfFloor=" + numOfFloor +
                '}';
    }
}
