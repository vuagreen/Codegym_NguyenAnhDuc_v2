package B1_Ngon_Ngu_Lap_Trinh_Java.demo;


public class Demo {
    public static void main(String[] args) {
        C a = new C();
        a.p(10);
        a.p(10.0);
    }
}

class C extends A {
    public void p(String number) {
        System.out.println(number);
    }
}

class A extends B {
    @Override
    public void p(double number) {
        System.out.println(number);
    }
}

class B {
    public void p(double number) {
        System.out.println(number);
    }
}
