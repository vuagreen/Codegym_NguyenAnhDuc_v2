package CaseStudy_Module2.Controllers;

import CaseStudy_Module2.Commons.FuncValidation;
import CaseStudy_Module2.Commons.FuncWirteAndReadFileCSV;
import CaseStudy_Module2.Models.*;
import com.sun.org.apache.bcel.internal.generic.SWITCH;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class MainController {
    private static Scanner sc = new Scanner(System.in);

    public static void disPlayMainMenu() {
        System.out.println(
                "\n1.Add New Service. " +
                        "\n2.Show Service. " +
                        "\n3.Add New Customer. " +
                        "\n4.Show Information Of Customer. " +
                        "\n5.Add New Booking. " +
                        "\n6.Show Information Of Employee. " +
                        "\n7.Exit ");
        switch (Integer.parseInt(sc.nextLine())) {
            case 1:
                addNewService();
                break;
            case 2:
                showService();
                break;
            case 3:
                addNewCustomer();
                break;
            case 4:
                showInformationCustomers();
                break;
            case 7:
                System.exit(0);
            default:
                System.out.println("\nErro. Back to Menu");
                backMainMenu();
        }
    }

    public static void backMainMenu() {
        System.out.println("Enter to Continue ... ");
        sc.nextLine();
        System.out.println("\n-----------------------------");
        disPlayMainMenu();
    }

    public static void addNewService() {
        System.out.println("\n-----------------------------");
        System.out.println("\n1.Add New Villa. " +
                "\n2.Add New House. " +
                "\n3.Add New Room " +
                "\n4.Back to Menu" +
                "\nPlease select : ");
        switch (Integer.parseInt(sc.nextLine())) {

            case 1:
                addNewVilla();
                break;
            case 2:
                addNewHouse();
                break;
            case 3:
                addNewRoom();
                break;
            case 4:
                backMainMenu();
            default:
                System.out.println("\nErro. Back to Menu");
                backMainMenu();
        }


    }

    public static void addNewVilla() {
        String content = "";
        String errMes = "";
        Service villa = new Villa();
        addNewService(villa);
        System.out.println("Enter Room Standard : ");
        ((Villa) villa).setRoomStandard(sc.nextLine());
        while (!FuncValidation.checkNameService(((Villa) villa).getRoomStandard())) {
            System.out.println("Room Standard is Invalid");
            System.out.println("Enter Room Standard : ");
            ((Villa) villa).setRoomStandard(sc.nextLine());
        }
        System.out.println(" Enter Convenient : ");
        ((Villa) villa).setConvenient(sc.nextLine());
        while (!FuncValidation.checkNameService(((Villa) villa).getConvenient())) {
            System.out.println("Convenient is Invalid");
            System.out.println("Enter Convenient : ");
            ((Villa) villa).setConvenient(sc.nextLine());
        }
        content = "Enter Area Pool : ";
        errMes = "Area pool >30, Area Pool Must Be A Double";
        ((Villa) villa).setAreaPool(FuncValidation.checkNumberDouble(content, errMes));
        while (((Villa) villa).getAreaPool() <= 30) {
            System.out.println(errMes);
            ((Villa) villa).setAreaPool(FuncValidation.checkNumberDouble(content, errMes));
        }
        content = "Enter Number Of Floor: ";
        errMes = "Number Of Floor > 0, Number Of Floor Must Be A Integer";
        ((Villa) villa).setNumberOfFloors(FuncValidation.checkNumberInteger(content, errMes));
        while (((Villa) villa).getNumberOfFloors() < 0) {
            System.out.println(errMes);
            ((Villa) villa).setNumberOfFloors(FuncValidation.checkNumberInteger(content, errMes));
        }

        //Write File
        ArrayList<Villa> listVilla = FuncWirteAndReadFileCSV.getVillaFromCSV();
        listVilla.add((Villa) villa);
        FuncWirteAndReadFileCSV.writeVillaToFileCSV(listVilla);
        System.out.println("\nAdd Villa : " + villa.getNameService() + "Success !");
        backMainMenu();

    }

    public static void addNewHouse() {
        Service house = new House();
        addNewService(house);
        System.out.println("Enter Room Standard : ");
        ((House) house).setRoomStandard(sc.nextLine());
        while (!FuncValidation.checkNameService(((House) house).getRoomStandard())) {
            System.out.println("Room Standard is Invalid");
            System.out.println("Enter Room Standard : ");
            ((House) house).setRoomStandard(sc.nextLine());
        }
        System.out.println(" Enter Convenient : ");
        ((House) house).setConvenient(sc.nextLine());
        while (!FuncValidation.checkNameService(((House) house).getConvenient())) {
            System.out.println(" Convenient is Invalid");
            System.out.println("Enter Convenient : ");
            ((House) house).setConvenient(sc.nextLine());
        }
        String content = "Enter Number Of Floors :";
        String errMes = "Number Of Floor >0 , Number Of Floor Is Integer";
        ((House) house).setNumberOfFloors(FuncValidation.checkNumberInteger(content, errMes));
        while (((House) house).getNumberOfFloors() <= 30) {
            System.out.println(errMes);
            ((House) house).setNumberOfFloors(FuncValidation.checkNumberInteger(content, errMes));
        }
        //Write File
        ArrayList<House> listHouse = FuncWirteAndReadFileCSV.getHouseFromCSV();
        listHouse.add((House) house);
        FuncWirteAndReadFileCSV.writeHouseToFileCSV(listHouse);
        System.out.println("\nAdd House : " + house.getNameService() + "Success !");
        backMainMenu();
    }

    public static void addNewRoom() {
        Service room = new Room();
        addNewService(room);
        System.out.println(" Enter Free Service : ");
        ((Room) room).setFreeService(sc.nextLine());
        while (!FuncValidation.checkFreeService(((Room) room).getFreeService())) {
            System.out.println("Free Service : massage, karaoke, food, drink, car ");
            System.out.println("Enter Free Service : ");
            ((Room) room).setFreeService(sc.nextLine());
        }
        //Write File
        ArrayList<Room> listRoom = FuncWirteAndReadFileCSV.getRoomFromCSV();
        listRoom.add((Room) room);
        FuncWirteAndReadFileCSV.writeRoomToFileCSV(listRoom);
        ;
        System.out.println("\nAdd House : " + room.getNameService() + "Success !");
        backMainMenu();
    }

    private static Service addNewService(Service service) {
        String content = "";
        String errMes = "";
        service.setId(UUID.randomUUID().toString().replace("-", ""));
        System.out.println("Enter Name Services: ");
        service.setNameService(sc.nextLine());
        //Check Name Service
        while (!FuncValidation.checkNameService(service.getNameService())) {
            System.out.println("Name Service is Invalid");
            System.out.println("Enter Name Services: ");
            service.setNameService(sc.nextLine());
        }
        //Add & Check Area
        content = "Enter Area Used : ";
        errMes = "Area >30 , Area Must Be A Double ";
        service.setAreaUsed(FuncValidation.checkNumberDouble(content, errMes));
        while (service.getAreaUsed() <= 30) {
            System.out.println(errMes);
            service.setAreaUsed(FuncValidation.checkNumberDouble(content, errMes));
        }
        //Check Rental Costs
        content = "Enter Rental Costs : ";
        errMes = "Rental Costs > 0 , Rental Costs Must Be A Double ";
        service.setRentalCosts(FuncValidation.checkNumberDouble(content, errMes));
        while (service.getRentalCosts() < 0) {
            System.out.println(errMes);
            service.setRentalCosts(FuncValidation.checkNumberDouble(content, errMes));
        }
        //Check Number People
        content = "Enter Number People : ";
        errMes = "0 < Number People < 20 , Number People Must Be A Integer ";
        service.setMaxNumberOfPeople(FuncValidation.checkNumberInteger(content, errMes));
        while (service.getMaxNumberOfPeople() < 0 || service.getMaxNumberOfPeople() > 20) {
            System.out.println(errMes);
            service.setMaxNumberOfPeople(FuncValidation.checkNumberInteger(content, errMes));
        }
        //Check Valid Type Rent
        sc.nextLine();
        System.out.println("Enter Type Rent: ");
        service.setTypeRent(sc.nextLine());
        while (!FuncValidation.checkNameService(service.getTypeRent())) {
            System.out.println("Type Rent is Invalid");
            System.out.println("Enter Type Rent: ");
            service.setTypeRent(sc.nextLine());
        }
        return service;
    }

    public static void showService() {
        System.out.println("\n-----------------------------");
        System.out.println("\n1.Show Villa. " +
                "\n2.Show House. " +
                "\n3.Show Room " +
                "\n4.Back to Menu" +
                "\nPlease select : ");
        switch (Integer.parseInt(sc.nextLine())) {

            case 1:
                showVilla();
                break;
            case 2:
                showHouse();
                break;
            case 3:
                showRoom();
                break;
            case 4:
                backMainMenu();
            default:
                System.out.println("\nErro. Back to Menu");
                backMainMenu();
        }
    }

    public static void showVilla() {
        ArrayList<Villa> listVilla = FuncWirteAndReadFileCSV.getVillaFromCSV();
        for (Villa villa : listVilla) {
            System.out.println("\n-----------------------------");
            System.out.println(villa.showInfor());
            System.out.println("\n-----------------------------");
        }

    }

    public static void showHouse() {
        ArrayList<House> listHouse = FuncWirteAndReadFileCSV.getHouseFromCSV();
        for (House house : listHouse) {
            System.out.println("\n-----------------------------");
            System.out.println(house.showInfor());
            System.out.println("\n-----------------------------");
        }

    }

    public static void showRoom() {
        ArrayList<Room> listRoom = FuncWirteAndReadFileCSV.getRoomFromCSV();
        for (Room room : listRoom) {
            System.out.println("\n-----------------------------");
            System.out.println(room.showInfor());
            System.out.println("\n-----------------------------");
        }

    }

    public static void addNewCustomer() {
        String content = "";
        String errMes = "";
        Customer customer = new Customer();
        System.out.println(" Enter Name Customer :");
        customer.setNameCustomer(sc.nextLine());
        while (!FuncValidation.checkNameService(customer.getNameCustomer())) {
            System.out.println("Name Customer Is Not Valid");
            System.out.println(" Enter Name Customer :");
            customer.setNameCustomer(sc.nextLine());
        }
        System.out.println("Enter Birthday Customer : (DD/MM/YYYY)");
        customer.setBirthdayCustomer(sc.nextLine());
        String data;
        Integer year,day,month;
        data = customer.getBirthdayCustomer();
        year = Integer.parseInt(data.substring(6, 10));
        day = Integer.parseInt(data.substring(0, 2));
        month = Integer.parseInt(data.substring(3, 5));
        System.out.println(year);
        while (year < 1900 || year > 2002||day < 0 || day > 31||month < 1 || month > 12) {
            System.out.println("Enter Birthday Customer : 2002> Year >1900");
            customer.setBirthdayCustomer(sc.nextLine());
            data = customer.getBirthdayCustomer();
            year = Integer.parseInt(data.substring(6, 10));
            day = Integer.parseInt(data.substring(0, 2));
            month = Integer.parseInt(data.substring(3, 5));
            System.out.println(year);
        }
        while (!FuncValidation.checkBirthday(customer.getBirthdayCustomer())) {
            System.out.println("Enter Birthday Customer! : (DD/MM/YYYY)");
            customer.setBirthdayCustomer(sc.nextLine());
        }
        //Check sex
        System.out.println("Sex : (Male|Famale|Unknow ");
        customer.setSexCustomer(sc.nextLine());
        String sex;
        sex = customer.getSexCustomer();
        while (!sex.equalsIgnoreCase("male")) {
            System.out.println("Sex : (Male|Famale|Unknow ");
            customer.setSexCustomer(sc.nextLine());
            sex = customer.getSexCustomer();
            System.out.println(sex);
        }
        sex = sex.toLowerCase();
        System.out.println(sex);
        sex = sex.substring(0, 1).toUpperCase() + sex.substring(1, sex.length());
        customer.setSexCustomer(sex);
        System.out.println(sex);
        content = "Enter IDCard :";
        errMes = "IDCard = XXXXXXXXX, IDCard Is INT";
        customer.setIdCardCustomer(FuncValidation.checkNumberInteger(content, errMes));
        while (customer.getIdCardCustomer() > 999999999 || customer.getIdCardCustomer() < 100000000) {
            System.out.println(errMes);
            customer.setIdCardCustomer(FuncValidation.checkNumberInteger(content, errMes));

        }
        System.out.println("Enter Phone Number: ");
        customer.setPhoneNumber(sc.nextInt());
        System.out.println("Enter Email : ");
        customer.setEmailCustomer(sc.nextLine());
        while (!FuncValidation.checkEmail(customer.getEmailCustomer())) {
            System.out.println("Erro");
            System.out.println("Enter Email : ");
            customer.setEmailCustomer(sc.nextLine());
        }
        System.out.println("Enter Type Customer : ");
        customer.setTypeCustomer(sc.nextLine());
        sc.nextLine();
        System.out.println("Enter Address : ");
        customer.setAddressCustomer(sc.nextLine());

        //Write File
        ArrayList<Customer> listCustomer = FuncWirteAndReadFileCSV.getCustomerFromCSV();
        listCustomer.add((Customer) customer);
        FuncWirteAndReadFileCSV.writeCustomerToFileCSV(listCustomer);
        System.out.println("\nAdd Customer : " + customer.getNameCustomer() + "Success !");
        backMainMenu();
    }

    public static void showInformationCustomers() {
        ArrayList<Customer> listCustomer = FuncWirteAndReadFileCSV.getCustomerFromCSV();
        for (Customer customer : listCustomer) {
            System.out.println("\n-----------------------------");
            System.out.println(customer.showInfor());
            System.out.println("\n-----------------------------");
        }

    }
}
