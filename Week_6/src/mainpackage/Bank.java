/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author m7942
 */
public class Bank {

    private ArrayList accounts = new ArrayList();
    String syote_1;
    int syote_2, syote_3;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public Bank() {
        //
    }

    public void addCreditA() throws IOException {
        System.out.print("Syötä tilinumero: ");
        syote_1 = br.readLine();
        System.out.print("Syötä rahamäärä: ");
        syote_2 = Integer.parseInt(br.readLine());
        System.out.print("Syötä luottoraja: ");
        syote_3 = Integer.parseInt(br.readLine());
        accounts.add(new Credit(syote_1, syote_2, syote_3));
    }

    public void addNormalA() throws IOException {
        System.out.print("Syötä tilinumero: ");
        syote_1 = br.readLine();
        System.out.print("Syötä rahamäärä: ");
        syote_2 = Integer.parseInt(br.readLine());
        accounts.add(new Normal(syote_1, syote_2));

    }

    public void addMoney() throws IOException {
        System.out.print("Syötä tilinumero: ");
        syote_1 = br.readLine();
        System.out.print("Syötä rahamäärä: ");
        syote_2 = Integer.parseInt(br.readLine());

        int loop = 0;
        for (int a = 0; a < accounts.size(); a++) {
            if (accounts.get(a) instanceof Credit) {
                Credit tili;
                tili = (Credit) accounts.get(a);
                if (syote_1.equals(tili.accountName)) {
                    tili.money += syote_2;
                    loop = 1;
                    break;
                }
            } else {
                Normal tili = (Normal) accounts.get(a);

                if (syote_1.equals(tili.accountName)) {
                    tili.money += syote_2;
                    loop = 1;
                    break;
                }
            }
        }
        if (loop == 0) {
            System.out.println("Tiliä ei ole olemassa.");
        }
    }

    public void getMoney() throws IOException {
        System.out.print("Syötä tilinumero: ");
        syote_1 = br.readLine();
        System.out.print("Syötä rahamäärä: ");
        syote_2 = Integer.parseInt(br.readLine());

        int loop = 0;
        for (int a = 0; a < accounts.size(); a++) {
            if (accounts.get(a) instanceof Credit) {
                Credit tili = (Credit) accounts.get(a);
                if (tili.credit + tili.money >= 0) {
                    tili.money -= syote_2;
                } else {
                    System.out.println("Tilillä ei ole tarpeeksi luottoa!");
                }
                loop = 1;
                break;
            } else {
                Normal tili = (Normal) accounts.get(a);

                if (syote_1.equals(tili.accountName)) {
                    if (tili.money - syote_2 >= 0) {
                        tili.money -= syote_2;
                    } else {
                        System.out.println("Rahaa ei ole tilillä tarpeeksi!");
                    }
                    loop = 1;
                    break;
                }
            }
        }
        if (loop == 0) {
            System.out.println("Tiliä ei ole olemassa.");
        }
    }

    public void removeA() throws IOException {
        System.out.print("Syötä poistettava tilinumero: ");
        syote_1 = br.readLine();
        int loop = 0;
        for (int a = 0; a < accounts.size(); a++) {
            if (accounts.get(a) instanceof Credit) {
                Credit tili = (Credit) accounts.get(a);
                if (syote_1.equals(tili.accountName)) {
                    accounts.remove(a);
                    loop = 1;
                    System.out.println("Tili poistettu.");
                    break;
                }
            } else {
                Normal tili = (Normal) accounts.get(a);

                if (syote_1.equals(tili.accountName)) {
                    accounts.remove(a);
                    loop = 1;
                    System.out.println("Tili poistettu.");
                    break;
                }

            }
            if (loop == 0) {
                System.out.println("Tiliä ei ole olemassa.");
            }
        }
    }

    public void printOneA() throws IOException {
        System.out.print("Syötä tulostettava tilinumero: ");
        syote_1 = br.readLine();
        int loop = 0;
        for (int a = 0; a < accounts.size(); a++) {
            if (accounts.get(a) instanceof Credit) {
                Credit tili = (Credit) accounts.get(a);
                if (syote_1.equals(tili.accountName)) {
                    System.out.print("Tilinumero: " + tili.accountName);
                    System.out.print(" Tilillä rahaa: " + tili.money);
                    System.out.println(" Luottoraja: " + tili.credit);
                    loop = 1;
                    break;
                }
            } else {
                Normal tili = (Normal) accounts.get(a);
                if (syote_1.equals(tili.accountName)) {
                    System.out.print("Tilinumero: " + tili.accountName);
                    System.out.println(" Tilillä rahaa: " + tili.money);
                    loop = 1;
                    break;
                }

            }
            if (loop == 0) {
                System.out.println("Tiliä ei ole olemassa.");
            }
        }
    }

    public void printAllA() {
        System.out.println("Kaikki tilit:");
        for (int a = 0; a < accounts.size(); a++) {
            if (accounts.get(a) instanceof Credit) {
                Credit tili = (Credit) accounts.get(a);
                System.out.print("Tilinumero: " + tili.accountName);
                System.out.print(" Tilillä rahaa: " + tili.money);
                System.out.println(" Luottoraja: " + tili.credit);
            } else {
                Normal tili = (Normal) accounts.get(a);
                System.out.print("Tilinumero: " + tili.accountName);
                System.out.println(" Tilillä rahaa: " + tili.money);
            }
        }

    }
}
