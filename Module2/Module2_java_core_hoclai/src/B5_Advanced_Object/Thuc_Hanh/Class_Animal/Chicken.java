package B5_Advanced_Object.Thuc_Hanh.Class_Animal;

public class Chicken extends Animal implements Edible {
    @Override
    String makeSound() {
        return "Gà Kêu";
    }

    @Override
    public String howtoEat() {
        return "Ăn Hạt";
    }
}
