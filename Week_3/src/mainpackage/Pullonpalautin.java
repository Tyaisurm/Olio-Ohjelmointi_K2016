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
public class Pullonpalautin {
    
    private int bottleCount;
    // The array for the Bottle-objects
    private int money;
    
    public Pullonpalautin() {
        bottleCount = 5;
        money = 0;
        
        // Initialize the array
        ArrayList<Pullo> pulloLista = new ArrayList<Pullo>();
        
        // Add Bottle-objects to the array
        for(int i = 0;i<bottleCount;i++) {
            // Use the default constructor to create new Bottles
            pulloLista.add = new Pullo();
        }
    }
    
    public void addMoney() {
        money += 1;
        System.out.println("Klink! Money was added into the machine!");
    }
    
    public void buyBottle() {
        if(money != 0){
            money -=1;
            bottleCount -= 1;
        }
        System.out.println("KACHUNK! Bottle appeared from the machine!");
    }
    
    public void returnMoney() {
        if(money != 0){
            System.out.println("Klink klink. Money returned " + money);    
        }
    }

}
