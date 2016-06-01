/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mainpackage;

import java.util.Scanner;

/**
 *
 * @author m7942
 */
public class Mainclass {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        BottleDispenser pullo = new BottleDispenser();
        pullo.PullonPalautin();
        int menu = 1;
        String input;
        
        /*pullo.addMoney();
        pullo.buyBottle();
        pullo.buyBottle();
        pullo.addMoney();
        pullo.addMoney();
        pullo.buyBottle();
        pullo.returnMoney();*/
        
                while(menu != 0){
            System.out.print("\n*** LIMSA-AUTOMAATTI ***\n1) Lisää rahaa koneeseen\n2) Osta pullo\n3) Ota rahat ulos\n4) Listaa koneessa olevat pullot\n0) Lopeta\nValintasi: ");
            
            Scanner skanneri = new Scanner(System.in);
            input = skanneri.nextLine();
            try {
            menu = Integer.parseInt(input);
            } catch (NumberFormatException n){
             System.out.println("Virheellinen syöte!");
             continue;
            }
            
            switch(menu){
                case 1:
                    pullo.addMoney();
                    break;
                case 2:
                    pullo.buyBottle();
                    break;
                case 3:
                    pullo.returnMoney();
                    break;
                case 4:
                    pullo.listBottles();//listaa kaikki laitteen pullot
                    break;
                case 0://lopeta
                    break;
                default:
                    System.out.println("Virheellinen syöte!");
                    break;
            
            }
      
        
        }
        
    }

}
