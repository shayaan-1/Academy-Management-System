package com.example.fxwalaproject;


import java.util.Scanner;
public class Course {
    Scanner sc = new Scanner(System.in);
    private String courseName;
    private Grades grades;
    private Faculty teacher;
    private int courseId;

    private double marks; //temporary variable to show data in search student table
    private String grade; //temporary variable to show data in search student table

    public void setMarks(double marks) {
        this.marks = marks;
        if (marks > 80)
            this.grade = "A";
        else if ((marks <= 80) && (marks >= 70))
            this.grade = "B";
        else if ((marks <= 70) && (marks >= 60))
            this.grade = "C";
        else if ((marks <= 60) && (marks >= 50))
            this.grade = "D";
        if (marks < 50)
            this.grade = "F";
    }

    public double getMarks() {
        return marks;
    }

    public String getGrade() {
        return grade;
    }

    //Below constructor is used to show grades of any student is search student method
    public Course(String courseName, double marks, String grade) {
        this.courseName = courseName;
        this.marks = marks;
        this.grade = grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public Faculty getTeacher() {
        return teacher;
    }

    public void setTeacher(Faculty teacher) {
        this.teacher = teacher;
    }

    public Grades getGrades() {
        return grades;
    }

    public void setGrades(Grades grades) {
        this.grades = grades;
    }

    //Getters and Setters
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }


    //Constructor
    Course(int courseId,String courseName){
        this.courseId = courseId;
        this.setCourseName(courseName);
        this.grades = new Grades();
    }

    public void changeCourseInfo() { //change information related to course
        System.out.println("What do you want to change : ");
        System.out.println("1- Course Name");
        System.out.println("2- Course Title ");
        System.out.println("3- Course marks");
        System.out.print("Choice : ");
        int choice = sc.nextInt();
        System.out.println();
        switch(choice){
            case 1:
                sc.nextLine();
                System.out.print("Enter new course name : ");
                setCourseName(sc.nextLine());
                break;
            case 2:
                System.out.print("Enter new course id : ");
                setCourseId(sc.nextInt());
                break;
            case 3:
                System.out.print("Enter new marks :");
                grades.setCourseGrades(sc.nextDouble());
                break;
            default:
                System.out.println("Wrong option");
        }
    }

    public Course() {
    }
}


