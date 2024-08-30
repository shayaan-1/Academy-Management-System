package com.example.fxwalaproject;

import java.sql.SQLException;
import java.util.*;
public class Student extends Person {
    Scanner sc = new Scanner(System.in);
    float averageGrade = 0f;
    private int rollNo;

    private Classes classes;
    private Attendance attendance = new Attendance();
    private Course[] courses;
    private Grades grades;
    private Fee fee;
    private int classNumber; // temporary variable created to show data in table view
    private int feeAmount; // temporary variable created to show data in table view
    private String attendancePercentage; // temporary variable created to show data in table view
    private boolean feeStatus; // temporary variable created to show data in table view
    private String section; // temporary variable created to show data in table view

    public int getClassNumber() {
        return classNumber;
    }

    public int getFeeAmount() {
        return feeAmount;
    }

    public String getAttendancePercentage() {
        return attendancePercentage;
    }

    public boolean isFeeStatus() {
        return feeStatus;
    }

    public String getSection() {
        return section;
    }

    //Below constructor is only to show data in table view of view students
    public Student(int rollNo, String name, String contact, int classNum, String section, int fee, boolean feeStatus, String attendance){
        super(name,contact);
        this.rollNo = rollNo;
        this.classNumber = classNum;
        this.section = section;
        this.feeAmount = fee;
        this.feeStatus = feeStatus;
        this.attendancePercentage = attendance;
    }
    public Fee getFee() {
        return fee;
    }

    public void setFee(Fee fee) {
        this.fee = fee;
    }

    public Grades getGrades() {
        return grades;
    }

    public void setGrades(Grades grades) {
        this.grades = grades;
    }

    public Course[] getCourses() {
        return courses;
    }

    public void setCourses(Course[] courses) {
        this.courses = courses;
    }

    public Attendance getAttendance() {
        return attendance;
    }

    public void setAttendance(Attendance attendance) {
        this.attendance = attendance;
    }

    public Student(Classes classes) {
         //Assign class, courses and fee to student.
        this.classes = classes;
        this.courses = classes.getCourses();
        this.fee = classes.getFee();
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public void editCourses() {  //Edit Student Courses
        System.out.print("Enter course id of course you want to edit : ");
        int courseID = sc.nextInt();
        System.out.println();
        for (int i = 0; i < getCourses().length; i++) {
            if (courseID == getCourses()[i].getCourseId()) {
                getCourses()[i].changeCourseInfo();
            }
        }
    }

    public void displayGrades() { //display courses and their grades of a student
        System.out.println();
        System.out.println("Following are grades of the Student: ");
        System.out.println();

        for (int i = 0; i < getCourses().length; i++) {
            System.out.println("Marks in " + getCourses()[i].getCourseName() + " : " + getCourses()[i].getGrades().getCourseGrades());
        }
        System.out.println();
        System.out.println("Average marks : " + averageGrade);
    }

//    public void editGrades(int studentID) { //set grades of all courses
//        for (int i = 0; i < getCourses().length; i++) {
//            System.out.print("Enter marks of " + getCourses()[i].getCourseName() + " : ");
//            grades = new Grades();
//            grades.setCourseGrades(sc.nextDouble());
//            getCourses()[i].setGrades(grades);
//            DBConnection dbConnection = new DBConnection();
//            dbConnection.establishConnection();
//            try {
//                dbConnection.editGrades(grades.getCourseGrades(), studentID, grades.calculateGrades(), getCourses()[i].getCourseId());
//            }catch(SQLException e){
//                System.out.println(e.getMessage());
//            }
//        }
//        sc.nextLine();
//    }

    public void displayCourseInformation() {
        System.out.print("Enter course id of the course you want to view information of : ");
        int courseID = sc.nextInt();
        for (int i = 0; i < courses.length; i++) {
            if (courseID == courses[i].getCourseId()) {
                System.out.println("Course Title : " + courses[i].getCourseId());
                System.out.println("Course Name : " + courses[i].getCourseName());
                System.out.println("Course marks : " + courses[i].getGrades().getCourseGrades());
                courses[i].getGrades().calculateGrades();
                courses[i].getGrades().remarks();
            }
        }
    }

    public void setAttendance() {
        System.out.print("Enter Number of days student was present for : ");
        int presents = sc.nextInt();
        System.out.print("Enter Number of days student was absent for : ");
        int absents = sc.nextInt();
        attendance = new Attendance(presents, absents);
        attendance.calculatePercentage();
    }

    public void displayAttendance() { //display student's attendance
        System.out.println("Number of presents : " + attendance.getPresents());
        System.out.println("NUmber of absents : " + attendance.getAbsents());
        System.out.println("Attendance percentage : " + attendance.getPercentage());
    }

    public void editAttendance() {

        System.out.print("Enter new number of presents : ");
        attendance.setPresents(sc.nextInt());
        System.out.print("Enter new number of absents : ");
        attendance.setAbsents(sc.nextInt());
        attendance.calculatePercentage();
    }


    public void displayFeeStatus() {
        System.out.println("Fee amount : " + fee.getAmount());
        fee.displayStatus();
    }

    public void setFeeStatus(boolean b) {
//        System.out.println("What is the current fee status of student : ");
//        System.out.println("1- Paid");
//        System.out.println("2- Unpaid");
//        System.out.print("Choice : ");
//        int choice = sc.nextInt();
//        if (choice == 1)
            fee.setStatus(b);
//        else
//            fee.setStatus(false);
    }

    public void addPersonalDetails(String name,int rollNo,String contact) {
//        System.out.print("Enter name of Student : ");
        this.setName(name);
//        System.out.print("Enter roll number of student : ");
        this.setRollNo(rollNo);
//        sc.nextLine();
//        System.out.print("Enter Contact Number of student : ");
        this.setContact(contact);
    }

    public String editStudentDetails(){
        System.out.println("What do you want to edit: ");
        System.out.println("1- Name");
        System.out.println("3- Contact Number");
        System.out.print("Choice: ");
        int choice = sc.nextInt();
        String changeableAttribute = null;
        switch(choice){
            case 1:
                sc.nextLine();
                System.out.print("Enter new name of Student : ");
                this.setName(sc.nextLine());
                changeableAttribute = "name";
                break;
            case 2:
                sc.nextLine();
                System.out.print("Enter new contact of student : ");
                this.setContact(sc.nextLine());
                changeableAttribute = "contact";
                break;
            default:
                System.out.println("Wrong option");
        }
        return changeableAttribute;
    }

    @Override
    public String toString() {
        return super.toString() +
                " " +
                "rollNo=" + rollNo
                ;
    }
    //Below constructor is created for edit student purpose


    public Student(String name, String contact, String attendancePercentage, boolean feeStatus) {
        super(name, contact);
        this.attendancePercentage = attendancePercentage;
        this.feeStatus = feeStatus;
    }
}