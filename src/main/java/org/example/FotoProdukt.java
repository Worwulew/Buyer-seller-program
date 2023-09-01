package org.example;

public class FotoProdukt extends Produkt{
    private double megaPx;
    private boolean  isDigital;

    public FotoProdukt(String title, double price, double megaPx, boolean isDigital) {
        super(title, price);
        this.megaPx = megaPx;
        this.isDigital = isDigital;
    }

    @Override
    public int calcDiscount(int quantity) {
        int def = super.calcDiscount(quantity);
        if (!isDigital) {
            def += 20;
        }

        return def;
    }

    @Override
    public String info() {
        return super.info() + "megaPx: " + megaPx + ", digital: " + isDigital + "\n";
    }
}
