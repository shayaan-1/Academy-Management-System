package com.example.fxwalaproject;

public class Person {
    private String name;
    private String contact;

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    public Person() {
    }


    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", contact='" + contact;}
}

