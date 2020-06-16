package com.codegym.demo.controllers;

import com.codegym.demo.model.Product;
import com.codegym.demo.service.Impl.ProductServiceImpl;
import com.codegym.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
    private ProductService productService = new ProductServiceImpl();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("products", productService.findAll());
        model.addAttribute("success", productService.getClass());
        return "product/index";
    }

    @GetMapping("product/create")
    public String createForm(Model model) {
        model.addAttribute("product", new Product());
        return "product/create";
    }

    @PostMapping("product/create")

    public ModelAndView create(@ModelAttribute ("product") Product product) {
        product.setId((int) (Math.random() * 10000));
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("/product/create");
        modelAndView.addObject("message", "Create Product Success !!");
        return modelAndView;
    }

    @GetMapping("product/{id}/delete")
    public String delete(@PathVariable String id,Model model) {
       productService.remove(Integer.parseInt(id));
        model.addAttribute("products", productService.findAll());
        model.addAttribute("message", "Delete Success !!");
        return "product/index";
    }


}
