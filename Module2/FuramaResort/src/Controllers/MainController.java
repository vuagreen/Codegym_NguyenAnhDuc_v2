package Controllers;

import DAO.FunValidation;
import DAO.JDBC;
import Models.*;

import javax.rmi.CORBA.Util;
import java.sql.Date;
import java.util.Scanner;

public class MainController {
    static Scanner scanner = new Scanner(System.in);
    static JDBC JDBC = new JDBC();
    int a;
    public static String regexName = "^([A-Z][a-z]+)( [A-Z][a-z]+)*$";
    public static String regexEmailException = "^\\w+@\\w+.\\w+$";
    public static String regexSex = "^(male)|(female)|(unknown)$";
    public static String regexPhoneNumberException = "^[0-9]{10}$";
    public static String regexcmnd = "^[0-9]{9}$";
    public static String regexBirthDayException = "^([0-2][0-9]|(3)[0-1])(\\/)((0)[0-9]|((1)[0-2]))(\\/)[1]{1}[9]{1}[3-9]{1}[0-9]{1}|[2]{1}[0]{1}[0-1]{1}[0-9]{1}$";

    public void displayMainMenu() {
        String choice;
        System.out.println("FURAMA RESORT MENU");
        System.out.println("---------------------------");
        System.out.println("1. Add New Services\n" +
                "2. Show Services\n" +
                "3. Add New Customer\n" +
                "4. Show Information Customer\n" +
                "5. Add New Booking Resort\n" +
                "6. Show Information Employee\n" +
                "7. Exit");
        System.out.print("Enter your choice: ");
        choice = scanner.nextLine();
        switch (choice) {
            case "1": {
                AddNewService();
                break;
            }
            case "2": {
                menuShowService();
                break;
            }
            case "3": {
                addNewCustomer();
                break;
            }
            case "4": {
                showInfoCustomer();
                break;
            }
            case "5": {
                addNewBooking();
                backToMenu();
                break;
            }
            case "6":
                showInfoEmployee();
                backToMenu();
                break;
            case "10":
            case "8":
                JDBC.selectAllBooking();
                backToMenu();
                break;
            case "9":
            case "7": {
                JDBC.disConnection();
                System.out.println("CLOSE------>>>>>");
                System.exit(0);
            }
            default: {
                displayMainMenu();
            }
        }
    }

    private void showInfoEmployee() {
        JDBC.selectAllEmployee("SELECT * FROM employee");
        backToMenu();
    }

    public void backToMenu() {
        System.out.println("Enter to back to menu...");
        scanner.nextLine();
        displayMainMenu();
    }

    private void addNewBooking() {
        Boolean check;
        Booking booking = new Booking();
        String number;
        JDBC.selectAllCustomer("SELECT * FROM customer");
        System.out.print(" \n Customer ID : ");
        booking.setId_customer(Integer.parseInt(scanner.nextLine()));
        System.out.println(
                "1.Booking Villa " +
                        "\n2.Booking House" +
                        "\n3.Booking Room");
        number = scanner.nextLine();
        switch (number) {
            case "1":
                JDBC.selectAllVilla("SELECT * FROM villa");
                System.out.println("STATUS ->>>");
                JDBC.selectIdBooking();
                booking.setId_villa(bookVilla());
                JDBC.reset();
                break;
            case "2":
                JDBC.selectAllHouse("SELECT * FROM house");
                JDBC.selectIdBooking();
                System.out.println("Enter ID ");
                booking.setId_house(Integer.parseInt(scanner.nextLine()));
                break;
            case "3":
                JDBC.selectAllRoom("SELECT * FROM room");
                JDBC.selectIdBooking();
                System.out.println("Enter ID ");
                booking.setId_room(Integer.parseInt(scanner.nextLine()));
                break;
            default:
                System.out.println("ERRO");
                addNewBooking();
        }
        booking.setId_services(showServices());
        java.util.Date date = new java.util.Date();
        java.sql.Date dates = convertUtilToSql(date);
        booking.setDay(dates);
        check = JDBC.checkID2("SELECT * FROM services", "id_services", booking.getId_services());
        while (!check) {
            System.out.println("ID Không Tồn Tại, Mời Bạn Nhập Lại :");
            booking.setId_services(showServices());
            check = JDBC.checkID2("SELECT * FROM services", "id_services", booking.getId_services());
        }
        System.out.println("Ngày Thuê");
        booking.setRentday(FunValidation.checkValidateNumberInt("Ngày Thuê", "Ngày Thuê là kiểu Nguyên "));
        while (booking.getRentday() < 1) {
            System.out.println("ngày thuê phải > 0");
            booking.setRentday(FunValidation.checkValidateNumberInt("Ngày Thuê", "Ngày Thuê là kiểu Nguyên "));
        }
        JDBC.insertBooking(booking);
    }

    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

    public int bookVilla() {
        a = 0;
        Boolean check;
        System.out.println("Enter ID ");
        a = FunValidation.checkValidateNumberInt("Enter ID", "ID là số nguyên , Mời Bạn nhập lại :  ");
        check = JDBC.checkID2("SELECT * FROM villa", "id_villa", a);
        while (!check) {
            System.out.println("Villa này không tồn tại, mời bạn chọn lại :");
            a = bookVilla();
            check = JDBC.checkID2("SELECT * FROM villa", "id_villa", a);
        }
        if (JDBC.checkIdVilla(a)) {
            System.out.println("Villa Này Đang Sử Dụng");
            a = bookVilla();
        }
        return a;
    }

    public int showServices() {
        JDBC.selectAllServices("SELECT * FROM services");
        System.out.println("Enter ID ");
        return FunValidation.checkValidateNumberInt("Enter ID", "ID Phải Là Số Nguyên, Mời Bạn Nhập Lại");
    }

    private void showInfoCustomer() {
        JDBC.selectAllCustomer("SELECT * FROM customer");
        backToMenu();
    }

    private void addNewCustomer() {
        String content = "";
        String errMes = "";
        Customer customer = new Customer();
        content = "Nhập Tên Customer :";
        errMes = "Sai Định Dạng !!";
        customer.setTenCustomer(FunValidation.checkValidate(content, errMes, regexName));
        content = "Nhập Ngày Sinh Customer :";
        errMes = "Sai Định Dạng !!";
        customer.setNgaySinh(FunValidation.checkValidate(content, errMes, regexBirthDayException));
        content = "Giới tính :";
        errMes = "Sai Định Dạng !!";
        customer.setGioiTinh(FunValidation.checkValidate(content, errMes, regexSex));
        content = "CMND :";
        errMes = "Sai Định Dạng !!";
        customer.setCmnd(Integer.parseInt(FunValidation.checkValidate(content, errMes, regexcmnd)));
        content = "Nhập Số Điện THoại :";
        errMes = "Sai Định Dạng !!";
        customer.setSoDienTHoai(Integer.parseInt(FunValidation.checkValidate(content, errMes, regexPhoneNumberException)));
        content = "Email :";
        errMes = "Sai Định Dạng !!";
        customer.setEmail(FunValidation.checkValidate(content, errMes, regexEmailException));
        customer.setLoaiKhach(loaiKhach());
        System.out.println("Địa Chỉ : ");
        customer.setDiaChi(scanner.nextLine());
        JDBC.insertCustomer(customer);
        System.out.println("Add Customer success !!");
        backToMenu();
    }

    private void menuShowService() {
        System.out.println("\n1. Show All Villa. " +
                "\n2. Show All House. " +
                "\n3. Show All Room. " +
                "\n4. Show All Name Villa Not Duplicate. " +
                "\n5. Show All Name House Not Duplicate. " +
                "\n6. Show All Name Name Not Duplicate. " +
                "\n7. Back to menu. " +
                "\n8. Exit . "
        );
        switch (scanner.nextLine()) {
            case "1":
                JDBC.selectAllVilla("SELECT * FROM villa");
                backToMenu();
                break;
            case "2":

                JDBC.selectAllHouse("SELECT * FROM house");
                backToMenu();
                break;
            case "3":
                JDBC.selectAllRoom("SELECT * FROM room");
                backToMenu();
                break;
            case "4":
                JDBC.selectAllVilla("SELECT DISTINCT * FROM villa");
                backToMenu();
                break;
            case "5":
                JDBC.selectAllHouse("SELECT DISTINCT* FROM house");
                backToMenu();
                break;
            case "6":
                JDBC.selectAllRoom("SELECT DISTINCT* FROM room");
                backToMenu();
                break;
            case "7":
                displayMainMenu();
                break;
            case "8":
                System.exit(0);
            default:
                backToMenu();

        }
    }

    private void AddNewService() {
        int choice;
        System.out.println("1. Add New Villa\n" +
                "2. Add New House\n" +
                "3. Add New Room\n" +
                "4. Back to menu\n" +
                "5. Exit");
        System.out.print("Input your choice: ");
        choice = scanner.nextInt();
        switch (choice) {
            case 1: {
                addNewVilla();
                break;
            }
            case 2: {
                addNewHouse();
                break;
            }
            case 3: {
                addRoom();
                break;
            }

            case 4: {
                backToMenu();
                break;
            }
            default: {
                System.exit(0);
            }
        }
    }

    private static Services addNewService(Services service) {
        String content = "";
        String errMes = "";
        System.out.println("Nhập Tên Dịch Vụ : ");
        scanner.nextLine();
        service.setTenDichVu(scanner.nextLine());
        while (!FunValidation.checkNameService(service.getTenDichVu())) {
            System.out.println("Tên dịch vụ sai định dạng, mời bạn nhập lại :");
            service.setTenDichVu(scanner.nextLine());
        }
        content = " Save Success!!";
        errMes = "Diện tích sử dụng là số thực và phải >30 ";
        System.out.println("Diện Tích Sử Dụng :");
        service.setDienTichSuDung(FunValidation.checkValidateNumberDouble(content, errMes));
        while (service.getDienTichSuDung() <= 30) {
            System.out.println(errMes);
            service.setDienTichSuDung(FunValidation.checkValidateNumberDouble(content, errMes));
        }
        System.out.println("Chi Phí Thuê :");
        content = " Save Success!!";
        errMes = "Chi phí thuê phải >0 ";
        service.setChiPhiThue(FunValidation.checkValidateNumberDouble(content, errMes));
        while (service.getChiPhiThue() < 1) {
            System.out.println(errMes);
            service.setChiPhiThue(FunValidation.checkValidateNumberDouble(content, errMes));
        }
        content = " Save Success!!";
        errMes = "Số lượng người tối đa phải >0 và nhỏ hơn <20 ";
        System.out.println("Số Người Tối Đa :");
        service.setSoNguoiToiDa(FunValidation.checkValidateNumberInt(content, errMes));
        while (service.getSoNguoiToiDa() < 1 || service.getSoNguoiToiDa() > 20) {
            System.out.println(errMes);
            service.setSoNguoiToiDa(FunValidation.checkValidateNumberInt(content, errMes));
        }
        System.out.println("Nhập Kiểu Thuê :");
        service.setKieuThue(scanner.nextLine());
        while (!FunValidation.checkNameService(service.getKieuThue())) {
            System.out.println("Kiểu Thuê sai định dạng, mời bạn nhập lại :");
            service.setKieuThue(scanner.nextLine());
        }
        return service;
    }

    private void addNewVilla() {
        String content = "";
        String errMes = "";
        Services villa = new Villa();
        addNewService(villa);
        System.out.println(" Tiêu Chuẩn Phòng : ");
        ((Villa) villa).setTieuChuanPhong(scanner.nextLine());
        while (!FunValidation.checkNameService(((Villa) villa).getTieuChuanPhong())) {
            System.out.println("Tiêu Chuẩn Phòng sai định dạng, mời bạn nhập lại :");
            ((Villa) villa).setTieuChuanPhong(scanner.nextLine());
        }
        System.out.println("Tiện Nghi Khác : ");
        ((Villa) villa).setTienNghiKhac(scanner.nextLine());
        content = " Save Success!!";
        errMes = "Diện tích hồ bơi phải và số thực lớn hơn 30 ";
        System.out.println("Diện Tích Hồ Bơi : ");
        ((Villa) villa).setDienTichHoBoi(FunValidation.checkValidateNumberDouble(content, errMes));
        while (((Villa) villa).getDienTichHoBoi() < 30) {
            System.out.println(errMes);
            ((Villa) villa).setDienTichHoBoi(FunValidation.checkValidateNumberDouble(content, errMes));
        }
        content = " Save Success!!";
        errMes = "Số Tầng là số nguyên dương >0 ";
        System.out.println("Số Tầng :");
        ((Villa) villa).setSoTang(FunValidation.checkValidateNumberInt(content, errMes));
        while (((Villa) villa).getSoTang() < 1) {
            System.out.println(errMes);
            ((Villa) villa).setSoTang(FunValidation.checkValidateNumberInt(content, errMes));
        }
        JDBC.insertVilla((Villa) villa);
        System.out.println("Add New Villa success !!");
        backToMenu();

    }

    private void addNewHouse() {
        String content = "";
        String errMes = "";
        Services house = new House();
        addNewService(house);
        System.out.println(" Tiêu Chuẩn Phòng : ");
        ((House) house).setTieuChuanPhong(scanner.nextLine());
        while (!FunValidation.checkNameService(((House) house).getTieuChuanPhong())) {
            System.out.println("Kiểu Thuê sai định dạng, mời bạn nhập lại :");
            ((House) house).setTieuChuanPhong(scanner.nextLine());
        }
        System.out.println("Tiện Nghi Khác : ");
        ((House) house).setTienNghiKhac(scanner.nextLine());
        content = " Save Success!!";
        errMes = "Số Tầng là số nguyên dương >0 ";
        System.out.println("Số Tầng :");
        ((House) house).setSoTang(FunValidation.checkValidateNumberInt(content, errMes));
        while (((House) house).getSoTang() < 1) {
            System.out.println(errMes);
            ((House) house).setSoTang(FunValidation.checkValidateNumberInt(content, errMes));
        }
        JDBC.insertHouse((House) house);
        System.out.println("Add New House success !!");
        backToMenu();


    }

    private void addRoom() {
        Services room = new Room();
        addNewService(room);
        System.out.println("Dich Vụ Miễn Phí Đi Kèm : ");
        ((Room) room).setDichVuMienPhiDiKem(scanner.nextLine());
        JDBC.insertRoom((Room) room);
        System.out.println("Add New Room success !!");
        backToMenu();
    }

    public String loaiKhach() {
        System.out.println("Chọn Loại Khách :" +
                "\n 1.Diamond " +
                "\n 2.Platinium " +
                "\n 3.Gold " +
                "\n 4.Silver " +
                "\n 5.Member");
        String num;
        num = scanner.nextLine();
        switch (num) {
            case "1":
                return "Diamond";
            case "2":
                return "Platinium";
            case "3":
                return "Gold";
            case "4":
                return "Silver";
            case "5":
                return "Member";
            default:
                loaiKhach();
        }
        return null;
    }


}
