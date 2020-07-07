package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DoitienController {
    @GetMapping("/doitien")
    public String doitien(Model model) {
        return "index";
    }

    @PostMapping("/doitien")
    public String ketQua(@RequestParam String usd, Model model) {
       Integer usd2 = Integer.parseInt(usd);
        Integer num = usd2 * 22000;
        model.addAttribute("num", num);
        return "index";
    }

}
