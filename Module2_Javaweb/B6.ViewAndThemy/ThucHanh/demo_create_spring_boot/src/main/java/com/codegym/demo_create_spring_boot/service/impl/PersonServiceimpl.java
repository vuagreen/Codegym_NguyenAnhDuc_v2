package com.codegym.demo_create_spring_boot.service.impl;

import com.codegym.demo_create_spring_boot.entity.Person;
import com.codegym.demo_create_spring_boot.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PersonServiceimpl implements PersonService {
    private static Map<Integer, Person> map = new HashMap<>();
    static{
        map.put(1, new Person(1, "Hai", "Quang Binh"));
        map.put(2, new Person(2, "Nam", "Quang Nam"));
        map.put(3, new Person(3, "Quoc", "Ha Noi"));

    }

    @Override
    public List<Person> findAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public void add(Person person) {
        map.put(person.getId(), person);
    }
}
