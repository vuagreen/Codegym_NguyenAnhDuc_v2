package B3_Lop_Va_Doi_Tuong.Bai_Tap.Stop_Watch;
import B2_Mang_Va_Phuong_Thuc.Thuc_Hanh.Tim_So_Lon_Nhat;

import java.util.Date;

public class StopWatch {
    private long startTime;
    private long endTime;

    public StopWatch()
    {
        startTime = System.currentTimeMillis();
    }

    public void start() {
        startTime = System.currentTimeMillis();
    }
    public void end() {
        endTime = System.currentTimeMillis();
    }

    public long getElapsedTime() {
        return (endTime - startTime);
    }

    public static void main(String[] args) {
        StopWatch watch = new StopWatch();
        watch.start();
        Tim_So_Lon_Nhat.arrayOne(100000);
        //Tim_So_Lon_Nhat.max();
        Tim_So_Lon_Nhat.show3();
        //Tim_So_Lon_Nhat.showMax();
        watch.end();
        System.out.println(+watch.getElapsedTime()+" ms");

    }
}
