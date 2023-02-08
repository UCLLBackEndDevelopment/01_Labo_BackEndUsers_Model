package model;

public class User {

    public String name;
    private int age;

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
       if (age >= 0) 
           this.age = age;
    }

    public User(String name, int age) {
        this.name = name;
        setAge(age);
    }

    public User() {
    }
}