package B3_Lop_Va_Doi_Tuong;

public class demo {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public demo() {
    }

    public demo(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "demo{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public int sum() {
        setAge(getAge()+1);
        return getAge();
    }

    public double sum(double a) {
        setAge(getAge() + 2);
        return getAge();
    }
}
