package Case_study_module2.model.facility;

public class Room extends Facility {
    private String freeService;

    public Room() {
    }

    public Room(String idService, String nameService, double usableArea, double rentalCosts, int maximumNumOfPeople, String rentalType, String freeService) {
        super(idService, nameService, usableArea, rentalCosts, maximumNumOfPeople, rentalType);
        this.freeService = freeService;
    }

    public Room(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String getInfoToCSV() {
        return super.getInfoToCSV()+","+this.freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return "Room{" +
                super.toString() +
                " ;freeService='" + freeService + '\'' +
                '}';
    }
}
