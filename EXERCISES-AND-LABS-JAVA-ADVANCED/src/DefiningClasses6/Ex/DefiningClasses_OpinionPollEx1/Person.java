package DefiningClasses6.Ex.DefiningClasses_OpinionPollEx1;

public class Person {
    //полета
    private String name;
    private int age;
//методи


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;

    }
}
