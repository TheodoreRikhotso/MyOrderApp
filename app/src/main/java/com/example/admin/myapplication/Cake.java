package com.example.admin.myapplication;

/**
 * Created by Admin on 7/11/2017.
 */

public class Cake {

    private  int cake;
    private String description;
    private double price;
//    private  int remove;
    private int Quantity;
//    private int add;


    public Cake(int cake, String description, double price) {
        this.cake = cake;
        this.description = description;
        this.price = price;
        //this.remove = remove;


    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }



    public int getCake() {
        return cake;
    }

    public void setCake(int cake) {
        this.cake = cake;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }
}
