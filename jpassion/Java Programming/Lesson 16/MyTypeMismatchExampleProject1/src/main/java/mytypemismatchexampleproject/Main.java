package mytypemismatchexampleproject;

public class Main {

    public static void main(String[] args) {

        // Implicit casting - Student object instance is
        // type of Person.
        Person person1 = new Student();

        // Implicit casting - Teacher object instance is
        // type of Person.
        Person person2 = new Teacher();

        // Explicit type casting.
        Student student1 = (Student) person1;

        // Explicit type casting - no compile error.
        // But ClassCastException will occur during runtime.
        Student student2 = (Student) person2;
    }

}
