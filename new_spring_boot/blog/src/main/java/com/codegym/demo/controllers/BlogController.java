package com.codegym.demo.controllers;

import com.codegym.demo.model.Blog;
import com.codegym.demo.service.BlogService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @RequestMapping("/")
    public String home(Model model) {
        List<Blog> blogs = blogService.findAll();
        model.addAttribute("blogs", blogs);
        return "blog/home";
    }

    @GetMapping("/blog-create")
    public String createFrom(Model model) {
        Blog blog = new Blog();
        model.addAttribute("blog", blog);
        return "blog/create";
    }

    @PostMapping("/blog-create")
    public ModelAndView create(@ModelAttribute("blog") Blog blog) {
        blogService.saveUser(blog);
        ModelAndView modelAndView = new ModelAndView("blog/create");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "Create Success !!!");
        return modelAndView;
    }
    @GetMapping("/blog-delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id ) {
        blogService.deleteUser(id);
       List<Blog> blogs= blogService.findAll();
        ModelAndView modelAndView = new ModelAndView("blog/home");
        modelAndView.addObject("message", "Delete Success !!!");
        modelAndView.addObject("blogs",blogs);
        return modelAndView;
    }
}
