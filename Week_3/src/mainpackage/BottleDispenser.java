/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mainpackage;

import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author m7942
 */
public class BottleDispenser {
    
    private double bottles;
    private double money;
    //Bottle bottle = new Bottle();
    ArrayList<Bottle> bottleList= new ArrayList();
    
    private int menu = 1;
    private int a = -1;
  
    private String input;

    //kututaan aluksi, yhteensä vain kerran
    public void PullonPalautin() {
        //bottles = 50;
        money = 0;
        
        //bottle.add();
        //for(int a = 1; a<7; a++){
         //   bottleList.add(new Bottle());
        //}
        
        bottleList.add(new Bottle("Pepsi Max", 0.5, 1.8));
        bottleList.add(new Bottle("Pepsi Max",1.5, 2.2));
        bottleList.add(new Bottle("Coca-Cola Zero", 0.5, 2.0));
        bottleList.add(new Bottle("Coca-Cola Zero", 1.5, 2.5));
        bottleList.add(new Bottle("Fanta Zero", 0.5, 1.95));
        bottleList.add(new Bottle("Fanta Zero", 0.5, 1.95));

    }
  
    
    public void addMoney() {
        money += 1;
        System.out.println("Klink! Lisää rahaa laitteeseen!");
    
    }
    
    
    public void buyBottle() {
        listBottles();
        //käyttäjän syöte
        System.out.print("Valintasi: ");
        Scanner skanneri = new Scanner(System.in);
            input = skanneri.nextLine();
            try {
            a = Integer.parseInt(input);
            } catch (NumberFormatException n){
             System.out.println("Virheellinen syöte!");
            }
        a = a-1;
            
            
        
        if(money >= bottleList.get(a).getPrice()){
            if(bottleList.get(a) != null){
            money -= bottleList.get(a).getPrice();
            //bottles -= 1
            System.out.println("KACHUNK! " + bottleList.get(a).getName() + " tipahti masiinasta!");
            bottleList.remove(a);

        }
            else{
                System.out.println("Pullot ovat loppu!");
            }
        }
        else{
            System.out.println("Syötä rahaa ensin!");
        }
        }
    
    
    public void listBottles(){
        for(int a= 0; a < bottleList.size() ;a++){
            System.out.println((a+1) + ". Nimi: " + bottleList.get(a).getName());
            System.out.println("\tKoko: " + bottleList.get(a).getSize() + "\t" + "Hinta: " + bottleList.get(a).getPrice());
           
        }
    }
    
    public void returnMoney(){
        if(money != 0){
            money = 0;
        System.out.println("Klink klink. Sinne menivät rahat!");
    }
    }
}