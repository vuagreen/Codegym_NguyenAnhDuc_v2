package CaseStudy_Module2.Models;

public abstract class Service {
    private String id;
    private String nameService;
    private double areaUsed; //Dien Tich Su Dung
    private double rentalCosts;//Chi Phi Thue
    private int maxNumberOfPeople;// So Nguoi Toi Da
    private String typeRent; //Kieu thue

    public Service() {
    }

    public Service(String id, String nameService, double areaUsed, double rentalCosts, int maxNumberOfPeople, String typeRent) {
        this.id = id;
        this.nameService = nameService;
        this.areaUsed = areaUsed;
        this.rentalCosts = rentalCosts;
        this.maxNumberOfPeople = maxNumberOfPeople;
        this.typeRent = typeRent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public double getAreaUsed() {
        return areaUsed;
    }

    public void setAreaUsed(double areaUsed) {
        this.areaUsed = areaUsed;
    }

    public double getRentalCosts() {
        return rentalCosts;
    }

    public void setRentalCosts(double rentalCosts) {
        this.rentalCosts = rentalCosts;
    }

    public int getMaxNumberOfPeople() {
        return maxNumberOfPeople;
    }

    public void setMaxNumberOfPeople(int maxNumberOfPeople) {
        this.maxNumberOfPeople = maxNumberOfPeople;
    }

    public String getTypeRent() {
        return typeRent;
    }

    public void setTypeRent(String typeRent) {
        this.typeRent = typeRent;
    }

    public String showInfor() {
        return "\n Id Service : " + getId() +
                "\nName Service : " + getNameService() +
                "\nArea Used : " + getAreaUsed() +
                "\nRental Costs : " + getRentalCosts() +
                "\nMax Number Of People : " + getMaxNumberOfPeople() +
                "\nType Rent : " + getTypeRent();
    }

    ;
}
