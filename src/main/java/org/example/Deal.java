package org.example;

import java.util.Date;

public class Deal {
    private Date date;
    private Party buyer;
    private Party seller;
    private Produkt[] produkts;

    public Deal(Party buyer, Party seller, Produkt[] produkts) {
        this.buyer = buyer;
        this.seller = seller;
        this.produkts = produkts;
        date = new Date();
    }

    public Date getDate() {
        return date;
    }

    public Party getBuyer() {
        return buyer;
    }

    public Party getSeller() {
        return seller;
    }

    public double getSum() {
        double sum = 0;
        for (Produkt produkt : produkts) {
            sum += produkt.getCost();
        }
        return sum;
    }

    public String getProdukts() {
        String productNames = "";
        for (Produkt pr : produkts) {
            productNames += pr.getTitle() + " in quantity of "
                    + pr.getQuantity() + " at a price of " + pr.getPrice() + ", ";
        }

        return productNames;
    }
}
