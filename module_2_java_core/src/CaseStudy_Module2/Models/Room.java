package CaseStudy_Module2.Models;

public class Room extends Service {
    private String freeService;

    public Room() {
    }

    public Room(String id, String nameService, double areaUsed, double rentalCosts, int maxNumberOfPeople, String typeRent, String freeService) {
        super(id, nameService, areaUsed, rentalCosts, maxNumberOfPeople, typeRent);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    public String showInfor() {
        return super.showInfor() +
                "\nFree Service : " + getFreeService();

    }
}
