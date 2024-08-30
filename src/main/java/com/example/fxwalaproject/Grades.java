package com.example.fxwalaproject;

import java.util.Scanner;
public class Grades {
    Scanner sc = new Scanner(System.in);
    private double grades;

    public Grades() {
        this.grades = 0.0;
    }

    public double getCourseGrades() {
        return grades;
    }

    public void setCourseGrades(double grades) {
        while(grades<0.0 || grades>100.0) {
            System.out.println("Grades should be between 0 and 100");
            System.out.print("Re-enter marks : ");
            grades = sc.nextDouble();
        }
        this.grades = grades;
    }

    public String calculateGrades() {

        if (grades > 80)
            return "A";
        else if ((grades <= 80) && (grades >= 70))
            return "B";
        else if ((grades <= 70) && (grades >= 60))
            return "C";
        else if ((grades <= 60) && (grades >= 50))
            return "D";
        if (grades < 50)
            return "F";
        return null;
    }

    public void remarks ()
    {
        boolean ispassed = grades >= 50;
        if (ispassed)
            System.out.println("Congratulations! You passed.");
        else
            System.out.println("Too bad! You failed.");
    }

}

