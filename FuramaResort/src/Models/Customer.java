package Models;

public class Customer {
    private String tenCustomer;
    private String ngaySinh;
    private String gioiTinh;
    private int cmnd;
    private int soDienTHoai;
    private String email;
    private String loaiKhach;
    private String diaChi;


    public Customer() {
    }

    public Customer(String tenCustomer, String ngaySinh, String gioiTinh, int cmnd, int soDienTHoai, String email, String loaiKhach, String diaChi) {
        this.tenCustomer = tenCustomer;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.cmnd = cmnd;
        this.soDienTHoai = soDienTHoai;
        this.email = email;
        this.loaiKhach = loaiKhach;
        this.diaChi = diaChi;
    }

    public String getTenCustomer() {
        return tenCustomer;
    }

    public void setTenCustomer(String tenCustomer) {
        this.tenCustomer = tenCustomer;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getCmnd() {
        return cmnd;
    }

    public void setCmnd(int cmnd) {
        this.cmnd = cmnd;
    }

    public int getSoDienTHoai() {
        return soDienTHoai;
    }

    public void setSoDienTHoai(int soDienTHoai) {
        this.soDienTHoai = soDienTHoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoaiKhach() {
        return loaiKhach;
    }

    public void setLoaiKhach(String loaiKhach) {
        this.loaiKhach = loaiKhach;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "tenCustomer='" + tenCustomer + '\'' +
                ", ngaySinh='" + ngaySinh + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", cmnd=" + cmnd +
                ", soDienTHoai=" + soDienTHoai +
                ", email='" + email + '\'' +
                ", loaiKhach='" + loaiKhach + '\'' +
                ", diaChi='" + diaChi + '\'' +
                '}';
    }
}
