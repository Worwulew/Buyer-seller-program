package org.example;

public abstract class Produkt {
    private static final int DEFAULTDISCOUNT = 10;
    private String title;
    private double price;

    public double getCost(int quantity) {
        double realCost = price * quantity;

        if (calcDiscount(quantity) > 0) {
            return realCost - realCost * calcDiscount(quantity) / 100;
        } else {
            return realCost;
        }
    }

    public int calcDiscount(int quantity) {
        if (quantity > 10) {
            return DEFAULTDISCOUNT;
        }

        return 0;
    }

    public Produkt(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String info() {
        return " Product: " + title +
                ", price: " + price +
                " EU, ";
    }
}
