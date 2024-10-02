package ss4_student_manager.controller;

import ss4_student_manager.model.Student;
import ss4_student_manager.service.StudentService;

import java.util.Scanner;

public class StudentController {
    private static Scanner scanner = new Scanner(System.in);
    private static StudentService studentService = new StudentService();

    public static void showStudentMenu() {

        while (true) {
            System.out.println("Chọn chức năng :\n" +
                    "1. Hiển thị\n" +
                    "2. Thêm mới\n" +
                    "3. Xoá\n" +
                    "4. Thoát");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("----------Hiển thị danh sách --------------");
                    Student[] students = studentService.getAll();
                    displayStudentList(students);
                    break;
                case 2:
                    System.out.println("----------Thêm mới--------------");
                    Student student = inputDataStudent();
                    studentService.add(student);
                    System.out.println("Thêm mới thành công");
                    break;
                case 3:
                    System.out.println("----------Xoá --------------");
                    break;
                default:
                    System.exit(0);
            }
        }
    }
    public static Student inputDataStudent (){
        System.out.println("Nhập id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập name");
        String name = scanner.nextLine();
        Student student = new Student(id,name);
        return student;
    }
    public static void displayStudentList(Student[] students){
        for (int i = 0; i < students.length; i++) {
            if (students[i]!=null){
                System.out.println(students[i]);
            }else {
                break;
            }
        }
    }
}
