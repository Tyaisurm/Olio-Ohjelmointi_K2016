/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bottleDispenser;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author m7942
 */
public class BottleDispenser {

    private static BottleDispenser instance = null;

    private double money;
    //Bottle bottle = new Bottle();
    private final ArrayList<Bottle> bottleList = new ArrayList();
    private int menu = 1;
    private String input;

    //kututaan aluksi, yhteensä vain kerran
    private BottleDispenser() {
        money = 0;
        bottleList.add(new Bottle("Pepsi Max", 0.5, 1.8));
        bottleList.add(new Bottle("Pepsi Max", 1.5, 2.2));
        bottleList.add(new Bottle("Coca-Cola Zero", 0.5, 2.0));
        bottleList.add(new Bottle("Coca-Cola Zero", 1.5, 2.5));
        bottleList.add(new Bottle("Fanta Zero", 0.5, 1.95));
        bottleList.add(new Bottle("Fanta Zero", 0.5, 1.95));
    }

    public static BottleDispenser getInstance() {
        if (instance == null) {
            instance = new BottleDispenser();
        }
        return instance;
    }

    public void addMoney(double moneyIn) {
        money += moneyIn;
        System.out.println("Klink! Lisää rahaa laitteeseen!");

    }

    public Bottle buyBottle(String nimi, double koko) {
        Bottle pullo = null;
        if (bottleList.isEmpty()) {
            System.out.println("Pulloja ei ole jäljellä.");
        } else {
            for (int a = 0; bottleList.size() > a; a++) {
                if (nimi.equals(bottleList.get(a).toString())) {
                    if (koko == bottleList.get(a).getSize()) {
                        if ((money - bottleList.get(a).getPrice()) >= 0) {
                            money -= bottleList.get(a).getPrice();
                            System.out.println("KACHUNK! " + bottleList.get(a).getName() + " tipahti masiinasta!");
                            pullo = bottleList.get(a);
                            bottleList.remove(a);
                            return pullo;
                        } else {
                            //
                        }
                    } else {
                        System.out.println("Pullot ovat loppu!");
                    }
                }
            }
        }
        return pullo;
    }

    public String listBottles(String nimi, Double koko) {
        String palaute = "";
        if (bottleList.isEmpty()) {
            palaute = "Pulloja ei ole jäljellä.";
        } else {
            for (int a = 0; a < bottleList.size(); a++) {
                if (bottleList.get(a).getName().equals(nimi) && bottleList.get(a).getSize() == koko) {
                    palaute += ((a + 1) + ". Nimi: " + bottleList.get(a).getName() + "\n");
                    palaute += ("\tKoko: " + bottleList.get(a).getSize() + "\t" + "Hinta: " + bottleList.get(a).getPrice() + "\n");
                }

            }
        }
        if (palaute.equals("")) {
            palaute = "Sopivia pulloja ei ole jäljellä!";
        }
        return palaute;
    }
    // public ArrayList getBottleList(){
    //   return bottleList;
    //}

    public double returnMoney() {
        Double temp = money;
        money = 0;
        System.out.println("Klink klink. Sinne menivät rahat!");
        return temp;
    }
}
