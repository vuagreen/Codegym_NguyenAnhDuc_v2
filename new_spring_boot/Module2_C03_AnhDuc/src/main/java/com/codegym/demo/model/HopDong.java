package com.codegym.demo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class HopDong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date ngayLamHopDong;
    private Date ngayKetThucHopDong;
    private int tienCoc;
    private int tongTien;

    @ManyToOne
    @JoinColumn
    private NhanVien nhanViens;

    @ManyToOne
    @JoinColumn
    private DichVu dichVu;

    @ManyToOne
    @JoinColumn
    private HopDongChiTiet hopDongChiTiet;

    @ManyToOne
    @JoinColumn
    private KhachHang khachHang;

    public HopDong() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getNgayLamHopDong() {
        return ngayLamHopDong;
    }

    public void setNgayLamHopDong(Date ngayLamHopDong) {
        this.ngayLamHopDong = ngayLamHopDong;
    }

    public Date getNgayKetThucHopDong() {
        return ngayKetThucHopDong;
    }

    public void setNgayKetThucHopDong(Date ngayKetThucHopDong) {
        this.ngayKetThucHopDong = ngayKetThucHopDong;
    }

    public int getTienCoc() {
        return tienCoc;
    }

    public void setTienCoc(int tienCoc) {
        this.tienCoc = tienCoc;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public NhanVien getNhanViens() {
        return nhanViens;
    }

    public void setNhanViens(NhanVien nhanViens) {
        this.nhanViens = nhanViens;
    }

    public DichVu getDichVu() {
        return dichVu;
    }

    public void setDichVu(DichVu dichVu) {
        this.dichVu = dichVu;
    }

    public HopDongChiTiet getHopDongChiTiet() {
        return hopDongChiTiet;
    }

    public void setHopDongChiTiet(HopDongChiTiet hopDongChiTiet) {
        this.hopDongChiTiet = hopDongChiTiet;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }
}
