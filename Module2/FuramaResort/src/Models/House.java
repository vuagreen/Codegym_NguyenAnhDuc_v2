package Models;

public class House extends Services {
    private String tieuChuanPhong;
    private String tienNghiKhac;
    private int soTang;

    public House() {
    }

    public House(String tieuChuanPhong, String tienNghiKhac, int soTang) {
        this.tieuChuanPhong = tieuChuanPhong;
        this.tienNghiKhac = tienNghiKhac;
        this.soTang = soTang;
    }

    public House(String id, String tenDichVu, double dienTichSuDung, double chiPhiThue, int soNguoiToiDa, String kieuThue, String tieuChuanPhong, String tienNghiKhac, int soTang) {
        super(id, tenDichVu, dienTichSuDung, chiPhiThue, soNguoiToiDa, kieuThue);
        this.tieuChuanPhong = tieuChuanPhong;
        this.tienNghiKhac = tienNghiKhac;
        this.soTang = soTang;
    }

    public String getTieuChuanPhong() {
        return tieuChuanPhong;
    }

    public void setTieuChuanPhong(String tieuChuanPhong) {
        this.tieuChuanPhong = tieuChuanPhong;
    }

    public String getTienNghiKhac() {
        return tienNghiKhac;
    }

    public void setTienNghiKhac(String tienNghiKhac) {
        this.tienNghiKhac = tienNghiKhac;
    }

    public int getSoTang() {
        return soTang;
    }

    public void setSoTang(int soTang) {
        this.soTang = soTang;
    }

    @Override
    public String showInfor() {
        return super.showInfor()+
                "tieuChuanPhong='" + tieuChuanPhong + '\'' +
                ", tienNghiKhac='" + tienNghiKhac + '\'' +
                ", soTang=" + soTang ;
    }


}
