package com.example.fxwalaproject;

import java.sql.SQLException;
import java.util.*;
public class Admin {
    DBConnection dbConnection = new DBConnection();
    Scanner sc = new Scanner(System.in);
    //Creating all possible classes in academy system
    Classes class9BioGroup = new Classes(9,2);
    Classes class9ComputerGroup = new Classes(9,1);
    Classes class10BioGroup = new Classes(10,2);
    Classes class10ComputerGroup = new Classes(10,1);
    Classes class11Engineering = new Classes(11,1);
    Classes class11Medical = new Classes(11,2);
    Classes class11Ics = new Classes(11,3);
    Classes class12Engineering = new Classes(12,1);
    Classes class12Medical = new Classes(12,2);
    Classes class12Ics = new Classes(12,3);
    private Faculty teacher;

    public Classes chooseClass(){ // Creating a function to choose and select class for add student method
        System.out.print("Enter your class : ");
        int choice = sc.nextInt();
        switch(choice){
            case 9:
                System.out.println("Choose elective : ");
                System.out.println("1- Computer Science");
                System.out.println("2- Biology");
                System.out.print("Your option : ");
                int option = sc.nextInt();
                if(option==1)
                    return class9ComputerGroup;
                else
                    return class9BioGroup;
            case 10:
                System.out.println("Choose elective : ");
                System.out.println("1- Computer Science");
                System.out.println("2- Biology");
                System.out.print("Your option : ");
                option = sc.nextInt();
                if(option==1)
                    return class10ComputerGroup;
                else
                    return class10BioGroup;
            case 11:
                System.out.println("Choose elective : ");
                System.out.println("1- Pre-Engineering");
                System.out.println("2- Pre-Medical");
                System.out.println("3- ICS");
                System.out.print("Your option : ");
                option = sc.nextInt();
                if(option==1)
                    return class11Engineering;
                if(option==2)
                    return class11Medical;
                if(option==3)
                    return class11Ics;
            case 12:
                System.out.println("Choose elective : ");
                System.out.println("1- Pre-Engineering");
                System.out.println("2- Pre-Medical");
                System.out.println("3- ICS");
                System.out.print("Your option : ");
                option = sc.nextInt();
                if(option==1)
                    return class12Engineering;
                if(option==2)
                    return class12Medical;
                if(option==3)
                    return class12Ics;
        }
        return null;
    }

}


