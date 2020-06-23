package com.codegym.demo.Controller;

import com.codegym.demo.Service.UserService;
import com.codegym.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public String home(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "home/index";
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView("admin/index");
        if (user.getUser().equals("admin")) {
            if (user.getPassword().equals("admin")) {
                return modelAndView;
            } else {
                 modelAndView = new ModelAndView("home/index");
                modelAndView.addObject("message", "Sai Mật Khẩu !!!");
                return modelAndView;
            }
        } else {
            modelAndView = new ModelAndView("home/index");
            modelAndView.addObject("message", " UserName Không Tồn Tại !!!");
            return modelAndView;
        }
    }
}
