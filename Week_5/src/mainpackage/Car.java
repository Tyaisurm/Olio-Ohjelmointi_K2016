/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeMap;

/**
 *
 * @author m7942
 */
public class Car {

    private ArrayList arraylist = new ArrayList();

    public Car() {
        int a = 0;
        arraylist.add(new Body());
        System.out.println("Valmistetaan: " + arraylist.get(a).getClass().getSimpleName());
        a++;
        arraylist.add(new Chassis());
        System.out.println("Valmistetaan: " + arraylist.get(a).getClass().getSimpleName());
        a++;
        arraylist.add(new Engine());
        System.out.println("Valmistetaan: " + arraylist.get(a).getClass().getSimpleName());
        a++;
        for (int b = 0; b < 4; a++, b++) {
            arraylist.add(new Wheel());
            System.out.println("Valmistetaan: " + arraylist.get(a).getClass().getSimpleName());
        }
    }

    public void print() {
        System.out.println("Autoon kuuluu:");
        
        TreeMap<String, Integer> osat = new TreeMap<String, Integer>();
        for (Object p : arraylist) {
            if (osat.containsKey(p.getClass().getSimpleName()) == false) {
                osat.put(p.getClass().getSimpleName(), 1);
                System.out.println(osat);
            } else {
                int maara = (int)osat.get(p.getClass().getSimpleName());
                osat.put(p.getClass().getSimpleName(), maara+1);
            }
        }
       
        System.out.println(osat);
        
     
    }

    class Wheel {
        //D:
    }

    class Chassis {
        //:D
    }

    class Body {
        //D:
    }

    class Engine {
        //:D
    }
}
