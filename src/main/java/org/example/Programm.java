package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

public class Programm {
    private Collection<Deal> deals = new LinkedList<>();
    private List<Produkt> createdProds = new LinkedList<>();
    private static Scanner sc = new Scanner(System.in);
    public static int tail = 0;

    public void output() {
        for (Deal d : deals) {
            if (d == null) {
                break;
            } else {
                String outputMessage = "Date: " + new SimpleDateFormat("dd-MM-yyyy").format(d.getDate())
                        + "\n" + "Buyer \"" + d.getBuyer().getName()
                        + "\" bought from seller \"" + d.getSeller().getName() + "\" such items as:"
                        + d.getProdukts() + ", with total sum of " + d.getSum() + " EU." + "\n";
                System.out.println(outputMessage);
                textReport(outputMessage);
            }
        }
    }

    public void input() {
        deals.add(inputDeal());
        tail++;
    }

    public Deal inputDeal() {
        Party buyer = inputParty("buyer");
        Party seller = inputParty("seller");
        Map<Produkt, Integer> produkts = new HashMap<>();
        int answer;

        do {
            System.out.println("Enter:\n\"1\" - to list product's characteristics\n\"2\" - to select \n\"3\" - to quit: ");
            answer = keywordInt();
            if (answer == 1) {
                Produkt p = inputProdukt();
                produkts.put(p, keywordQuantity());
                createdProds.add(p);
            } else if (answer == 2 && createdProds.size() > 0) {
                for (int i = 0; i < createdProds.size(); i++) {
                    System.out.print(i + 1 + ": " + createdProds.get(i).info() + "\n");
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

            return new Party(keyword());
        } else {
            System.out.println("Enter the seller's name: ");

            return new Party(keyword());
        }
    }

    public Produkt inputProdukt() {
        System.out.println("Enter \"1\" for photo product or enter \"2\" for boot product: ");
        int type = keywordInt();

        System.out.println("Enter product's title: ");
        String title = keyword();

        System.out.println("Enter product's price: ");
        double price = keywordDouble();

        if (1 == type) {
            System.out.println("Enter megaPx: ");
            double megaPx = keywordDouble();

            System.out.println("Enter \"1\" for digital or enter \"2\" for non-digital: ");
            boolean isDigital = keyword("boolean");

            return new FotoProdukt(title, price, megaPx, isDigital);
        } else {
            System.out.println("Enter size: ");
            double size = keywordDouble();

            return new BootProdukt(title, price, size);
        }
    }

    public String keyword() {
        String output = scanner();
        if (!isNumeric(output) && !output.equals("")) {
            return output;
        }

        System.out.println("Try again, please (no numbers)");
        return keyword();
    }

    public Integer keywordInt() {
        int output;
        do
        {
            try {
                output = Integer.parseInt(scanner());
                break;
            }
            catch (Exception e)
            {
                System.out.println("Try again, please (numbers only)");
            }
        } while (true);

        return output;
    }

    public double keywordDouble() {
        double output;
        do
        {
            try {
                output = Double.parseDouble(scanner());
                break;
            }
            catch (Exception e)
            {
                System.out.println("Try again, please (numbers and decimal only)");
            }
        } while (true);

        return output;
    }

    public Integer keywordQuantity() {
        System.out.println("Enter quantity: ");

        return keywordInt();
    }

    public boolean keyword(String reason) {
        boolean res;
        if (keywordInt() == 1) {
            return res = true;
        } else {
            return res = false;
        }
    }

    public boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }

        return true;
    }

    public String scanner() {
        return sc.nextLine();
    }

    public void textReport(String outputMessage) {
        PrintWriter pW = null;
        try {
            File list = new File("./output.txt");
            if (list.createNewFile()) {
                System.out.println("Report created");
            }
            pW = new PrintWriter(new FileWriter(list, true));
            pW.write(outputMessage);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                assert pW != null;
                pW.close();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
