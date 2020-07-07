//package Commons;
//
//import Models.Services;
//import Models.Employee;
//import Models.Room;
//import Models.House;
//import Models.Customer;
//import com.sun.source.tree.Tree;
//
//import javax.print.DocFlavor;
//import javax.swing.text.ElementIterator;
//import java.security.Provider;
//import java.text.SimpleDateFormat;
//import java.util.*;
//
//public class Array {
////    public static class Villas{
////        public static HashMap<String, Villa> villas = new HashMap<String, Villa>();
////        final static String fileName="FuramaResort/src/Data/villa.csv";
////
////        static {
////            Array.Villas.readAndAddArray();
////        }
////
////        public static void addInput(){
////            Villa villa = new Villa();
////            villa.setInput();
////            Array.Villas.add(villa);
////        }
////        public static void add(Villa villa){
////            villas.put(villa.getId(),villa);
////            Array.Villas.writeArray();
////        }
////        public static int show(){
////            int i=0;
////            for (Villa villa:villas.values()) {
////                i++;
////                System.out.print(i+". ");
////                System.out.println(villa.showInfor());
////            }
////            return i;
////        }
////
////        public static void showNameNotDuplicate(){
////            TreeSet<String > nameVilla = new TreeSet<>();
////            for (Villa villa:villas.values()) {
////                nameVilla.add(villa.getName());
////            }
////            for (String str:nameVilla) {
////                System.out.println(str);
////            }
////        }
////
////
//////        public static void showNameVillaNotDuplicate(){
//////            TreeSet<Villa> villaTreeSet = new TreeSet<Villa>();
//////            for (Villa villa:villas.values()) {
//////                villaTreeSet.add(villa);
//////            }
//////            for (Villa villa:villaTreeSet) {
//////                System.out.println(villa.showInfor());
//////            }
//////        }
////
////        public static void readAndAddArray(){
////            String str = ReadAndWriteCSV.readCSV(fileName);
////            if(str.length()!=0) {
////                String[] arrStrVillas = str.split("\n");
////                for (String strVilla : arrStrVillas) {
////                    String[] arr = strVilla.split(",");
////                    Villa villa = new Villa(arr[0], arr[1], arr[2], Integer.parseInt(arr[3]), Integer.parseInt(arr[4]), arr[5], arr[6], arr[7], arr[8], Integer.parseInt(arr[9]));
////                    villas.put(villa.getId(), villa);
////                }
////            }
////        }
////        public static void writeArray(){
////            StringBuilder str = new StringBuilder();
////            for (Villa villa: villas.values()) {
////                str.append(villa.getId());
////                str.append(",");
////                str.append(villa.getName());
////                str.append(",");
////                str.append(villa.getUsableUtility());
////                str.append(",");
////                str.append(villa.getRentalCosts());
////                str.append(",");
////                str.append(villa.getMaxNumberPeople());
////                str.append(",");
////                str.append(villa.getTypeOfRent());
////                str.append(",");
////                str.append(villa.getRoomStandard());
////                str.append(",");
////                str.append(villa.getOtherDescription());
////                str.append(",");
////                str.append(villa.getPoolArea());
////                str.append(",");
////                str.append(villa.getNumberFloors());
////                str.append("\n");
////            }
////            ReadAndWriteCSV.writeCSV(fileName,str.toString());
////        }
////    }
////
////    public static class Houses{
////        public static HashMap<String, House> houses = new HashMap<String, House>();
////        final static String fileName="FuramaResort/src/Data/house.csv";
////
////        static {
////            Array.Houses.readAndAddArray();
////        }
////
////        public static void addInput(){
////            House house = new House();
////            house.setInput();
////            Array.Houses.add(house);
////        }
////        public static void add(House house){
////            houses.put(house.getId(),house);
////            Array.Houses.writeArray();
////        }
////
////        public static void show(){
////            int i=0;
////            for (House house:houses.values()) {
////                i++;
////                System.out.print(i+". ");
////                System.out.println(house.showInfor());
////            }
////        }
////
////        public static void showNameNotDuplicate(){
////            TreeSet<String > nameHouses = new TreeSet<>();
////            for (House house:houses.values()) {
////                nameHouses.add(house.getName());
////            }
////            for (String str:nameHouses) {
////                System.out.println(str);
////            }
////        }
////
////        public static void readAndAddArray(){
////            String str = ReadAndWriteCSV.readCSV(fileName);
////            if(str.length()!=0) {
////                String[] arrStrHouses = str.split("\n");
////                for (String strHouse : arrStrHouses) {
////                    String[] arr = strHouse.split(",");
////                    House house = new House(arr[0], arr[1], arr[2], Integer.parseInt(arr[3]), Integer.parseInt(arr[4]), arr[5], arr[6], arr[7],  Integer.parseInt(arr[8]));
////                    houses.put(house.getId(), house);
////                }
////            }
////        }
////        public static void writeArray(){
////            StringBuilder str = new StringBuilder();
////            for (House house: houses.values()) {
////                str.append(house.getId());
////                str.append(",");
////                str.append(house.getName());
////                str.append(",");
////                str.append(house.getUsableUtility());
////                str.append(",");
////                str.append(house.getRentalCosts());
////                str.append(",");
////                str.append(house.getMaxNumberPeople());
////                str.append(",");
////                str.append(house.getTypeOfRent());
////                str.append(",");
////                str.append(house.getRoomStandard());
////                str.append(",");
////                str.append(house.getOtherDescription());
////                str.append(",");
////                str.append(house.getNumberFloors());
////                str.append("\n");
////            }
////            ReadAndWriteCSV.writeCSV(fileName,str.toString());
////        }
////    }
////
////    public static class Rooms{
////        public static HashMap<String, Room> rooms = new HashMap<String, Room>();
////        final static String fileName="FuramaResort/src/Data/room.csv";
////
////        static {
////            Array.Rooms.readAndAddArray();
////        }
////
////        public static void addInput(){
////            Room room = new Room();
////            room.setInput();
////            Array.Rooms.add(room);
////        }
////        public static void add(Room room){
////            rooms.put(room.getId(),room);
////            Array.Rooms.writeArray();
////        }
////
////        public static void show(){
////            int i=0;
////            for (Room room:rooms.values()) {
////                i++;
////                System.out.print(i+". ");
////                System.out.println(room.showInfor());
////            }
////        }
////
////
////        public static void showNameNotDuplicate(){
////            TreeSet<String > nameRooms = new TreeSet<>();
////            for (Room room:rooms.values()) {
////                nameRooms.add(room.getName());
////            }
////            for (String str:nameRooms) {
////                System.out.println(str);
////            }
////        }
////
////        public static void readAndAddArray(){
////            String str = ReadAndWriteCSV.readCSV(fileName);
////            System.out.println(str.length());
////            if(str.length()!=0) {
////                String[] arrStrRooms = str.split("\n");
////                for (String strRooms : arrStrRooms) {
////                    String[] arr = strRooms.split(",");
////                    Room room = new Room(arr[0], arr[1], arr[2], Integer.parseInt(arr[3]), Integer.parseInt(arr[4]), arr[5], Boolean.parseBoolean(arr[6]));
////                    rooms.put(room.getId(), room);
////                }
////            }
////        }
////        public static void writeArray(){
////            StringBuilder str = new StringBuilder();
////            for (Room room: rooms.values()) {
////                str.append(room.getId());
////                str.append(",");
////                str.append(room.getName());
////                str.append(",");
////                str.append(room.getUsableUtility());
////                str.append(",");
////                str.append(room.getRentalCosts());
////                str.append(",");
////                str.append(room.getMaxNumberPeople());
////                str.append(",");
////                str.append(room.getTypeOfRent());
////                str.append(",");
////                str.append(room.isFreeChaperones());
////                str.append("\n");
////            }
////            ReadAndWriteCSV.writeCSV(fileName,str.toString());
////        }
////    }
////
////    // //////////////////////////////////////////////// customers
//        public static class Employees{
//        public static HashMap<String, Employee> employees = new HashMap<String, Employee>();
//        final static String fileName="FuramaResort/src/Data/employee.csv";
//
//        static {
//            Array.Employees.readAndAddArray();
//        }
//
////        public static void addInput(){
////            Employee employee = new Employee();
////            employee.setInput();
////            Array.Employee.add(employee);
////        }
////        public static void add(Employee employee){
////            employees.put(employee.getId(),employee);
////            Array.Employee.writeArray();
////        }
//
//        public static void show(){
//            Array.Employees.readAndAddArray();
//            int i=0;
//            for (Employee employee:employees.values()) {
//                i++;
//                System.out.print(i+". ");
//                System.out.println(employee.toString());
//            }
//        }
//
//
//
//        public static void readAndAddArray(){
//            String str = ReadAndWriteCSV.readCSV(fileName);
//            System.out.println(str.length());
//            if(str.length()!=0) {
//                String[] arrStrEmployee = str.split("\n");
//                for (String strEmployee : arrStrEmployee) {
//                    String[] arr = strEmployee.split(",");
//                    Employee employee = new Employee(arr[0], arr[1], Integer.parseInt(arr[3]),arr[1]);
//                    employees.put(employee.getIdEmployee(), employee);
//                }
//            }
//        }
////        public static void writeArray(){
////            StringBuilder str = new StringBuilder();
////            for (Employee employee: employees.values()) {
////                str.append(employee.getIdEmployee());
////                str.append(",");
////                str.append(employee.getFullName());
////                str.append(",");
////                str.append(employee.ge());
////                str.append(",");
////                str.append(employee.getRentalCosts());
////                str.append(",");
////                str.append(room.getMaxNumberPeople());
////                str.append(",");
////                str.append(room.getTypeOfRent());
////                str.append(",");
////                str.append(room.isFreeChaperones());
////                str.append("\n");
////            }
////            ReadAndWriteCSV.writeCSV(fileName,str.toString());
////        }
//    }
//
//    // //////////////////////////////////////////////// customers
//
//    public static class Customers{
//        public static HashMap<String, Customer> customers = new HashMap<String, Customer>();
//        final static String fileNameCustomer="FuramaResort/src/Data/customer.csv";
//
//        static {
//            Array.Customers.readAndAddArray();
//        }
//
//        public static void addInput(){
//            Customer customer = new Customer();
//            customer.setInput();
//            Array.Customers.add(customer);
//        }
//        public static void add(Customer customer){
//            customers.put(customer.getIdCard(),customer);
//            Array.Customers.writeArray();
//        }
//
//        public static void show(){
//            Collection <Customer> collectionValueCustomers = customers.values();
//            List<Customer> listCustomers = new ArrayList<>(collectionValueCustomers);
//            Collections.sort(listCustomers, new Customer());
//            for (Customer customer: listCustomers) {
//                System.out.println(customer.showInfor());
//            }
//            //Collections.sort(collectionCustomers,new Customer());
////            for (Customer customer: collectionCustomers) {
////                System.out.println(customer.showInfor());
////
////            }
//        }
////        public static void addNewBooking(){
////            int customerBooking=0;
////            int i=0;
////            Collection <Customer> collectionValueCustomers = customers.values();
////            List<Customer> listCustomers = new ArrayList<>(collectionValueCustomers);
////            Collections.sort(listCustomers, new Customer());
////            System.out.println("Danh sách khách hàng:");
////            for (Customer customer: listCustomers) {
////                i++;
////                System.out.print(i+". Name: ");
////                System.out.print(customer.getFullName());
////                System.out.print("\tIdCard: ");
////                System.out.println(customer.getIdCard());
////            }
////             do{
////                customerBooking = Integer.parseInt(Sc.input("Chọn chức năng cần dùng:","Bạn cần phải nhập vào số tương ứng ở danh sách.","^[\\d]+$"));
////                if(!(customerBooking > 0 && customerBooking <= i))
////                    System.out.println("Bạn cần phải nhập vào số tương ứng ở danh sách.");
////            }
////             while (!(customerBooking > 0 && customerBooking <= i));
////            String regexAddBookingServices = "^[12345]$";
////            System.out.println("" +
////                    "1.\tBooking Villa\n" +
////                    "2.\tBooking House\n" +
////                    "3.\tBooking Room\n" +
////                    "4.\tBack to\n" +
////                    "5.\tExit\n");
////            switch (Integer.parseInt(Sc.input("Chọn chức năng cần dùng:", "Bạn cần phải nhập vào số tương ứng ở danh sách.", regexAddBookingServices))) {
////                case 1:
////                    int numberOfVillas = Array.Villas.show();
////                    int k=0;
////                    int selectedVilla;
////                    String keyBooking= null;
////                    do{
////                        selectedVilla = Integer.parseInt(Sc.input("Chọn Villa cần booking:","Bạn cần phải nhập vào số tương ứng ở danh sách.","^[\\d]+$"));
////                        if(!(selectedVilla > 0 && selectedVilla <= i))
////                            System.out.println("Bạn cần phải nhập vào số tương ứng ở danh sách.");
////                    }
////                    while (!(selectedVilla > 0 && selectedVilla <= numberOfVillas));
////                    for (String key: Villas.villas.keySet()) {
////                        k++;
////                        if(k==selectedVilla){
////                            keyBooking=key;
////                        }
////                    }
////                    listCustomers.get(customerBooking-1).setServiceUsageProperties(Villas.villas.get(keyBooking));
////                    Bookings.customersBooking.add(listCustomers.get(customerBooking-1));
////                    Array.Bookings.writeArray();
////                    break;
////                case 2:
////                    Array.Houses.show();
////                    break;
////                case 3:
////                    Array.Rooms.show();
////                    break;
////                case 4:
////                    Array.Customers.addNewBooking();
////                    break;
////                case 5:
////                    break;
////            }
////        }
//
//
//        public static void showNameNotDuplicate(){
//            TreeSet<String > nameCustomers = new TreeSet<>();
//            for (Customer customer:customers.values()) {
//                nameCustomers.add(customer.getName());
//            }
//            for (String str:nameCustomers) {
//                System.out.println(str);
//            }
//        }
//
//        public static void readAndAddArray(){
//            String str = ReadAndWriteCSV.readCSV(fileNameCustomer);
//            System.out.println(str.length());
//            if(str.length()!=0) {
//                String[] arrStrCustomers = str.split("\n");
//                for (String strCustomers : arrStrCustomers) {
//                    String[] arr = strCustomers.split(",");
//                        Customer customer = new Customer(arr[0], arr[1], arr[2], (arr[3]), (arr[4]), arr[5], (arr[6]), arr[7],null);
//                    customers.put(customer.getIdCard(), customer);
//                }
//            }
//        }
//
//        public static void writeArray(){
//            StringBuilder str = new StringBuilder();
//            for (Customer customer: customers.values()) {
//                str.append(customer.getIdCard());
//                str.append(",");
//                str.append(customer.getName());
//                str.append(",");
//                str.append(customer.getBirthDay());
//                str.append(",");
//                str.append(customer.getGender());
//                str.append(",");
//                str.append(customer.getNumphoneNumber());
//                str.append(",");
//                str.append(customer.getEmail());
//                str.append(",");
//                str.append(customer.getTypeCustomer());
//                str.append(",");
//                str.append(customer.getAddress());
////                str.append(customer.getServiceUsageProperties());
////                str.append(",");
//                str.append("\n");
//            }
//            ReadAndWriteCSV.writeCSV(fileNameCustomer,str.toString());
//        }
//
//
//    }
//    public static class Bookings{
//        public static List<Customer> customersBooking = new ArrayList<>();
//        final static String fileNameBooking="FuramaResort/src/Data/Booking.csv";
//
//        static {
//            Array.Bookings.readAndAddArray();
//        }
////        public static void bookingVillaAndWriteFileCSV(int customerBooking){
////            int numberOfVillas = Array.Villas.show();
////            int k=0;
////            int selectedVilla;
////            String keyBooking= null;
////            do{
////                selectedVilla = Integer.parseInt(Sc.input("Chọn Villa cần booking:","Bạn cần phải nhập vào số tương ứng ở danh sách.","^[\\d]+$"));
////                if(!(selectedVilla > 0 && selectedVilla <= numberOfVillas))
////                    System.out.println("Bạn cần phải nhập vào số tương ứng ở danh sách.");
////            }
////            while (!(selectedVilla > 0 && selectedVilla <= numberOfVillas));
////            for (String key: Villas.villas.keySet()) {
////                k++;
////                if(k==selectedVilla){
////                    keyBooking=key;
////                }
////            }
////            Collection <Customer> collectionValueCustomers =  Customers.customers.values();
////            List<Customer> listCustomers = new ArrayList<>(collectionValueCustomers);
////            listCustomers.get(customerBooking-1).setServiceUsageProperties(Villas.villas.get(keyBooking));
////            Bookings.customersBooking.add(listCustomers.get(customerBooking-1));
////            Array.Bookings.writeArray();
////        }
//
////        public static void show(){
////            Collection <Customer> collectionValueCustomers = customersBooking.values();
////            List<Customer> listCustomers = new ArrayList<>(collectionValueCustomers);
////            Collections.sort(listCustomers, new Customer());
////            for (Customer customer: listCustomers) {
////                System.out.println(customer.showInfor());
////            }
////        }
//
//        public static void readAndAddArray(){
//            String str = ReadAndWriteCSV.readCSV(fileNameBooking);
//            //System.out.println(str.length());
//            if(str.length()!=0) {
//                String[] arrStrCustomers = str.split("\n");
//                for (String strCustomers : arrStrCustomers) {
//                    String[] arr = strCustomers.split(",");
//                    Services services =new Services(arr[8],arr[9],arr[10],Integer.parseInt(arr[11]) ,Integer.parseInt(arr[12]),arr[13]);
//                    Customer customer = new Customer(arr[0], arr[1], arr[2], (arr[3]), (arr[4]), arr[5], (arr[6]), arr[7], services);
//                    customersBooking.add(customer);
//                }
//            }
//        }
//        public static void writeArray(){
//            StringBuilder str = new StringBuilder();
//            for (Customer customer: customersBooking) {
//                str.append(customer.getIdCard());
//                str.append(",");
//                str.append(customer.getName());
//                str.append(",");
//                str.append(customer.getBirthDay());
//                str.append(",");
//                str.append(customer.getGender());
//                str.append(",");
//                str.append(customer.getNumphoneNumber());
//                str.append(",");
//                str.append(customer.getEmail());
//                str.append(",");
//                str.append(customer.getTypeCustomer());
//                str.append(",");
//                str.append(customer.getAddress());
//                str.append(",");
//                str.append(customer.getServiceUsageProperties().getId());
//                str.append(",");
//                str.append(customer.getServiceUsageProperties().getName());
//                str.append(",");
//                str.append(customer.getServiceUsageProperties().getUsableUtility());
//                str.append(",");
//                str.append(customer.getServiceUsageProperties().getRentalCosts());
//                str.append(",");
//                str.append(customer.getServiceUsageProperties().getMaxNumberPeople());
//                str.append(",");
//                str.append(customer.getServiceUsageProperties().getTypeOfRent());
//                str.append("\n");
//            }
//            ReadAndWriteCSV.writeCSV(fileNameBooking,str.toString());
//        }
//    }
//}
