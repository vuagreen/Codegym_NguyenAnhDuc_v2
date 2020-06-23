package com.codegym.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class DichVuDiKem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tenDichVuDiKem;
    private int gia;
    private String donVi;
    private boolean trangThaiKhaDung;

    @OneToMany(mappedBy = "dichVuDiKem")
    private List<HopDongChiTiet> hopDongChiTiets;

    public DichVuDiKem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenDichVuDiKem() {
        return tenDichVuDiKem;
    }

    public void setTenDichVuDiKem(String tenDichVuDiKem) {
        this.tenDichVuDiKem = tenDichVuDiKem;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public boolean isTrangThaiKhaDung() {
        return trangThaiKhaDung;
    }

    public void setTrangThaiKhaDung(boolean trangThaiKhaDung) {
        this.trangThaiKhaDung = trangThaiKhaDung;
    }

    public List<HopDongChiTiet> getHopDongChiTiets() {
        return hopDongChiTiets;
    }

    public void setHopDongChiTiets(List<HopDongChiTiet> hopDongChiTiets) {
        this.hopDongChiTiets = hopDongChiTiets;
    }
}
