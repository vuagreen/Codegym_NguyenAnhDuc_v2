package Models;

import Commons.FunctionArrays;
import Commons.Sc;

import java.util.Comparator;

public class Customer implements Comparator, FunctionArrays {
    private String idCard;
    private String fullName;
    private String birthDay;
    private String gender;
    private String numphoneNumber;
    private String email;
    private String typeCustomer;
    private String address;
    private Services serviceUsageProperties;
    private String regexFullName = "^([A-Z][a-z]*[\\s])*[A-Z][a-z]*$";
    private String regexEmail = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$";
    private String regexGender = "^(male)|(female)|(unknow)$";
    private String regexIdCard = "^([\\d]{3}[\\s]){2}[\\d]{3}$";
    private String regexNumphoneNumber = "^[0][\\d]{9}$";

    public Customer() {
    }

    public Customer(String idCard, String fullName, String birthDay, String gender, String numphoneNumber, String email, String typeCustomer, String address, Services serviceUsageProperties) {
        this.idCard = idCard;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.gender = gender;
        this.numphoneNumber = numphoneNumber;
        this.email = email;
        this.typeCustomer = typeCustomer;
        this.address = address;
        this.serviceUsageProperties = serviceUsageProperties;
    }

    public void setInput() {
        this.setIdCard(Sc.input("nhập vào sô CMND khách hàng: ", "Id Card phải có 9 chữ số và theo định dạng XXX XXX XXX.", this.regexIdCard));
        this.setFullName(Sc.input("nhập vào tên khách hàng: ", "Tên Khách hàng phải in hoa ký tự đầu tiên trong mỗi từ.", this.regexFullName));
        this.setBirthDay(Sc.birthdayException("Nhập vào ngày tháng năm sinh khách hàng: ", "Năm sinh phải >1900 và nhỏ hơn năm hiện tại 18 năm, đúng định dạng dd/mm/yyyy"));
        this.setGender(Sc.input("nhập vào giới tính của khách hàng: ", "Cần nhập vào giới tính là male, female or Unknow.", this.regexGender, true));
        this.setNumphoneNumber(Sc.input("nhập số điện thoại khách hàng: ", "Bạn cần nhập số điện thoại gồm 10 số bắt đầu là 0.", this.regexNumphoneNumber));
        this.setEmail(Sc.input("nhập vào email của khách hàng: ", "Email phải đúng định dạng abc@abc.abc.", this.regexEmail));
        this.setTypeCustomer(Sc.input("nhập vào TypeCustomer: "));
        this.setAddress(Sc.input("nhập vào địa chỉ khách hàng: "));
    }

    public String getName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getNumphoneNumber() {
        return numphoneNumber;
    }

    public void setNumphoneNumber(String numphoneNumber) {
        this.numphoneNumber = numphoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Services getServiceUsageProperties() {
        return serviceUsageProperties;
    }

    public void setServiceUsageProperties(Services serviceUsageProperties) {
        this.serviceUsageProperties = serviceUsageProperties;
    }

    @Override
    public FunctionArrays returnArraySetInput() {
        Customer customer = new Customer();
        customer.setInput();
        return customer;
    }

    @Override
    public FunctionArrays stringToObject(String strCustomer) {
        String[] arr = strCustomer.split(",");
        Customer customer;
        Services services = null;
        if (arr.length > 8) {
            if (arr[8].substring(2, 4).equals ("VL"))
                services = new Villa(arr[8], arr[9], arr[10], Integer.parseInt(arr[11]), Integer.parseInt(arr[12]), arr[13], arr[14], arr[15], arr[16], Integer.parseInt(arr[17]));
            if (arr[8].substring(2, 4).equals("HO"))
                services = new House(arr[8], arr[9], arr[10], Integer.parseInt(arr[11]), Integer.parseInt(arr[12]), arr[13], arr[14], arr[15], Integer.parseInt(arr[16]));
            if (arr[8].substring(2, 4).equals("RO"))
                services = new Room(arr[8], arr[9], arr[10], Integer.parseInt(arr[11]), Integer.parseInt(arr[12]), arr[13], Boolean.parseBoolean(arr[14]));
        }
        customer = new Customer(arr[0], arr[1], arr[2], (arr[3]), (arr[4]), arr[5], (arr[6]), arr[7], services);
        return customer;
    }

    @Override
    public String objectToString(FunctionArrays customer) {
        StringBuilder str = new StringBuilder();
        str.append(((Customer) customer).getIdCard());
        str.append(",");
        str.append(((Customer) customer).getName());
        str.append(",");
        str.append(((Customer) customer).getBirthDay());
        str.append(",");
        str.append(((Customer) customer).getGender());
        str.append(",");
        str.append(((Customer) customer).getNumphoneNumber());
        str.append(",");
        str.append(((Customer) customer).getEmail());
        str.append(",");
        str.append(((Customer) customer).getTypeCustomer());
        str.append(",");
        str.append(((Customer) customer).getAddress());
        str.append(",");

        if (((Customer) customer).getServiceUsageProperties() instanceof Villa) {
            str.append(((Villa) ((Customer) customer).getServiceUsageProperties()).objectToString(((Villa) ((Customer) customer).getServiceUsageProperties())));
        } else if (((Customer) customer).getServiceUsageProperties() instanceof Room) {
            str.append(((Room) ((Customer) customer).getServiceUsageProperties()).objectToString(((Room) ((Customer) customer).getServiceUsageProperties())));
        } else if (((Customer) customer).getServiceUsageProperties() instanceof House) {
            str.append(((House) ((Customer) customer).getServiceUsageProperties()).objectToString(((House) ((Customer) customer).getServiceUsageProperties())));
        } else
            str.append("\n");
        return str.toString();
    }

    public String showInfor() {
        return "Customer{" +
                "fullName='" + fullName + '\'' +
                ", birthDay=" + birthDay +
                ", gender='" + gender + '\'' +
                ", idCard='" + idCard + '\'' +
                ", numphoneNumber='" + numphoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", typeCustomer='" + typeCustomer + '\'' +
                ", address='" + address + '\'' +
                //", serviceUsageProperties=" + serviceUsageProperties +
                '}';
    }

    @Override
    public int compare(Object o1, Object o2) {
        Customer customer1 = (Customer) o1;
        Customer customer2 = (Customer) o2;

        if (customer1.getName().equalsIgnoreCase(customer2.getName())) {
            return (Integer.parseInt(customer1.getBirthDay().substring(6, 10)) - Integer.parseInt(customer2.getBirthDay().substring(6, 10)));
        } else
            return customer1.getName().compareTo(customer2.getName());
    }
    public Customer copyCustomer(){
        Customer customer = new Customer();
        customer.setIdCard(this.getIdCard());
        customer.setFullName(this.getName());
        customer.setServiceUsageProperties(this.getServiceUsageProperties());
        customer.setTypeCustomer(this.getTypeCustomer());
        customer.setEmail(this.getEmail());
        customer.setNumphoneNumber(this.getNumphoneNumber());
        customer.setGender(this.getGender());
        customer.setAddress(this.getAddress());
        customer.setBirthDay(this.getBirthDay());
        return customer;
    }
}
