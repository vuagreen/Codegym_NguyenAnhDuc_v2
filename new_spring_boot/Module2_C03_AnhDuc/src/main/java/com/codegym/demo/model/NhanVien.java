package com.codegym.demo.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String hoTen;
    private Date ngaySinh;
    private int soCmnd;
    private int luong;
    private int soDienThoai;
    private String email;
    private String diaChi;

    @ManyToOne
    @JoinColumn(name = "vi_tri_id")
    private ViTri viTri;

    @ManyToOne
    @JoinColumn(name = "bo_phan_id")
    private BoPhan boPhan;

    public NhanVien() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public int getSoCmnd() {
        return soCmnd;
    }

    public void setSoCmnd(int soCmnd) {
        this.soCmnd = soCmnd;
    }

    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }

    public int getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(int soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public ViTri getViTri() {
        return viTri;
    }

    public void setViTri(ViTri viTri) {
        this.viTri = viTri;
    }

    public BoPhan getBoPhan() {
        return boPhan;
    }

    public void setBoPhan(BoPhan boPhan) {
        this.boPhan = boPhan;
    }

    public TrinhDo getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(TrinhDo trinhDo) {
        this.trinhDo = trinhDo;
    }

    public List<HopDong> getHopDongs() {
        return hopDongs;
    }

    public void setHopDongs(List<HopDong> hopDongs) {
        this.hopDongs = hopDongs;
    }

    @ManyToOne
    @JoinColumn(name = "trinh_do_id")
    private TrinhDo trinhDo;

    @OneToMany(mappedBy = "nhanViens", cascade = CascadeType.ALL)
    private List<HopDong> hopDongs;

}
