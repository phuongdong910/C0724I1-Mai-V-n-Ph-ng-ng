package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StudentList {
    private final ArrayList<Student> list;

    public StudentList() {
        this.list = new ArrayList<Student>();
    }

    public StudentList(ArrayList<Student> list) {
        this.list = list;
    }

    // Thêm danh sách sinh viên
    public void addStudent(Student student) {
        this.list.add(student);
    }

    // print  the student list to the screen
    public void printStudentList() {
        for (Student student1 : list) {
            System.out.println(student1.toString());
        }
    }

    public boolean checkEmptyList() {
        return this.list.isEmpty();
    }

    public int getSizeStudent() {
        return this.list.size();
    }

    public void clearList() {
        this.list.clear();
    }

    public boolean checkExists(Student student) {
        return this.list.contains(student);
    }

    public boolean removeStudent(Student student) {
        return this.list.remove(student);
    }

    public void findStudent(String name) {
        for (Student student : list) {
            if (student.getName().equals(name)) {
                System.out.println(student);
            }
        }
    }

    public void sortStudentListDescendingByScore() {
        Collections.sort(this.list, new Comparator<Student>() {

            @Override
            public int compare(Student student1, Student student2) {
                // Đảo ngược kết quả của Double.compare để sắp xếp giảm dần
                return Double.compare(student2.getAverage(), student1.getAverage());
            }
        });
    }

}
