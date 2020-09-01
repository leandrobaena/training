package mypackage;

import java.util.Collections;
import java.util.List;
import java.util.Comparator;

public class ComparatorTest {

    public static void main(String[] args) {

        List<Person> personList = Person.createShortList();

        Collections.sort(personList, new Comparator<Person>() {
            public int compare(Person p1, Person p2) {
                return p1.getSurName().compareTo(p2.getSurName());
            }
        });

        System.out.println("=== Sorted Asc SurName ===");
        for (Person p : personList) {
            p.printName();
        }

        Collections.sort(personList, new Comparator<Person>() {
            public int compare(Person p1, Person p2) {
                return p1.getSurName().length() - (p2.getSurName().length());
            }
        });

        System.out.println("=== Sorted Asc SurName ===");
        for (Person p : personList) {
            p.printName();
        }

    }
}
