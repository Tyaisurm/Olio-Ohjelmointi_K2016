/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author m7942
 */
public class Mainclass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int valinta = 1;
        Bank bank = new Bank();

        while (valinta != 0) {
            System.out.println("\n*** PANKKIJÄRJESTELMÄ ***");
            System.out.println("1) Lisää tavallinen tili");
            System.out.println("2) Lisää luotollinen tili");
            System.out.println("3) Tallenna tilille rahaa");
            System.out.println("4) Nosta tililtä");
            System.out.println("5) Poista tili");
            System.out.println("6) Tulosta tili");
            System.out.println("7) Tulosta kaikki tilit");
            System.out.println("0) Lopeta");
            System.out.print("Valintasi: ");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                valinta = Integer.parseInt(br.readLine());
                switch (valinta) {
                    case 1:
                        bank.addNormalA();
                        break;
                    case 2:
                        bank.addCreditA();
                        break;
                    case 3:
                        bank.addMoney();
                        break;
                    case 4:
                        bank.getMoney();
                        break;
                    case 5:
                        bank.removeA();
                        break;
                    case 6:
                        bank.printOneA();
                        break;
                    case 7:
                        bank.printAllA();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Valinta ei kelpaa.");
                }
            } catch (IOException ex) {
                System.out.println("Virheellinen syöte");
            } catch (NumberFormatException ec) {
                System.out.println("Virheellinen syöte");
            }

        }
    }
}
