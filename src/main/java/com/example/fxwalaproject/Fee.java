package com.example.fxwalaproject;

public class Fee {
    private int amount;
    private boolean status;

    //Getters and Setters
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Fee(int amount){
        this.setAmount(amount);
    }

    public Fee(){

    }

    //DisplayStatus method
    public void displayStatus(){
        if(status){
            System.out.println("Fee is Paid");
        } else {
            System.out.println("Fee is not Paid");
        }
    }
}

