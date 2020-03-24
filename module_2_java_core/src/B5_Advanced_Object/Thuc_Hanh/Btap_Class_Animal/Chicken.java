package B5_Advanced_Object.Thuc_Hanh.Btap_Class_Animal;

public class Chicken extends Animal implements Edible{
    @Override
    String makeSound() {
        return "Chicken: cluck-cluck!";
    }

    @Override
    public String howtoEat() {
        return "Eat Rice";
    }
}
