package B1_Ngon_Ngu_Lap_Trinh_Java.demo;

class ChuNhat {
    public int rong, dai;

    public ChuNhat(int rong, int dai) {
        this.rong = rong;
        this.dai = dai;
    }
}

class MyClass {
    void method(ChuNhat x) {
        x.rong = 5;
        x.dai = 5;
    }

    public static void main(String[] args) {
        MyClass o = new MyClass();
        ChuNhat cn = new ChuNhat(1, 1);
        o.method(cn);
        System.out.printf("x=%d, y=%d", cn.rong, cn.dai);
    }
}


