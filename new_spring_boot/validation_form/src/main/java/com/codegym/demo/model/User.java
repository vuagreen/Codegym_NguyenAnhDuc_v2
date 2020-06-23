package com.codegym.demo.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
@Component
@Entity
public class User implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 5, max = 45)
    private String firstName;

    @Size(min = 5, max = 45)
    private String lastName;
    @Min(18)
    private int age;
    @Email
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    private String phoneNumber;


    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        String phoneNumber = user.getPhoneNumber();
        ValidationUtils.rejectIfEmpty(errors , "phoneNumber", "number.empty");
        if (phoneNumber.length() < 10 || phoneNumber.length() > 11) {
            errors.rejectValue("phoneNumber", "number.length");
        }
        if (!phoneNumber.startsWith("0")) {
            errors.rejectValue("phoneNumber","number.startsWith");
        }
        if (!phoneNumber.matches("(^$|[0-9])*$")) {
            errors.rejectValue("phoneNumber","number.matches");
        }
    }
}

