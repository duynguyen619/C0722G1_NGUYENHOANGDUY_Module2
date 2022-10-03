package Case_study_module2.model.facility;

public class Facility {
    private String idService;
    private String nameService;
    private double usableArea;
    private double rentalCosts;
    private int maximumNumOfPeople;
    private String rentalType;


    public Facility(String idService, String nameService, double usableArea, double rentalCosts, int maximumNumOfPeople, String rentalType) {
        this.idService = idService;
        this.nameService = nameService;
        this.usableArea = usableArea;
        this.rentalCosts = rentalCosts;
        this.maximumNumOfPeople = maximumNumOfPeople;
        this.rentalType = rentalType;
    }

    public String getInfoToCSV() {
        return this.idService +","+this.nameService +","+ this.usableArea +","+this.rentalCosts +","+ this.maximumNumOfPeople+","+this.rentalType;
    }
    public Facility() {
    }

    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public double getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(double usableArea) {
        this.usableArea = usableArea;
    }

    public double getRentalCosts() {
        return rentalCosts;
    }

    public void setRentalCosts(double rentalCosts) {
        this.rentalCosts = rentalCosts;
    }

    public int getMaximumNumOfPeople() {
        return maximumNumOfPeople;
    }

    public void setMaximumNumOfPeople(int maximumNumOfPeople) {
        this.maximumNumOfPeople = maximumNumOfPeople;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    @Override
    public String toString() {
        return "idService='" + idService + '\'' +
                "; nameService='" + nameService + '\'' +
                "; usableArea=" + usableArea +
                "; rentalCosts=" + rentalCosts +
                "; maximumNumOfPeople=" + maximumNumOfPeople +
                "; rentalType='" + rentalType ;
    }
}
