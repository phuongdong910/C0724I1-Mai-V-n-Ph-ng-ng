import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charlie", 35));

        // Sort the list of people by age
        Collections.sort(people);

        // Print the sorted list
        for (Person person : people) {
            System.out.println(person);
        }
    }
}