package CaseStudy_Module2.Models;

public class House extends Service {
    private String roomStandard;//Tieu Chuan Phong
    private String convenient;//Tien Nghi Khac
    private int numberOfFloors;//So Tang

    public House() {
    }

    public House(String id, String nameService, double areaUsed, double rentalCosts, int maxNumberOfPeople, String typeRent, String roomStandard, String convenient, int numberOfFloors) {
        super(id, nameService, areaUsed, rentalCosts, maxNumberOfPeople, typeRent);
        this.roomStandard = roomStandard;
        this.convenient = convenient;
        this.numberOfFloors = numberOfFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getConvenient() {
        return convenient;
    }

    public void setConvenient(String convenient) {
        this.convenient = convenient;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String showInfor() {
        return super.showInfor() +
                "\nRoom Standard : " + getRoomStandard() +
                "\nConvenient : " + getConvenient() +
                "\nNumber Of Floors : " + getNumberOfFloors();
    }
}
