package mypeopleexample;

public class Main {

    public static void main(String[] args) {

        Person person1 = new Person();
        person1.myMethod("test1");

        Student student1 = new Student();
        student1.myMethod("test2");

        InternationalStudent internationalStudent1
                = new InternationalStudent();
        internationalStudent1.myMethod("test3");

    }
}
