package B3_Lop_Va_Doi_Tuong.Bai_Tap;

import B2_Mang_Va_Phuong_Thuc.Thuc_Hanh.Tim_So_Lon_Nhat;

import java.util.Date;

public class stop_fan {
    private Date startTime;
    private Date endTime;

    public stop_fan() {
        setStartTime(new Date());
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void start() {
        setEndTime(new Date());
    }

    public void stop() {
        setEndTime(new Date());
    }

    public void getElapsedTime() {
        long c = getEndTime().getTime() - getStartTime().getTime();
        System.out.println("endTime - startTime = "+c+" msec");
    }

    public static void main(String[] args) {
        stop_fan st = new stop_fan();
        st.start();
        Tim_So_Lon_Nhat.arrayOne(1000);
        st.stop();
        st.getElapsedTime();
    }
}
