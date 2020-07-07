package com.codegym.demo.model;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;


@Component
@Entity
public class Customer implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min = 2, max = 20)
    private String codeCustomer;

    @NotEmpty
    private String typeCustomer;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String name;

    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private Date birthday;

    @NotEmpty
    private String sex;

    @NotEmpty
    private String phoneNumber;

    @NotEmpty
    private String idCard;

    @NotEmpty
    private String email;

    @NotEmpty
    private String address;

    public Customer() {
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeCustomer() {
        return codeCustomer;
    }

    public void setCodeCustomer(String codeCustomer) {
        this.codeCustomer = codeCustomer;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Customer.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Customer customer = (Customer) o;
        String name = customer.getName();
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");

        if (!name.matches("^[a-zA-Z ]*$")) {
            errors.rejectValue("name", "name.matches");
        }

        String sex = customer.sex;
        ValidationUtils.rejectIfEmpty(errors, "sex", "sex.empty");
        if (!sex.equals("male")&&!sex.equals("female")&&!sex.equals("other")) {
            errors.rejectValue("sex", "sex.notsure");
        }

        String codeCustomer = customer.codeCustomer;
        ValidationUtils.rejectIfEmpty(errors, "codeCustomer", "codeCustomer.empty");

        if (!codeCustomer.matches("([KH])\\w+-[0-9]{4}")) {
            errors.rejectValue("codeCustomer", "codeCustomer.matches");
        }


        String phoneNumber = customer.getPhoneNumber();
        ValidationUtils.rejectIfEmpty(errors, "phoneNumber", "phoneNumber.empty");
//        if (phoneNumber.length() > 11 || phoneNumber.length() < 10) {
//            errors.rejectValue("phoneNumber", "phoneNumber.length");
//        }
        if (!phoneNumber.startsWith("0")) {
            errors.rejectValue("phoneNumber", "phoneNumber.startsWith");
        }
        if (!phoneNumber.matches("([0-9]{4})\\w*-([0-9]{3})\\w*-[0-9]{3}")) {
            errors.rejectValue("phoneNumber", "phoneNumber.matches");
        }
    }
}
