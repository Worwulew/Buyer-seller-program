package org.example;

import java.util.*;

public class Programm {
    private Collection<Deal> deals = new LinkedList<>();
    public static int tail = 0;

    public void output() {
        for (Deal d : deals) {
            if (d == null) {
                break;
            } else {
                System.out.println("Date: " + d.getDate());
                System.out.println("Buyer \"" + d.getBuyer().getName()
                        + "\" bought from seller \"" + d.getSeller().getName() + "\" such items as: "
                        + d.getProdukts() + "with total sum of " + d.getSum() + " EU.");
            }
        }
    }

    public void input() {
        if (tail != 10) {
            deals.add(inputDeal());
            tail++;
        } else {
            System.out.println("Not enough place");
        }
    }

    public Deal inputDeal() {
        Party buyer = inputParty("buyer");
        Party seller = inputParty("seller");
        Map<Produkt, Integer> produkts = new HashMap<>();
        String answer;
        do {
            System.out.println("Enter \"yes\" if you want to list product's characteristics or enter \"no\" if you don't: ");
            answer = keyword();
            if (answer.equals("yes")) {
                produkts.put(inputProdukt(), keywordInt());
            }
        } while (answer.equals("yes"));

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

        System.out.println("Enter \"1\" for photo product or enter \"2\" for boot product: ");
        int type = Integer.parseInt(keyword());

        if (1 == type) {
            System.out.println("Enter megaPx: ");
            double megaPx = Double.parseDouble(keyword());

            System.out.println("Enter \"1\" for digital or enter \"2\" for non-digital: ");
            boolean isDigital = keyword("boolean");

            return new FotoProdukt(title, price, megaPx, isDigital);
        } else {
            System.out.println("Enter size: ");
            double size = Double.parseDouble(keyword());

            return new BootProdukt(title, price, size);
        }
    }

    public String keyword() {
        Scanner sc = new Scanner(System.in);

        return sc.nextLine();
    }

    public Integer keywordInt() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter quantity: ");

        return Integer.parseInt(sc.nextLine());
    }

    public boolean keyword(String reason) {
        Scanner sc = new Scanner(System.in);
        boolean res;
        if (sc.nextInt() == 1) {
            return res = true;
        } else {
            return res = false;
        }
    }
}
