package B2_Mang_Va_Phuong_Thuc.Thuc_Hanh;

public class Dao_Nguoc_Phan_Tu {
    static int array[];

    public static void sss() {
        for (int j = 0; j < array.length / 2; j++) {
            int temp = array[j];
            array[j] = array[array.length - 1 - j];
            array[array.length - 1 - j] = temp;
        }
    }

    public static void main(String[] args) {
        Tim_So_Lon_Nhat.arrayOne(10);
        array = Tim_So_Lon_Nhat.getArray();
        Tim_So_Lon_Nhat.show(array);
        System.out.println("");
        sss();
        Tim_So_Lon_Nhat.show(array);
    }
}
