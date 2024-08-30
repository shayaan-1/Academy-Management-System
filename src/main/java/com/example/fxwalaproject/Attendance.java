package com.example.fxwalaproject;

import java.text.DecimalFormat;

public class Attendance {
    //Attributes
    private int presents;
    private int absents;
    private double percentage;
    private String attendanceInPercent;

    public String getAttendanceInPercent() {
        return attendanceInPercent;
    }

    public void setAttendanceInPercent(String attendanceInPercent) {
        this.attendanceInPercent = attendanceInPercent;
    }

    //Getters and Setters
    public int getPresents() {
        return presents;
    }

    public void setPresents(int presents) {
        this.presents = presents;
    }

    public int getAbsents() {
        return absents;
    }

    public void setAbsents(int absents) {
        this.absents = absents;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    //Calculating percentage
    public double calculatePercentage(){
        if (presents+absents == 0){
            percentage = 0;
        } else {
            percentage = (double) (100 * presents / (presents + absents));
        }
        percentage = Math.round(percentage * 100.0) / 100.0;

        return percentage;

    }

    //A Constructor
    Attendance(int present, int absent){
        this.setPresents(present);
        this.setAbsents(absent);
    }

    Attendance(){

    }
}
