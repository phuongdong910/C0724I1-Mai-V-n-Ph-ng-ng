package ss4_student_manager.service;

import ss4_student_manager.model.Student;
import ss4_student_manager.repository.StudentRepository;

public class StudentService {
    private StudentRepository studentRepository = new StudentRepository();
    public Student[] getAll(){
      return studentRepository.getAll();
    }

    public void add(Student student){
        // kiểm thông tin nhập vào có hợp ký hay không không? => validate
      studentRepository.add(student);
    }
}
