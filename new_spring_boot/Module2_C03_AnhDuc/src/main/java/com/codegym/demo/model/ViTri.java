package com.codegym.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class ViTri {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "viTri", cascade = CascadeType.ALL)
    private List<NhanVien> nhanViens;

    public ViTri() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<NhanVien> getNhanViens() {
        return nhanViens;
    }

    public void setNhanViens(List<NhanVien> nhanViens) {
        this.nhanViens = nhanViens;
    }
}
