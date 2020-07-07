package CaseStudy_Module2.Models;

import java.util.Date;

public class Customer {
    private String nameCustomer;
    private String birthdayCustomer;
    private String sexCustomer;
    private int idCardCustomer;
    private int phoneNumber;
    private String emailCustomer;
    private String typeCustomer;
    private String addressCustomer;

    public Customer() {
    }

    public Customer(String nameCustomer, String birthdayCustomer, String sexCustomer, int idCardCustomer, int phoneNumber, String emailCustomer, String typeCustomer, String addressCustomer) {
        this.nameCustomer = nameCustomer;
        this.birthdayCustomer = birthdayCustomer;
        this.sexCustomer = sexCustomer;
        this.idCardCustomer = idCardCustomer;
        this.phoneNumber = phoneNumber;
        this.emailCustomer = emailCustomer;
        this.typeCustomer = typeCustomer;
        this.addressCustomer = addressCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getBirthdayCustomer() {
        return birthdayCustomer;
    }

    public void setBirthdayCustomer(String birthdayCustomer) {
        this.birthdayCustomer = birthdayCustomer;
    }

    public String getSexCustomer() {
        return sexCustomer;
    }

    public void setSexCustomer(String sexCustomer) {
        this.sexCustomer = sexCustomer;
    }

    public int getIdCardCustomer() {
        return idCardCustomer;
    }

    public void setIdCardCustomer(int idCardCustomer) {
        this.idCardCustomer = idCardCustomer;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailCustomer() {
        return emailCustomer;
    }

    public void setEmailCustomer(String emailCustomer) {
        this.emailCustomer = emailCustomer;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getAddressCustomer() {
        return addressCustomer;
    }

    public void setAddressCustomer(String addressCustomer) {
        this.addressCustomer = addressCustomer;
    }

    public String showInfor() {
        return "Customer{" +
                "nameCustomer='" + nameCustomer + '\'' +
                ", birthdayCustomer=" + birthdayCustomer +
                ", sexCustomer='" + sexCustomer + '\'' +
                ", idCardCustomer=" + idCardCustomer +
                ", phoneNumber=" + phoneNumber +
                ", emailCustomer='" + emailCustomer + '\'' +
                ", typeCustomer='" + typeCustomer + '\'' +
                ", addressCustomer='" + addressCustomer + '\'' +
                '}';
    }
}
