package org.example;

public class Produkt {
    private static final int DEFAULTDISCOUNT = 10;
    private String title;
    private double price;
    private int quantity;

    public double getCost() {
        double realCost = price * quantity;

        if (calcDiscount() > 0) {
            return realCost - realCost * calcDiscount() / 100;
        } else {
            return realCost;
        }
    }

    public int calcDiscount() {
        if (quantity > 10) {
            return DEFAULTDISCOUNT;
        }

        return 0;
    }

    public Produkt(String title, double price, int quantity) {
        this.title = title;
        this.price = price;
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
