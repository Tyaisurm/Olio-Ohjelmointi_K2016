/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Origins;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author m7942
 */
public class Bank_0 {

    private ArrayList<Account_0> accounts = new ArrayList();
    String syote_1;
    int syote_2, syote_3;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
    public Bank_0() {
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
            if (syote_1.equals(accounts.get(a).accountName)) {
                accounts.get(a).money += syote_2;
                loop = 1;
                break;
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
            if (syote_1.equals(accounts.get(a).accountName)) {
                if(accounts.get(a).accountType.equals("normal")){
                if (accounts.get(a).money - syote_2 >= 0) {
                    accounts.get(a).money -= syote_2;
                } else {
                    System.out.println("Rahaa ei ole tilillä tarpeeksi!");
                }
                loop = 1;
                break;
            }
                else{
                    if(accounts.get(a).credit+accounts.get(a).money >= 0){
                        accounts.get(a).money -= syote_2;
                    }
                    else{
                        System.out.println("Tilillä ei ole tarpeeksi luottoa!");
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
            if (syote_1.equals(accounts.get(a).accountName)) {
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

    public void printOneA() throws IOException {
        System.out.print("Syötä tulostettava tilinumero: ");
        syote_1 = br.readLine();
        int loop = 0;
        for (int a = 0; a < accounts.size(); a++) {
            if (syote_1.equals(accounts.get(a).accountName)) {
                if (accounts.get(a).accountType.equals("credit")) {
                    System.out.print("Tilinumero: " + accounts.get(a).accountName);
                    System.out.print(" Tilillä rahaa: " + accounts.get(a).money);
                    System.out.println(" Luottoraja: " + accounts.get(a).credit);
                    loop = 1;
                    break;
                } else {
                    System.out.print("Tilinumero: " + accounts.get(a).accountName);
                    System.out.println(" Tilillä rahaa: " + accounts.get(a).money);
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
                if (accounts.get(a).accountType.equals("credit")) {
                    System.out.print("Tilinumero: " + accounts.get(a).accountName);
                    System.out.print(" Tilillä rahaa: " + accounts.get(a).money);
                    System.out.println(" Luottoraja: " + accounts.get(a).credit);
                } else {
                    System.out.print("Tilinumero: " + accounts.get(a).accountName);
                    System.out.println(" Tilillä rahaa: " + accounts.get(a).money);
                }
            
        }
    }
}
