package com.codegym.demo.Controller;

import com.codegym.demo.Repository.LoaiKhachRepository;
import com.codegym.demo.Service.*;
import com.codegym.demo.Service.Impl.VitriServiceImpl;
import com.codegym.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ItemController {
    @Autowired
    private KhachHangService khachHangService;
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

    @PostMapping("/create-item")
    public ModelAndView createItem(@ModelAttribute("text-input") String item, @ModelAttribute("select") String id) {
        ModelAndView modelAndView = new ModelAndView("admin/table");
        switch (id) {
            case "1":
                ViTri viTri = new ViTri();
                viTri.setName(item);
                viTriService.save((viTri));
                break;
            case "2":
                TrinhDo trinhDo = new TrinhDo();
                trinhDo.setName(item);
                trinhDoService.save(trinhDo);
                break;
            case "3":
                BoPhan boPhan = new BoPhan();
                boPhan.setName(item);
                boPhanService.save(boPhan);
                break;
            case "4":
                LoaiDichVu loaiDichVu = new LoaiDichVu();
                loaiDichVu.setName(item);
                loaiDichVuService.save(loaiDichVu);
                break;
            case "5":
                LoaiKhach loaiKhach = new LoaiKhach();
                loaiKhach.setName(item);
                loaiKhachService.save(loaiKhach);
                break;
            default:
        }

        UserController.showItem(modelAndView, viTriService, trinhDoService, boPhanService, loaiDichVuService, loaiKhachService,khachHangService);

        return modelAndView;
    }

    @GetMapping("/edit-item/{id}/{idItem}")
    public ModelAndView editItemForm(@PathVariable String id, @PathVariable Long idItem) {
        ModelAndView modelAndView = new ModelAndView("admin/table");
        switch (id) {
            case "1":
                ViTri viTri = viTriService.findById(idItem);
                modelAndView.addObject("itembyid", viTri);
                break;
            case "2":
                TrinhDo trinhDo = trinhDoService.findById(idItem);
                modelAndView.addObject("itembyid", trinhDo);
                break;
            case "3":
                BoPhan boPhan = boPhanService.findById(idItem);
                modelAndView.addObject("itembyid", boPhan);
                break;
            case "4":
                LoaiDichVu loaiDichVu = loaiDichVuService.findById(idItem);
                modelAndView.addObject("itembyid", loaiDichVu);
                break;
            case "5":
                LoaiKhach loaiKhach = loaiKhachService.findById(idItem);
                modelAndView.addObject("itembyid", loaiKhach);
                break;
            default:
        }
        UserController.showItem(modelAndView, viTriService, trinhDoService, boPhanService, loaiDichVuService, loaiKhachService,khachHangService);
        return modelAndView;

    }

    @PostMapping("/edit-item")
    public ModelAndView editItem(@ModelAttribute("select2") String id, @ModelAttribute("item") Object item) {
        ModelAndView modelAndView = new ModelAndView("admin/table");
        switch (id) {
            case "1":
                viTriService.save((ViTri) item);
                break;
            case "2":
                trinhDoService.save((TrinhDo)item);
                break;
            case "3":
                boPhanService.save((BoPhan) item);
                break;
            case "4":
                loaiDichVuService.save((LoaiDichVu) item);
                break;
            case "5":
               loaiKhachService.save((LoaiKhach) item);
                break;
            default:
        }
        UserController.showItem(modelAndView, viTriService, trinhDoService, boPhanService, loaiDichVuService, loaiKhachService,khachHangService);
        return modelAndView;
    }
}
