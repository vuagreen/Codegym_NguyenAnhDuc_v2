package Models;

import Commons.FunctionArrays;
import Commons.Sc;

public class House extends Services implements FunctionArrays {
    private String roomStandard;    //tiêu chuẩn phòng
    private String OtherDescription;    //tiện nghi
    private int numberFloors;   //số tầng
    private String regexId = "^SVHO-[\\d]{4}$";
    private String regexNumberFloors = "^[123456789][\\d]*$";
    private String regexRoomStandard = "^[A-Z][a-z\\s]*";

    public  House(){
    }

    public House(String id, String name, String usableUtility, int rentalCosts, int maxNumberPeople, String typeOfRent, String roomStandard, String otherDescription, int numberFloors) {
        super(id, name, usableUtility, rentalCosts, maxNumberPeople, typeOfRent);
        this.roomStandard = roomStandard;
        this.OtherDescription = otherDescription;
        this.numberFloors = numberFloors;
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

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }

    public void  setInput() {
        super.setId(Sc.input("Nhập vào id House: ","Bạn cần nhập đúng cú pháp id House:SVHO-YYYY.",this.regexId));
        super.addServices();
        this.setRoomStandard(Sc.input("nhập vào roomStandard: ","Bạn cần nhập ký tự đầu tiên viết hoa các ký tự tiếp theo viết thường.",this.regexRoomStandard));
        this.setOtherDescription(Sc.input("nhập vào OtherDescription: "));
        this.setNumberFloors(Integer.parseInt(Sc.input("nhập vào numberFloors: ","Bạn cần nhập vào số nguyên dương.",this.regexNumberFloors) ));
    }
   // @Override
    public String showInfor() {
        return "House{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", usableUtility='" + getUsableUtility() + '\'' +
                ", rentalCosts=" + getRentalCosts() +
                ", maxNumberPeople=" + getMaxNumberPeople() +
                ", typeOfRent='" + getTypeOfRent() + '\'' +
                ",roomStandard='" + getRoomStandard() + '\'' +
                ", OtherDescription='" + getOtherDescription() + '\'' +
                ", numberFloors=" + getNumberFloors() +
                "}";
    }
    @Override
    public FunctionArrays returnArraySetInput() {
        House house = new House();
        house.setInput();
        return house;
    }

    @Override
    public FunctionArrays stringToObject(String strHouse) {
        String[] arr = strHouse.split(",");
        House house = new House(arr[0], arr[1], arr[2], Integer.parseInt(arr[3]), Integer.parseInt(arr[4]), arr[5], arr[6], arr[7],  Integer.parseInt(arr[8]));
        return house;
    }

    @Override
    public String objectToString(FunctionArrays house) {
        String str = "";
        str += (((House) house).getId());
        str += ",";
        str += (((House) house).getName());
        str += ",";
        str += (((House) house).getUsableUtility());
        str += ",";
        str += (((House) house).getRentalCosts());
        str += ",";
        str += (((House) house).getMaxNumberPeople());
        str += ",";
        str += (((House) house).getTypeOfRent());
        str += ",";
        str += (((House) house).getRoomStandard());
        str += ",";
        str += (((House) house).getOtherDescription());
        str += ",";
        str += (((House) house).getNumberFloors());
        str += "\n";
        return str;
    }

}
