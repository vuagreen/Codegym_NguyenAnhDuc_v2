package com.example.demo.model;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Component
public class User implements Validator {

    @NotEmpty
    @Size(min = 2, max = 30)
    private String name;
    @Min(18)
    private int age;

    public User() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        String name = user.getName();
        ValidationUtils.rejectIfEmpty(errors,"name", "name.empty");
        if (!name.startsWith("S")) {
            errors.rejectValue("name", "name.startsWith");
        }
        if (!name.matches("^[a-zA-Z ]*$")) {
            errors.rejectValue("name","name.matches");
        }
    }
}
