package Models;

public class Room extends Services {
    private String dichVuMienPhiDiKem;

    public Room() {
    }

    public Room(String dichVuMienPhiDiKem) {
        this.dichVuMienPhiDiKem = dichVuMienPhiDiKem;
    }

    public Room(String id, String tenDichVu, double dienTichSuDung, double chiPhiThue, int soNguoiToiDa, String kieuThue, String dichVuMienPhiDiKem) {
        super(id, tenDichVu, dienTichSuDung, chiPhiThue, soNguoiToiDa, kieuThue);
        this.dichVuMienPhiDiKem = dichVuMienPhiDiKem;
    }

    public String getDichVuMienPhiDiKem() {
        return dichVuMienPhiDiKem;
    }

    public void setDichVuMienPhiDiKem(String dichVuMienPhiDiKem) {
        this.dichVuMienPhiDiKem = dichVuMienPhiDiKem;
    }


    @Override
    public String showInfor() {
        return super.showInfor() +
                "dichVuMienPhiDiKem='" + dichVuMienPhiDiKem + '\'';
    }

}
