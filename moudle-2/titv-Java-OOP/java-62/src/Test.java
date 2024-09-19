import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> course = new ArrayList<String>();
        course.add("Java");
        course.add("Python");
        course.add(".Net");
        course.add("PHP");
        System.out.println("Current course list: " + course);

        String [] newCourse = {"Javascript", "ReactJS"};

        Collections.addAll(course, newCourse);
        System.out.println("Course list after addAll: " + course);



    }
}
