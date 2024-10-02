package model;

public abstract class Member {
    public String name;
    public int age;
    public String position;

    public Member(String name, int age, String position) {
        this.name = name;
        this.age = age;
        this.position = position;
    }

    public abstract void displayInfo();
}
