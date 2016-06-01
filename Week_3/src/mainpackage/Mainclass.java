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
public class Mainclass {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        BottleDispenser possu = new BottleDispenser();
        possu.addMoney();
        possu.buyBottle();
        possu.buyBottle();
        possu.addMoney();
        possu.addMoney();
        possu.buyBottle();
        possu.returnMoney();
        
    }

}
