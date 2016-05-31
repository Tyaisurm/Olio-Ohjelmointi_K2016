/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mainpackage;

import java.util.Random;

/**
 *
 * @author m7942
 */
public class Mainclass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hello world!");
        Mainclass kokonimi = new Mainclass();
        kokonimi.mina();
    }

    /**
     *
     */
    private Random rand = new Random();
   
    public void mina(){
        String[] nimi_alku = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        String[] nimi_kirjaimet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z" };        System.out.print("My name is " + nimi_alku[rand.nextInt(nimi_alku.length)]);
        
        for (int a = 0; a<6 ; a++){
            System.out.print(nimi_kirjaimet[rand.nextInt(nimi_kirjaimet.length)]);
        }
        System.out.println();
        

    }

}
