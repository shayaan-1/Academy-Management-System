package com.example.fxwalaproject;


import java.util.*;
public class Faculty extends Person{
    Scanner sc = new Scanner(System.in);
    private double salary;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    private Course course;
    private ArrayList<Classes> classes = new ArrayList<>();

    public ArrayList<Classes> getClasses() {
        return classes;
    }

    private String course1; // temporary variable for displaying data in teacher view table
    private String course2; // temporary variable for displaying data in teacher view table

    public String getCourse1() {
        return course1;
    }

    public String getCourse2() {
        return course2;
    }
    //Below constructor is only created for displaying data in teacher view table


    public Faculty(String name, String contact, double salary, int id, String course1, String course2) {
        super(name, contact);
        setSalary(salary);
        setId(id);
        this.course1 = course1;
        this.course2 = course2;
    }

    public void setClasses(ArrayList<Classes> classes) {
        this.classes = classes;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    //constructor for edit teacher

    public Faculty(String name, String contact, double salary) {
        super(name, contact);
        this.salary = salary;
    }
}


