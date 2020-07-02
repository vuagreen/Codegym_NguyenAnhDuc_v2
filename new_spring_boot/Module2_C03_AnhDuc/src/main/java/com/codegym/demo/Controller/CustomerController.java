package com.codegym.demo.Controller;

import com.codegym.demo.Service.*;
import com.codegym.demo.model.KhachHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class CustomerController {
    @Autowired
    private UserService userService;
    @Autowired
    private ViTriService viTriService;
    @Autowired
    private TrinhDoService trinhDoService;
    @Autowired
    private BoPhanService boPhanService;
    @Autowired
    private LoaiDichVuService loaiDichVuService;
    @Autowired
    private LoaiKhachService loaiKhachService;
    @Autowired
    private KhachHangService khachHangService;

    @PostMapping("/create-customer")
    public String createCustomer(@ModelAttribute("customer") KhachHang customer, RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView("admin/table");

//        Date parsed = format.parse();
        khachHangService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Create Customer Success !!!");
        UserController.showItem(modelAndView, viTriService, trinhDoService, boPhanService, loaiDichVuService, loaiKhachService, khachHangService);
        return "redirect:/";
    }

    @GetMapping("/delete-customer/{id}")
    public String deleteCustomer(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView("admin/table");
        khachHangService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Delete Customer Success !!!");
        UserController.showItem(modelAndView, viTriService, trinhDoService, boPhanService, loaiDichVuService, loaiKhachService, khachHangService);
        return "redirect:/";
    }

    @PostMapping("/edit-customer")
    public String editCustomer(@ModelAttribute("customer") KhachHang customer, RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView("admin/table");
        khachHangService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Edit Customer ID "+customer.getId()+"  Success !!!");
        UserController.showItem(modelAndView, viTriService, trinhDoService, boPhanService, loaiDichVuService, loaiKhachService, khachHangService);
        return "redirect:/";
    }
}
