package org.example;

public class FotoProdukt extends Produkt{
    private double megaPx;
    private boolean  isDigital;

    public FotoProdukt(String title, double price, int quantity, double megaPx, boolean isDigital) {
        super(title, price, quantity);
        this.megaPx = megaPx;
        this.isDigital = isDigital;
    }

    @Override
    public int calcDiscount() {
        int def = super.calcDiscount();
        if (!isDigital) {
            def += 20;
        }

        return def;
    }
}
