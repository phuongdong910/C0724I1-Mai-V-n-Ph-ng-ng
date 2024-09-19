package Test;

import main.Student;
import main.StudentList;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentList studentList = new StudentList();
        int choice = 0;
        do {
            System.out.println("MENU-------");
            System.out.println("Please select function");
            System.out.println(
                    "1. Add a student to the list.\n" +
                            "2. Print the student list to the screen.\n" +
                            "3. Check if the list is empty.\n" +
                            "4. Get the number of students in the list.\n" +
                            "5. Clear the student list.\n" +
                            "6. Check if a student exists in the list based on the student ID.\n" +
                            "7. Remove a student from the list based on the student ID.\n" +
                            "8. Search for all students based on the name entered from the keyboard.\n" +
                            "9. Display the list of students sorted by descending grades." +
                            "0. Exit the program");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter Student ID: ");
                    String studentCode = sc.nextLine();
                    System.out.println("Enter Student Name: ");
                    String studentName = sc.nextLine();
                    System.out.println("Enter Student Age: ");
                    int studentAge = sc.nextInt();
                    System.out.println("Enter Student Average: ");
                    double studentAverage = sc.nextDouble();
                    Student student = new Student(studentCode, studentName, studentAge, studentAverage);
                    studentList.addStudent(student);
                }
                case 2 -> {
                    studentList.printStudentList();
                }
                case 3 -> {
                    System.out.println("Check list is empty: " + studentList.checkEmptyList());
                }
                case 4 -> {
                    System.out.println(" Get the number of students in the list: " + studentList.getSizeStudent());
                }
                case 5 -> {
                    studentList.clearList();
                }

//                6. Check if a student exists in the list based on the student ID
                case 6 -> {
                    System.out.println("Enter code student: ");
                    String studentCode = sc.nextLine();
                    Student student = new Student(studentCode);
                    System.out.println("Check the student list: " + studentList.checkExists(student));

                }
                case 7 -> {
                    System.out.println("Enter code student: ");
                    String studentCode = sc.nextLine();
                    Student student = new Student(studentCode);
                    System.out.println(" Delete  student from list: " + studentList.removeStudent(student));
                }
                case 8 -> {
                    System.out.println("Enter name student: ");
                    String studentName = sc.nextLine();
                    System.out.println(" Result search: ");
                    studentList.findStudent(studentName);
                }
                case 9 -> {
                    studentList.sortStudentListDescendingByScore();
                    studentList.printStudentList();
                }
            }

        } while (choice != 0);
    }
}
