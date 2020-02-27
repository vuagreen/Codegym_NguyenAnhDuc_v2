package B3_Lop_Va_Doi_Tuong.Bai_Tap;

import java.util.Scanner;

public class QuadraticEquation {
    private double a, b, c;
    public Scanner sc = new Scanner(System.in);
    public QuadraticEquation() {

    }

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;

    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getDiscriminant() {
        return (Math.pow(b, 2) - 4 * a * c);
    }

    public double getRoot1() {
        if (getDiscriminant() >= 0) {
            return ((-b + Math.pow(getDiscriminant(), 2)) / (2 * a));
        } else {
            return 0;
        }

    }

    public double getRoot2() {
        if (getDiscriminant() >= 0) {
            return ((-b - Math.pow(getDiscriminant(), 2)) / (2 * a));
        } else {
            return 0;
        }

    }

    public void Math1() {
        System.out.println("Enter a,b,c is ax^2+bx+c=0 ");
        System.out.print("a =");
        double a = sc.nextDouble();
        System.out.print("b =");
        double b = sc.nextDouble();
        System.out.print("c =");
        double c = sc.nextDouble();
        QuadraticEquation qua = new QuadraticEquation(a, b, c);
        if (qua.getDiscriminant() > 0) {
            System.out.println("X1 = " + qua.getRoot1() + "\t X2 = " + qua.getRoot2());
        } else if (qua.getDiscriminant() == 0) {
            System.out.println("X1=X2 = " + qua.getRoot1());

        } else {
            System.out.println("The equation has no roots");
        }

    }

}
