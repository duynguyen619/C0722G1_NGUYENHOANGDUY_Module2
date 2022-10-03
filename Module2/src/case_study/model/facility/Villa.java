package Case_study_module2.model.facility;

public class Villa extends Facility {
    private String roomStandard;
    private double swimmingPoolArea;
    private int numOfFloor;

    public Villa() {
    }


    public Villa(String idService, String nameService, double usableArea, double rentalCosts, int maximumNumOfPeople, String rentalType, String roomStandard, double swimmingPoolArea, int numOfFloor) {
        super(idService, nameService, usableArea, rentalCosts, maximumNumOfPeople, rentalType);
        this.roomStandard = roomStandard;
        this.swimmingPoolArea = swimmingPoolArea;
        this.numOfFloor = numOfFloor;
    }

    public Villa(String roomStandard, double swimmingPoolArea, int numOfFloor) {
        this.roomStandard = roomStandard;
        this.swimmingPoolArea = swimmingPoolArea;
        this.numOfFloor = numOfFloor;
    }

    @Override
    public String getInfoToCSV() {
        return super.getInfoToCSV()+","+this.roomStandard+","+this.swimmingPoolArea+","+this.numOfFloor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getSwimmingPoolArea() {
        return swimmingPoolArea;
    }

    public void setSwimmingPoolArea(double swimmingPoolArea) {
        this.swimmingPoolArea = swimmingPoolArea;
    }

    public int getNumOfFloor() {
        return numOfFloor;
    }

    public void setNumOfFloor(int numOfFloor) {
        this.numOfFloor = numOfFloor;
    }

    @Override
    public String toString() {
        return "Villa{" +
                super.toString() +
                "roomStandard='" + roomStandard + '\'' +
                ", swimmingPoolArea=" + swimmingPoolArea +
                ", numOfFloor=" + numOfFloor +
                '}';
    }
}
