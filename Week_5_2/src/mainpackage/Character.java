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
public abstract class Character {
    protected String name; 
    WeaponBehaviour wb = null;
    public Character() throws IOException {
        name = "Oletus";
        int valinta;        
        System.out.print("Valitse aseesi:\n1) Veitsi\n2) Kirves\n3) Miekka\n4) Nuija\nValintasi: ");
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        valinta = Integer.parseInt(bf.readLine());
        switch(valinta){
            case 1:
                wb = new KnifeBehaviour();
                break;
            case 2:
                wb = new AxeBehaviour();
                break;
            case 3:
                wb = new SwordBehaviour();
                break;
            case 4:
                wb = new ClubBehaviour();
                break;
            default:
                System.out.println("Virheellinen syöte!");
        }        
    
    }
    public void fight() {
        //System.out.println("TAPELLAAN!!!");
        System.out.println(name + " tappelee aseella " + wb.wname);
    }    



}

abstract class WeaponBehaviour {
    protected String wname;

    public WeaponBehaviour() {
        wname = "oletus";
        //System.out.println("Tämä tässä on WB rakentaja");
    }

    public void useWeapon() {
        System.out.println("Käytit asetta!");
    }
}

class SwordBehaviour extends WeaponBehaviour {

    public SwordBehaviour() {
        wname = "Sword";
        //System.out.println("You found sword!");
    }
}

class KnifeBehaviour extends WeaponBehaviour {

    public KnifeBehaviour() {
        wname = "Knife";
        //System.out.println("You found knife!");
    }
}

class ClubBehaviour extends WeaponBehaviour {

    public ClubBehaviour() {
        wname = "Club";
        //System.out.println("You found club!");
    }
}

class AxeBehaviour extends WeaponBehaviour {

    public AxeBehaviour() {
        wname = "Axe";
        //System.out.println("You found axe!");
    }
}

class Troll extends Character {

    public Troll() throws IOException{
        name = "Troll";
        //System.out.println("TROLOLOOLOLOLOLOLOLO!");
    }
}

class King extends Character {
    public King()throws IOException{
        name ="King";
        //System.out.println("FOR THE KING!");
    }
}

class Queen extends Character {
    public Queen()throws IOException{
        name = "Queen";
        //System.out.println("FOR THE QUEEN!");
    }
}

class Knight extends Character {
    public Knight()throws IOException{
        name = "Knight";
        //System.out.println(":^)");
    }
}
