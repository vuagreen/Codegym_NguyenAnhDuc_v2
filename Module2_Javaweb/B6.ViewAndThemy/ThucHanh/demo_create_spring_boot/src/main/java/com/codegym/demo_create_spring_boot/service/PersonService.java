package com.codegym.demo_create_spring_boot.service;

        import com.codegym.demo_create_spring_boot.entity.Person;

        import java.util.List;

public interface PersonService  {

    List<Person> findAll();

    void add(Person person);
}
