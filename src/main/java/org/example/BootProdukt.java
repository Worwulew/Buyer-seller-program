package org.example;

public class BootProdukt extends Produkt{
    private double size;

    public BootProdukt(String title, double price, double size) {
        super(title, price);
        this.size = size;
    }

    @Override
    public String info() {
        return super.info() + "size: " + size + "\n";
    }
}
