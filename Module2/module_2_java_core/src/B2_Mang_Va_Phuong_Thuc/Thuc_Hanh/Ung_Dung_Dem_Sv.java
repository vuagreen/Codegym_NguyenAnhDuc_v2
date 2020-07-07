package B2_Mang_Va_Phuong_Thuc.Thuc_Hanh;

public class Ung_Dung_Dem_Sv {
    public static int[] array;
    static int count;

    public static void checkNumber() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 5) {
                count++;
            }
        }
    }
    public static void main(String[] args) {
        Tim_So_Lon_Nhat.arrayOne(10);
        array = Tim_So_Lon_Nhat.getArray();
        Tim_So_Lon_Nhat.show(array);
        checkNumber();
        System.out.println("\t Amount Pass : "+count);

    }
}
