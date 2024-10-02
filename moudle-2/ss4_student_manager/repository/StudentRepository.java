package ss4_student_manager.repository;

import ss4_student_manager.model.Student;

public class StudentRepository {

    private static Student[] students =  new Student[100];
    static {
        students[0]= new Student(1,"chanh1");
        students[1]= new Student(2,"chanh2");
    }
    public Student[] getAll(){
        // đoọc file
        return students;
    }

    public void add(Student student){
        // ghi file
        for (int i = 0; i <students.length ; i++) {
            if (students[i]==null){
                students[i] = student;
                break;
            }
        }
    }
}
