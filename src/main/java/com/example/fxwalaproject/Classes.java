package com.example.fxwalaproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Classes {
    public Classes(int classNumber) {
        this.classNumber = classNumber;
    }

    int classStrength;
    private int classNumber;
    private String section;

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public int getClassNumber() {
        return classNumber;
    }

    Scanner sc = new Scanner(System.in);
    private Course [] courses;

    public Course[] getCourses() {
        return courses;
    }

    public void setCourses(Course[] courses) {
        this.courses = courses;
    }

    private Fee fee;
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Faculty> teacher = new ArrayList<>();

    public ArrayList<Faculty> getTeacher() {
        return teacher;
    }

    public void setTeacher(ArrayList<Faculty> teacher) {
        this.teacher = teacher;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public Fee getFee() {
        return fee;
    }

    public void setFee(Fee fee) {
        this.fee = fee;
    }

    Classes(int classNumber, int elective){
        int opt;
        this.classNumber = classNumber;

        switch (classNumber) {
            case 9:
                fee = new Fee(6000);
                courses = new Course[8];

                if (elective == 1) {
                    setSection("Computer");
                    courses[0] = new Course(4,"Computer");
                } else if (elective == 2) {
                    setSection("Biology");
                    courses[0] = new Course(5,"Biology");
                }

                courses[1] = new Course(1,"English");
                courses[2] = new Course(2,"Urdu");
                courses[3] = new Course(7,"Islamiat");
                courses[4] = new Course(6,"Pak Studies");
                courses[5] = new Course(8,"Physics");
                courses[6] = new Course(9,"Chemistry");
                courses[7] = new Course(3,"Math");
                break;
            case 10:
                fee = new Fee(6000);
                courses = new Course[8];

                if (elective == 1) {
                    setSection("Computer");
                    courses[0] = new Course(13,"Computer");
                } else if (elective == 2) {
                    setSection("Biology");
                    courses[0] = new Course(14,"Biology");
                }

                courses[1] = new Course(10,"English");
                courses[2] = new Course(11,"Urdu");
                courses[3] = new Course(16,"Islamiat");
                courses[4] = new Course(15,"Pak Studies");
                courses[5] = new Course(17,"Physics");
                courses[6] = new Course(18,"Chemistry");
                courses[7] = new Course(12,"Math");
                break;
            case 11:
                fee = new Fee(8000);
                courses = new Course[6];

                if (elective == 1) {
                    setSection("Pre-Engineering");
                    courses[0] = new Course(20,"Math" );
                    courses[1] = new Course(19,"English");
                    courses[2] = new Course(24,"Urdu" );
                    courses[3] = new Course(21,"Islamiat");
                    courses[4] = new Course(23,"Physics");
                    courses[5] = new Course(22,"Chemistry");
                } else if (elective == 2) {
                    setSection("Pre-Medical");
                    courses[0] = new Course(25,"Biology" );
                    courses[1] = new Course(19,"English");
                    courses[2] = new Course(24,"Urdu" );
                    courses[3] = new Course(21,"Islamiat");
                    courses[4] = new Course(23,"Physics");
                    courses[5] = new Course(22,"Chemistry");
                } else if (elective == 3) {
                    setSection("ICS");
                    courses[0] = new Course(20,"Math" );
                    courses[1] = new Course(19,"English");
                    courses[2] = new Course(24,"Urdu" );
                    courses[3] = new Course(21,"Islamiat");
                    courses[4] = new Course(23,"Physics");
                    courses[5] = new Course(26,"Computer");
                }
                break;
            case 12 :
                fee = new Fee(8000);
                courses = new Course[6];

                if (elective == 1) {
                    setSection("Pre-Engineering");
                    courses[0] = new Course(28,"Math" );
                    courses[1] = new Course(27,"English");
                    courses[2] = new Course(32,"Urdu" );
                    courses[3] = new Course(29,"Pak Studies");
                    courses[4] = new Course(31,"Physics");
                    courses[5] = new Course(30,"Chemistry");
                } else if (elective == 2) {
                    setSection("Pre-Medical");
                    courses[0] = new Course(33,"Biology" );
                    courses[1] = new Course(27,"English");
                    courses[2] = new Course(32,"Urdu" );
                    courses[3] = new Course(29,"Pak Studies");
                    courses[4] = new Course(31,"Physics");
                    courses[5] = new Course(30,"Chemistry");
                } else if (elective == 3) {
                    setSection("ICS");
                    courses[0] = new Course(28,"Math" );
                    courses[1] = new Course(27,"English");
                    courses[2] = new Course(32,"Urdu" );
                    courses[3] = new Course(29,"Pak Studies");
                    courses[4] = new Course(31,"Physics");
                    courses[5] = new Course(34,"Computer");
                }
                break;
            default:
                System.out.println("Invalid option");

        }
    }
}




