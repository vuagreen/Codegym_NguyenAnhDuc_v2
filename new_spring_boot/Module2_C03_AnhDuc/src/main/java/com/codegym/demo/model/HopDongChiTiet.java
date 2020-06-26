package com.codegym.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class HopDongChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int soLuong;

    @ManyToOne
    @JoinColumn
    private DichVuDiKem dichVuDiKem;

    public HopDongChiTiet() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public DichVuDiKem getDichVuDiKem() {
        return dichVuDiKem;
    }

    public void setDichVuDiKem(DichVuDiKem dichVuDiKem) {
        this.dichVuDiKem = dichVuDiKem;
    }

    public HopDong getHopDongs() {
        return hopDongs;
    }

    public void setHopDongs(HopDong hopDongs) {
        this.hopDongs = hopDongs;
    }

    @ManyToOne
    @JoinColumn
    private HopDong hopDongs;
}
