package streamapi;

public class People {

    private String name;
    private int age;
    private Sex sex;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "name, " + name + ", " +
                "age, " + age + ", " +
                "sex, " + sex + "\n";
    }
    public People(String name, int age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
}
