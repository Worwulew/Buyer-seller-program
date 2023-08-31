package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Programm {
    private Deal[] deals = new Deal[10];
    public static int tail = 0;

    public void output() {
        for (Deal d : deals) {
            if (d == null) {
                break;
            } else {
                System.out.println("Date: " + d.getDate());
                System.out.println("Buyer " + d.getBuyer().getName()
                        + " bought from seller " + d.getSeller().getName() + " such items as: "
                        + d.getProdukts() + "with total sum of " + d.getSum() + " EU.");
            }
        }
    }

    public void input() {
        if (tail != 10) {
            Deal d = inputDeal();
            deals[tail] = d;
            tail++;
        } else {
            System.out.println("Not enough place");
        }
    }

    public Deal inputDeal() {
        Party buyer = inputParty("buyer");
        Party seller = inputParty("seller");
        Produkt[] produkts = { inputProdukt(), inputProdukt() };

        return new Deal(buyer, seller, produkts);
    }

    public Party inputParty(String reason) {
        if (reason == "buyer") {
            System.out.println("Enter the buyer's name: ");
            String name = keyword();
            return new Party(name);
        } else {
            System.out.println("Enter the seller's name: ");
            String name = keyword();
            return new Party(name);
        }
    }

    public Produkt inputProdukt() {
        System.out.println("Enter product's title: ");
        String title = keyword();

        System.out.println("Enter product's price: ");
        double price = Double.parseDouble(keyword());

        System.out.println("Enter product's quantity: ");
        int quantity = Integer.parseInt(keyword());

        System.out.println("Enter 1 for foto product or enter 2 for boot product: ");
        int type = Integer.parseInt(keyword());

        if (1 == type) {
            System.out.println("Enter megaPx: ");
            double megaPx = Double.parseDouble(keyword());

            System.out.println("Enter 1 for digital or enter 2 for not digital: ");
            boolean isDigital = keyword("boolean");

            return new FotoProdukt(title, price, quantity, megaPx, isDigital);
        } else {
            System.out.println("Enter size: ");
            double size = Double.parseDouble(keyword());

            return new BootProdukt(title, price, quantity, size);
        }
    }

    public String keyword() {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();

        return string;
    }

    public boolean keyword(String reason) {
        Scanner sc = new Scanner(System.in);
        boolean res;
        int result = sc.nextInt();
        if (result == 1) {
            return res = true;
        } else {
            return res = false;
        }
    }
}
