package com.codegym.springbootormblog.controllers;

import com.codegym.springbootormblog.model.Blog;
import com.codegym.springbootormblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/blogs")
    public ModelAndView listBlogs() {
        Iterable<Blog> blog = blogService.findAll();
        ModelAndView modelAndView = new ModelAndView("/blog/list");
        modelAndView.addObject("blogs", blog);
        return modelAndView;
    }

    @GetMapping("/create-blog")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/create-blog")
    public ModelAndView saveProvince(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("message", "New Blog created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-blog/{id}")
    public ModelAndView showEditForm(@PathVariable String id) {
        Blog blog = blogService.findById(id);
        if (blog != null) {
            ModelAndView modelAndView = new ModelAndView("/blog/edit");
            modelAndView.addObject("blog", blog);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-blog")
    public ModelAndView updateProvince(@ModelAttribute("blog") Blog blog) {
        blog.setTimeUp(new Date());
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "Province updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-blog/{id}")
    public ModelAndView showDeleteForm(@PathVariable String id) {
        Blog blog = blogService.findById(id);
        if (blog != null) {
            ModelAndView modelAndView = new ModelAndView("/blog/delete");
            modelAndView.addObject("blog", blog);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-blog/{id}")
    public String deleteBlog(@PathVariable String id) {
        blogService.remove(id);
        return "redirect:/blogs";
    }
}
