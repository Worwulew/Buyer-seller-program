package org.example;

public class BootProdukt extends Produkt{
    private double size;

    public BootProdukt(String title, double price, int quantity, double size) {
        super(title, price, quantity);
        this.size = size;
    }
}
