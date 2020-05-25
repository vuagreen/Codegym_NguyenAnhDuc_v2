package B2_Mang_Va_Phuong_Thuc;

public class demo {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;
//        int t = a;
//        a = b;
//        b = t;
        System.out.println(a + "  " + b);
        swap(a, b);
        System.out.println(a + " 2 " + b);

        System.out.println(swap2(a, b));

    }

    public static void swap(int first, int second) {
        int temp = first;
        first = second;
        second = temp;
    }

    public static Integer swap2(int a, int b) {
        int t = a;
        a = b;
        b = t;
        return a;
    }
}

