package CaseStudy_Module2.Models;

public class Villa extends Service {
    private String roomStandard;//Tieu Chuan Phong
    private String convenient;//Tien Nghi Khac
    private double areaPool;//Dien Tich Ho Boi
    private int numberOfFloors;//So Tang

    public Villa() {
    }

    public Villa(String id, String nameService, double areaUsed, double rentalCosts, int maxNumberOfPeople, String typeRent, String roomStandard, String convenient, double areaPool, int numberOfFloors) {
        super(id, nameService, areaUsed, rentalCosts, maxNumberOfPeople, typeRent);
        this.roomStandard = roomStandard;
        this.convenient = convenient;
        this.areaPool = areaPool;
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

    public double getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(double areaPool) {
        this.areaPool = areaPool;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String showInfor() {
        return super.showInfor() +
                "\nRoom Standard : " + getRoomStandard() +
                "\nConvenient :" + getConvenient() +
                "\nArea Pool : " + getAreaPool() +
                "\nNumber Of Floods : " + getNumberOfFloors();
    }
}
