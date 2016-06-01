/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mainpackage;

import java.util.ArrayList;


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
    private String input;

    //kututaan aluksi, yhteensä vain kerran
    public void PullonPalautin() {
        //bottles = 50;
        money = 0;
        
        //bottle.add();
        for(int a = 1; a<7; a++){
            bottleList.add(new Bottle());
        }        
    }
  
    
    public void addMoney() {
        money += 1;
        System.out.println("Klink! Lisää rahaa laitteeseen!");
    
    }
    
    
    public void buyBottle() {
        //listBottles();
        //käyttäjän syöte
        
        
        if(money >= bottleList.get(0).getPrice()){
            if(bottleList.get(0) != null){
            money -= bottleList.get(0).getPrice();
            //bottles -= 1
            System.out.println("KACHUNK! " + bottleList.get(0).getName() + " tipahti masiinasta!");
            bottleList.remove(0);

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
        System.out.println("Klink klink. Sinne menivät rahat!");
    }
    }
}