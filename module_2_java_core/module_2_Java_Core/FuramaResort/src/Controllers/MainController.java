package Controllers;

import Commons.ArrayOop;
import Commons.Sc;
import Models.*;

import java.util.Collections;

public class MainController {
    private boolean whileDisplayMainMenu = true;

    ArrayOop arrVilla = new ArrayOop("FuramaResort/src/Data/villa.csv",new Villa());
    ArrayOop arrHouse = new ArrayOop("FuramaResort/src/Data/house.csv",new House());
    ArrayOop arrRoom = new ArrayOop("FuramaResort/src/Data/room.csv",new Room());
    ArrayOop arrCustomer =new ArrayOop("FuramaResort/src/Data/customer.csv",new Customer());
    ArrayOop arrBooking = new ArrayOop("FuramaResort/src/Data/Booking.csv",new Customer());

    public MainController() {
    }

    public void displayMainMenu() {
        String regexDisplay = "^[1234567]$";
        System.out.println("\n" +
                "1.\tAdd New Services\n" +
                "2.\tShow Services\n" +
                "3.\tAdd New Customer\n" +
                "4.\tShow Information of Customer\n" +
                "5.\tAdd New Booking\n" +
                "6.\tShow Information of Employee\n" +
                "7.\tExit");
        switch (Integer.parseInt(Sc.input("Chọn chức năng cần dùng:", "Bạn cần phải nhập vào số tương ứng ở danh sách.", regexDisplay))) {
            case 1:
                addNewServies();
                break;
            case 2:
                showServices();
                break;
            case 3:
                arrCustomer.addInput();
                break;
            case 4:
                Collections.sort(arrCustomer.arrayOops, new Customer());
                arrCustomer.show();
                break;
            case 5:
                chooseServices(addNewBooking());
                break;
            case 6:
                Employee.show();
                break;
            case 7:
                whileDisplayMainMenu=false;
                break;

        }
        if(whileDisplayMainMenu)
            displayMainMenu();
    }

    public void addNewServies() {
        String regexAddNewServies = "^[12345]$";
        System.out.println("" +
                "1.\tAdd New Villa\n" +
                "2.\tAdd New House\n" +
                "3.\tAdd New Room\n" +
                "4.\tBack to menu\n" +
                "5.\tExit\n");
        switch (Integer.parseInt(Sc.input("Chọn chức năng cần dùng:", "Bạn cần phải nhập vào số tương ứng ở danh sách.", regexAddNewServies))) {
            case 1:
                arrVilla.addInput();
                break;
            case 2:
                arrHouse.addInput();
                break;
            case 3:
                arrRoom.addInput();
                break;
            case 4:
                displayMainMenu();
                break;
            case 5:
                whileDisplayMainMenu = false;
                break;

        }
    }

    public void showServices() {
        String regexShowServices = "^[12345678]$";
        System.out.println("\n" +
                "1.\tShow all Villa\n" +
                "2.\tShow all House\n" +
                "3.\tShow all Room\n" +
                "4.\tShow All Name Villa Not Duplicate\n" +
                "5.\tShow All Name House Not Duplicate\n" +
                "6.\tShow All Name Name Not Duplicate\n" +
                "7.\tBack to menu\n" +
                "8.\tExit\n");
        switch (Integer.parseInt(Sc.input("Chọn chức năng cần dùng:", "Bạn cần phải nhập vào số tương ứng ở danh sách.", regexShowServices))) {
            case 1:
                arrVilla.show();
                break;
            case 2:
                arrHouse.show();
                break;
            case 3:
                arrRoom.show();
                break;
            case 4:
                arrVilla.showNameNotDuplicate();
                break;
            case 5:
                arrHouse.showNameNotDuplicate();
                break;
            case 6:
                arrRoom.showNameNotDuplicate();;
                break;
            case 7:
                displayMainMenu();
                break;
            case 8:
                whileDisplayMainMenu = false;
                break;
        }
    }
    public int addNewBooking() {

        int customerBooking=0;
        int i=0;
        System.out.println("Danh sách khách hàng:");
        for (Object customer:  arrCustomer.arrayOops) {
            i++;
            System.out.print(i+". Name: ");
            System.out.print(((Customer) customer).getName());
            System.out.print("\tIdCard: ");
            System.out.println(((Customer) customer).getIdCard());
        }
        do{
            if(i==0){
                System.out.println("Danh sách khách hàng hiện tại không có khách hàng nào.");
                break;
            }
            customerBooking = Integer.parseInt(Sc.input("Chọn khách hàng cần Booking:","Bạn cần phải nhập vào số tương ứng ở danh sách.","^[\\d]+$"));
            if(!(customerBooking > 0 && customerBooking <= i))
                System.out.println("Bạn cần phải nhập vào số tương ứng ở danh sách.");
        }
        while (!(customerBooking > 0 && customerBooking <= i));
        return customerBooking;
    }
    public void chooseServices(int customerBooking){
        System.out.println(customerBooking);
        if(customerBooking!=0) {
            String regexAddBookingServices = "^[12345]$";
            System.out.println("" +
                    "1.\tBooking Villa\n" +
                    "2.\tBooking House\n" +
                    "3.\tBooking Room\n" +
                    "4.\tTo Menu\n" +
                    "5.\tExit\n");
            switch (Integer.parseInt(Sc.input("Chọn chức năng cần dùng:", "Bạn cần phải nhập vào số tương ứng ở danh sách.", regexAddBookingServices))) {
                case 1:
                    bookingAndWriteFileCSV(customerBooking, arrVilla);
                    break;
                case 2:
                    bookingAndWriteFileCSV(customerBooking, arrHouse);
                    break;
                case 3:
                    bookingAndWriteFileCSV(customerBooking, arrRoom);
                    break;
                case 4:
                    displayMainMenu();
                    break;
                case 5:
                    whileDisplayMainMenu = false;
                    break;
            }
        }
    }

    public void bookingAndWriteFileCSV(int customerBooking, ArrayOop arrService){
        int numberOfService = arrService.show();//
        if(numberOfService>0) {
            int k = 0;
            int selectedService;
            do {
                selectedService = Integer.parseInt(Sc.input("Chọn Service cần booking:", "Bạn cần phải nhập vào số tương ứng ở danh sách.", "^[\\d]+$"));
                if (!(selectedService > 0 && selectedService <= numberOfService))
                    System.out.println("Bạn cần phải nhập vào số tương ứng ở danh sách.");
            }
            while (!(selectedService > 0 && selectedService <= numberOfService));
            for (Object service : arrService.arrayOops) {
                k++;
                if (k == selectedService) {
                    Customer customer;
                    customer = ((Customer) arrCustomer.arrayOops.get(customerBooking - 1)).copyCustomer();
                    customer.setServiceUsageProperties((Services) service);
                    arrBooking.arrayOops.add(customer);
                    arrBooking.writeArray();
                    break;
                }
            }
        } else{
            System.out.println("Không có phòng nào. vui lòng chọn lại chức năng khác.");
        }
    }
}
