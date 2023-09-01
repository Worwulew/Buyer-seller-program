package org.example;

import java.util.Date;
import java.util.Map;
import java.util.Set;

public class Deal {
    private Date date;
    private Party buyer;
    private Party seller;
    private int quantity;
    private Map<Produkt, Integer> produkts;
    private Set<Map.Entry<Produkt, Integer>> entrySet;

    public Deal(Party buyer, Party seller, Map<Produkt, Integer> produkts) {
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

    public int getQuantity() {
        return quantity;
    }

    public double getSum() {
        double sum = 0;
        for (Map.Entry<Produkt, Integer> entry : produkts.entrySet()) {
            sum += entry.getKey().getCost(entry.getValue());
        }

        return sum;
    }

    public String getProdukts() {
        String productNames = "";
        for (Map.Entry<Produkt, Integer> pr : produkts.entrySet()) {
            productNames += pr.getKey().getTitle() + " in quantity of "
                    + pr.getValue() + " at a price of " + pr.getKey().getPrice() + ", ";
        }

        return productNames;
    }
}
