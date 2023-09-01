package org.example;

import java.util.*;

public class Programm {
    private Collection<Deal> deals = new LinkedList<>();
    private List<Produkt> createdProds = new LinkedList<>();
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
        int answer;
        do {
            System.out.println("Enter\n\"1\" - to list product's characteristics\n\"2\" - to select \n\"3\" - to quit: ");
            answer = keywordInt();
            if (answer == 1) {
                Produkt p = inputProdukt();
                produkts.put(p, keywordQuantity());
                createdProds.add(p);
            } else if (answer == 2) {
                for (int i = 0; i < createdProds.size(); i++) {
                    System.out.print(i + 1 + ": " + createdProds.get(i).info());
                }
                System.out.println("Enter the number to select: ");
                int choice = keywordInt();
                for (int i = 0; i < createdProds.size(); i++) {
                    if (i == choice - 1) {
                        produkts.put(createdProds.get(i), keywordQuantity());
                    }
                }
            }
        } while (answer == 1 || answer == 2);

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
        System.out.println("Enter \"1\" for photo product or enter \"2\" for boot product: ");
        int type = Integer.parseInt(keyword());

        System.out.println("Enter product's title: ");
        String title = keyword();

        System.out.println("Enter product's price: ");
        double price = Double.parseDouble(keyword());

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

        return scanner().nextLine();
    }

    public Integer keywordInt() {

        return Integer.parseInt(scanner().nextLine());
    }

    public Integer keywordQuantity() {
        System.out.println("Enter quantity: ");

        return Integer.parseInt(scanner().nextLine());
    }

    public boolean keyword(String reason) {
        boolean res;
        if (scanner().nextInt() == 1) {
            return res = true;
        } else {
            return res = false;
        }
    }

    public Scanner scanner() {
        return new Scanner(System.in);
    }
}
