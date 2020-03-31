package Models;

import Commons.FunctionArrays;
import Commons.Sc;

public class Room extends Services implements FunctionArrays{
    private boolean freeBundledServices;
    private String regexId = "^SVRO-[\\d]{4}$";
    private String regexBooblean = "^(true)|(false)$";

    public Room(){

    }

    public Room(String id, String name, String usableUtility, int rentalCosts, int maxNumberPeople, String typeOfRent, boolean freeBundledServices) {
        super(id, name, usableUtility, rentalCosts, maxNumberPeople, typeOfRent);
        this.freeBundledServices = freeBundledServices;
    }

    public boolean isFreeChaperones() {
        return freeBundledServices;
    }

    public void setFreeChaperones(boolean freeBundledServices) {
        this.freeBundledServices = freeBundledServices;
    }

    public void  setInput() {
        super.setId(Sc.input("Nhập vào id Room: ","Bạn cần nhập đúng cú pháp id Room:SVRO-YYYY.",this.regexId));
        super.addServices();
        this.setFreeChaperones(Boolean.parseBoolean(Sc.input("nhập vào roomStandard: ","Bạn cần nhập vào true hoặc false.",this.regexBooblean)) );
    }

//    public Room setInput1() {
//        Room room = new Room();
//        room.setInput();
//        return room;
//    }

//    public Room addRoom() {
//        Room room = new Room();
//        ReadAndWriteCSV readAndWriteCSV = new ReadAndWriteCSV();
//        final String fileNameVilla = "FuramaResort/src/Data/house.csv";
//        String strPleaseEnterNumber = "Bạn đã nhập vào không phải là số vui lòng hãy nhập số nguyên:";
//        String s = "gán vào file dữ liệu";
//        //super.addServices(room);
//        room.setFreeChaperones(Input.inputBoolean("nhập vào roomStandard: "));
//        readAndWriteCSV.writeCSV(fileNameVilla, room.showInfor());
//        return room;
//    }

    //@Override
    public String showInfor() {
        return "Room{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", usableUtility='" + getUsableUtility() + '\'' +
                ", rentalCosts=" + getRentalCosts() +
                ", maxNumberPeople=" + getMaxNumberPeople() +
                ", typeOfRent='" + getTypeOfRent() + '\'' +
                ",freeBundledServices='" + this.freeBundledServices + '\'' +
                "}";
    }

    @Override
    public FunctionArrays returnArraySetInput() {
        Room room = new Room();
        room.setInput();
        return room;
    }

    @Override
    public FunctionArrays stringToObject(String strRoom) {
        String[] arr = strRoom.split(",");
        Room room = new Room(arr[0], arr[1], arr[2], Integer.parseInt(arr[3]), Integer.parseInt(arr[4]), arr[5], Boolean.parseBoolean(arr[6]));
        return room;
    }

    @Override
    public String objectToString(FunctionArrays room) {
        String str = "";
        str += (((Room) room).getId());
        str += ",";
        str += (((Room) room).getName());
        str += ",";
        str += (((Room) room).getUsableUtility());
        str += ",";
        str += (((Room) room).getRentalCosts());
        str += ",";
        str += (((Room) room).getMaxNumberPeople());
        str += ",";
        str += (((Room) room).getTypeOfRent());
        str += ",";
        str += (((Room) room).isFreeChaperones());
        str += "\n";
        return str;
    }
}
