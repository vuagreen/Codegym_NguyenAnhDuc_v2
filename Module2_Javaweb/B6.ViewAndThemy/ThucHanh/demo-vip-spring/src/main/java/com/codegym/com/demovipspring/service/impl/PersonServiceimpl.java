package com.codegym.com.demovipspring.service.impl;

import com.codegym.com.demovipspring.entity.Person;
import com.codegym.com.demovipspring.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PersonServiceimpl implements PersonService {
    private static Map<Integer, Person> map = new HashMap<>();
    static {
        map.put(1, new Person(1, "Nam", "Da Nang"));
        map.put(2, new Person(2, "Quan", "Ha Noi"));
        map.put(3, new Person(3, "Bao", "Da Nang"));
    }
    @Override
    public List<Person> findAll() {
        return new ArrayList<>(map.values());
    }
}
