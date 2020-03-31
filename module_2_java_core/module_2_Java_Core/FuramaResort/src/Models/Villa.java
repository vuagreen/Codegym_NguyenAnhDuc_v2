package Models;

import Commons.FunctionArrays;
import Commons.Sc;

public class Villa extends Services implements  /* Comparable<Villa>,*/ FunctionArrays {
    private Sc sc = new Sc();
    private String roomStandard;    //tiêu chuẩn phòng
    private String OtherDescription;    //tiện nghi
    private String poolArea;    //diện tích hồ bơi
    private int numberFloors;   //số tầng
    private String regexId = "^SVVL-[\\d]{4}$";
    private String regexPoolArea = "^(([3456789][\\d])|([1-9][\\d]{2,}))[\\.]?[\\d]*$";
    private String regexNumberFloors = "^[123456789][\\d]*$";
    private String regexRoomStandard = "^[A-Z][a-z\\s]*";

    public Villa() {

    }

    public Villa(String id, String name, String usableUtility, int rentalCosts, int maxNumberPeople, String typeOfRent, String roomStandard, String otherDescription, String poolArea, int numberFloors) {
        super(id, name, usableUtility, rentalCosts, maxNumberPeople, typeOfRent);
        this.roomStandard = roomStandard;
        OtherDescription = otherDescription;
        this.poolArea = poolArea;
        this.numberFloors = numberFloors;
    }

    public void setInput() {
        String s = "gán vào file dữ liệu";
        super.setId(Sc.input("Nhập vào id Villa: ", "Bạn cần nhập đúng cú pháp id Villa:SVVL-YYYY.", this.regexId));
        super.addServices();
        this.setRoomStandard(Sc.input("nhập vào roomStandard: ", "Bạn cần nhập ký tự đầu tiên viết hoa các ký tự tiếp theo viết thường.", this.regexRoomStandard));
        this.setOtherDescription(Sc.input("nhập vào OtherDescription: "));
        this.setPoolArea(Sc.input("nhập vào poolArea: ", "Bạn cần nhập vào số thực lớn hơn 30.", this.regexPoolArea));
        this.setNumberFloors(Integer.parseInt(Sc.input("nhập vào numberFloors: ", "Bạn cần nhập vào số nguyên dương.", this.regexNumberFloors)));
    }


    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getOtherDescription() {
        return OtherDescription;
    }

    public void setOtherDescription(String otherDescription) {
        OtherDescription = otherDescription;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }

    //@Override
    public String showInfor() {
        return "Villa{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", usableUtility='" + getUsableUtility() + '\'' +
                ", rentalCosts=" + getRentalCosts() +
                ", maxNumberPeople=" + getMaxNumberPeople() +
                ", typeOfRent='" + getTypeOfRent() + '\'' +
                ",roomStandard='" + getRoomStandard() + '\'' +
                ", OtherDescription='" + getOtherDescription() + '\'' +
                ", poolArea='" + getPoolArea() + '\'' +
                ", numberFloors=" + getNumberFloors() +
                "}";
    }

    @Override
    public FunctionArrays returnArraySetInput() {
        Villa villa = new Villa();
        villa.setInput();
        return villa;
    }

    @Override
    public FunctionArrays stringToObject(String strVilla) {
        String[] arr = strVilla.split(",");
        Villa villa = new Villa(arr[0], arr[1], arr[2], Integer.parseInt(arr[3]), Integer.parseInt(arr[4]), arr[5], arr[6], arr[7], arr[8], Integer.parseInt(arr[9]));
        return villa;
    }

    @Override
    public String objectToString(FunctionArrays villa) {
        String str = "";
        str += (((Villa) villa).getId());
        str += ",";
        str += (((Villa) villa).getName());
        str += ",";
        str += (((Villa) villa).getUsableUtility());
        str += ",";
        str += (((Villa) villa).getRentalCosts());
        str += ",";
        str += (((Villa) villa).getMaxNumberPeople());
        str += ",";
        str += (((Villa) villa).getTypeOfRent());
        str += ",";
        str += (((Villa) villa).getRoomStandard());
        str += ",";
        str += (((Villa) villa).getOtherDescription());
        str += ",";
        str += (((Villa) villa).getPoolArea());
        str += ",";
        str += (((Villa) villa).getNumberFloors());
        str += "\n";
        return str;
    }
}
