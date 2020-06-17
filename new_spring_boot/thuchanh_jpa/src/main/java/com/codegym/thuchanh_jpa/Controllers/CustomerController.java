package com.codegym.thuchanh_jpa.Controllers;

import com.codegym.thuchanh_jpa.Service.CustomerService;
import com.codegym.thuchanh_jpa.Service.Impl.CustomerServiceimpl;
import com.codegym.thuchanh_jpa.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @GetMapping("/create-customer")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create-customer")
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer){
        customerService.save(customer);

        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }

    @GetMapping("/customers")
    public String list(Model model) {
       List<Customer> customers= customerService.findAll();
        model.addAttribute("customers", customers);
        return "customer/index";
    }

    @GetMapping("/delete-customer/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        Customer customerD = customerService.findById(id);
        customerService.remove(id);
      List<Customer> customers=  customerService.findAll();

        ModelAndView modelAndView = new ModelAndView("/customer/index");
        modelAndView.addObject("customers", customers);
        modelAndView.addObject("customerD", customerD);
        modelAndView.addObject("message", "Delete ");
        modelAndView.addObject("message2", " Success !!! ");
        return modelAndView;
    }
}
