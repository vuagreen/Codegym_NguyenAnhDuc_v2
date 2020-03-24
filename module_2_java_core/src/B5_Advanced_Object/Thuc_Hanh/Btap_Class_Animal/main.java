package B5_Advanced_Object.Thuc_Hanh.Btap_Class_Animal;
import B5_Advanced_Object.Thuc_Hanh.Btap_Class_Animal.Fruit.Fruit;
import B5_Advanced_Object.Thuc_Hanh.Btap_Class_Animal.Fruit.Orange;
import B5_Advanced_Object.Thuc_Hanh.Btap_Class_Animal.Fruit.Apple;
public class main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[3];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal : animals) {
            System.out.println( animal.makeSound());
            if (animal instanceof Chicken) {
                Edible edibler = (Chicken) animal;
                System.out.println(edibler.howtoEat());
            }
        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Orange();
        fruits[1] = new Apple();
        for (Fruit fruit : fruits) {
            System.out.println(fruit.howtoEat());
        }

        }


    }
}
