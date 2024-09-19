package main;

import java.util.Objects;

public class Student implements Comparable<Student> {
    private String code;
    private String name;
    private int age;
    private double average;

    public Student(String code) {
        this.code = code;
    }

    public Student(String code, String name, int age, double average) {
        this.code = code;
        this.name = name;
        this.age = age;
        this.average = average;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    @Override
    public String toString() {
        return "Student{" + "code='" + code + '\'' + ", name='" + name + '\'' + ", age=" + age + ", average=" + average + '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.code.compareTo(o.code);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(code, student.code);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(code);
    }
}
