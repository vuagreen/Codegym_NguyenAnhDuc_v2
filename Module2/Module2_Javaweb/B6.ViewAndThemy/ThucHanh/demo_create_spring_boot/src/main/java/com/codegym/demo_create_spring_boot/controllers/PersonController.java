package com.codegym.demo_create_spring_boot.controllers;

import com.codegym.demo_create_spring_boot.entity.Person;
import com.codegym.demo_create_spring_boot.service.PersonService;
import com.codegym.demo_create_spring_boot.service.impl.PersonServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("")
    public ModelAndView getListAll() {
        return new ModelAndView(
                "list", "persons", personService.findAll());
    }

    @GetMapping("/addPerson")
    public ModelAndView viewAddPerson() {
        return new ModelAndView("create","person",new Person());
    }

    @PostMapping("/addPerson")

    public String addPerson(Person person, RedirectAttributes redirect) {
        person.setId((int) (Math.random() * 100000));
        personService.add(person);
        redirect.addFlashAttribute("message", "Add New Person Success ! ");
        return "redirect:/";
    }

}
