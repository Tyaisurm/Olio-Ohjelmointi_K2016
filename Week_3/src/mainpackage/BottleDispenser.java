/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mainpackage;

/**
 *
 * @author m7942
 */
public class BottleDispenser {
    
    private int bottles;
    private int money;
    
    public BottleDispenser() {
        bottles = 50;
        money = 0;
    }
    
    public void addMoney() {
        money += 1;
        System.out.println("Klink! Lisää rahaa laitteeseen!");
    }
    
    public void buyBottle() {
        bottles -= 1;
        if(money >= 1){
            money -= 1;
            System.out.println("KACHUNK! Pullo tipahti masiinasta");

        }
        else{
            System.out.println("Syötä rahaa ensin!");
        }
        }
    
    
    public void returnMoney(){
        money = 0;
        System.out.println("Klink klink. Sinne menivät rahat");
    }
}
