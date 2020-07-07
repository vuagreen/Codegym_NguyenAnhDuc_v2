package Models;

import Commons.Sc;

public class Services{
    private String id;
    private String name;
    private String usableUtility;
    private int rentalCosts;
    private int maxNumberPeople;
    private String typeOfRent;
    private String regexName = "^[A-Z][a-z0-9\\s]*";
    private String regexRentalCosts = "^[1-9][\\d]*$";
    private String regexMaxNumberPeople = "^([123456789]|([1][\\d]))";
    private String regexTypeOfRent = "^[A-Z][a-z\\s]*";

    public Services(){

    }

    public Services(String id, String name, String usableUtility, int rentalCosts, int maxNumberPeople, String typeOfRent) {
        this.id = id;
        this.name = name;
        this.usableUtility = usableUtility;
        this.rentalCosts = rentalCosts;
        this.maxNumberPeople = maxNumberPeople;
        this.typeOfRent = typeOfRent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsableUtility() {
        return usableUtility;
    }

    public void setUsableUtility(String usableUtility) {
        this.usableUtility = usableUtility;
    }

    public int getRentalCosts() {
        return rentalCosts;
    }

    public void setRentalCosts(int rentalCosts) {
        this.rentalCosts = rentalCosts;
    }

    public int getMaxNumberPeople() {
        return maxNumberPeople;
    }

    public void setMaxNumberPeople(int maxNumberPeople) {
        this.maxNumberPeople = maxNumberPeople;
    }

    public String getTypeOfRent() {
        return typeOfRent;
    }

    public void setTypeOfRent(String typeOfRent) {
        this.typeOfRent = typeOfRent;
    }

    public void addServices(){
        this.setName(Sc.input("nhập vào name: ","Bạn cần nhập ký tự đầu tiên viết hoa các ký tự tiếp theo viết thường.",this.regexName));
        this.setUsableUtility(Sc.input("nhập vào usableUtility: "));
        this.setRentalCosts(Integer.parseInt(Sc.input("nhập vào rentalCosts: ","Bạn cần nhập vào số nguyên dương.", regexRentalCosts)));
        this.setMaxNumberPeople(Integer.parseInt(Sc.input("nhập vào maxNumberPeople: ","Bạn cần nhập vào số >0 và <20.", regexMaxNumberPeople)));
        this.setTypeOfRent(Sc.input("nhập vào typeOfRent: ","Bạn cần nhập ký tự đầu tiên viết hoa các ký tự tiếp theo viết thường.",regexTypeOfRent));
    }

    public String showInfor() {
        return "Services{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", usableUtility='" + usableUtility + '\'' +
                ", rentalCosts=" + rentalCosts +
                ", maxNumberPeople=" + maxNumberPeople +
                ", typeOfRent='" + typeOfRent + '\'' +
                '}';
    }
    @Override
    public String toString() {
        return "Services{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", usableUtility='" + usableUtility + '\'' +
                ", rentalCosts=" + rentalCosts +
                ", maxNumberPeople=" + maxNumberPeople +
                ", typeOfRent='" + typeOfRent + '\'' +
                '}';
    }
}
