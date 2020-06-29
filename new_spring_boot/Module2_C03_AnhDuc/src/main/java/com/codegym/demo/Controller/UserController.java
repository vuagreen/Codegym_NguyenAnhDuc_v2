package com.codegym.demo.Controller;

import com.codegym.demo.Service.*;
import com.codegym.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {
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
    @GetMapping("/home")
    public String home(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "home/index";
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView("admin/table");

        showItem(modelAndView, viTriService, trinhDoService, boPhanService, loaiDichVuService, loaiKhachService);
        List<KhachHang> khachHangs = (List<KhachHang>) khachHangService.findAll();
        modelAndView.addObject("khachhanglist", khachHangs);
        List<User> userList=  (List<User>)userService.findAll();

        if (user.getUser().equals(user.getUser())) {
            if (user.getPassword().equals(user.getPassword())) {
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

    static void showItem(ModelAndView modelAndView, ViTriService viTriService, TrinhDoService trinhDoService, BoPhanService boPhanService, LoaiDichVuService loaiDichVuService, LoaiKhachService loaiKhachService) {
        List<ViTri> viTriList = (List<ViTri>) viTriService.findAll();
        List<TrinhDo> trinhDoList = (List<TrinhDo>) trinhDoService.findAll();
        List<BoPhan> boPhanList = (List<BoPhan>) boPhanService.findAll();
        List<LoaiDichVu> loaiDichVuList = (List<LoaiDichVu>) loaiDichVuService.findAll();
        List<LoaiKhach> loaiKhachList = (List<LoaiKhach>) loaiKhachService.findAll();

        modelAndView.addObject("vitris", viTriList);
        modelAndView.addObject("trinhdos", trinhDoList);
        modelAndView.addObject("bophans", boPhanList);
        modelAndView.addObject("loaidichvus", loaiDichVuList);
        modelAndView.addObject("loaikhachs", loaiKhachList);
    }
}
