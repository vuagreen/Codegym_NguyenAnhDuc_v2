package com.codegym.demo.controller;

import com.codegym.demo.Service.CustomerService;
import com.codegym.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public ModelAndView listCustomers(@RequestParam("name_customer") Optional<String> s, Pageable pageable) {
        Page<Customer> customers;
        if (s.isPresent()) {
            if (s.get().indexOf("KH") != -1) {
                customers = customerService.findAllByCodeCustomer(s.get(), pageable);
            } else {
                customers = customerService.findAllByName(s.get(), pageable);
            }


        } else {
            customers = customerService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @PostMapping("/create-customer")
    public ModelAndView saveCustomer(@Validated @Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
        new Customer().validate(customer, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("customer/create");
            return modelAndView;
        } else {
            customerService.save(customer);
            ModelAndView modelAndView = new ModelAndView("/customer/create");
            modelAndView.addObject("customer", new Customer());
            modelAndView.addObject("message", "New customer created successfully");
            return modelAndView;
        }

    }

    @GetMapping("/create-customer")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        Customer customer = new Customer();
        customer.setSex("male");
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }


    @GetMapping("/edit-customer/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Customer customer = customerService.findById(id);
        if (customer != null) {
            ModelAndView modelAndView = new ModelAndView("/customer/edit");
            modelAndView.addObject("customer", customer);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-customer")
    public ModelAndView updateCustomer(@Validated @Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
        new Customer().validate(customer, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("customer/edit");
            return modelAndView;
        } else {
            customerService.save(customer);
            ModelAndView modelAndView = new ModelAndView("/customer/edit");
            modelAndView.addObject("customer", customer);
            modelAndView.addObject("message", "Customer updated successfully");
            return modelAndView;
        }
    }

    @GetMapping("/delete-customer/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Customer customer = customerService.findById(id);
        if (customer != null) {
            ModelAndView modelAndView = new ModelAndView("/customer/delete");
            modelAndView.addObject("customer", customer);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-customer")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
        customerService.remove(customer.getId());
        redirectAttributes.addFlashAttribute("message", "Delete Customer Success !!!");
        return "redirect:customers";
    }
}
