package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CaculatorController {
    @PostMapping("/calculator")
    public String calculator(@RequestParam("operator") String[] operator, Model model) {
        Float num1 = Float.parseFloat(operator[0]);
        Float num2 = Float.parseFloat(operator[2]);
        Float end=0.0f;
        switch (operator[1]) {
            case "+":
                end = num1 + num2;
                break;
            case "-":
                end = num1 - num2;
                break;
            case "*":
                end = num1 * num2;
                break;
            case "/":
                if (num2 != 0)
                    end = num1 / num2;
                else
                    throw new RuntimeException("Can't divide by zero");
//            default:
//                throw new RuntimeException("Invalid operation");
        }

        model.addAttribute("end", end);
        return "index";


    }

}
