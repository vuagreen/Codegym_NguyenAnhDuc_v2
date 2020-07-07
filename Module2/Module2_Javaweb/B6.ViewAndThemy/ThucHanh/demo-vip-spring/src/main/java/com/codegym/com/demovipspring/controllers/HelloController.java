package com.codegym.com.demovipspring.controllers;

import com.codegym.com.demovipspring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
    @Autowired
    private PersonService personService;
    @RequestMapping("")
    public ModelAndView Hello() {
        return new ModelAndView("hello", "persons", personService.findAll());
    }

}
