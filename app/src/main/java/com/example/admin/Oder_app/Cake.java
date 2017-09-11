package com.example.admin.Oder_app;

/**
 * Created by Admin on 7/11/2017.
 */

public class Cake {

    private  int cake;
    private  String type;
    private String description;
    private double price;

    private int Quantity;
//    private int add;


    public String getType() {
        return type;
    }

    public Cake(int cake, String type, String description, double price) {
        this.cake = cake;
        this.type = type;
        this.description = description;
        this.price = price;

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
