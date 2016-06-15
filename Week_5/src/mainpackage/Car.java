/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
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
        
        TreeMap<String, Integer> osat = new TreeMap<>();
        for (Object p : arraylist) {
            if (osat.containsKey(p.getClass().getSimpleName()) == false) {
                osat.put(p.getClass().getSimpleName(), 1);
                //System.out.println(osat);
            } else {
                int maara = (int)osat.get(p.getClass().getSimpleName());
                osat.put(p.getClass().getSimpleName(), maara+1);
            }
        }
       
        //System.out.println(osat);
        Iterator iterator = osat.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry pairs = (Map.Entry)iterator.next();
            int i = (Integer)pairs.getValue();
            System.out.print("\t");
            if(i > 1){
               System.out.print(pairs.getValue() + " ");

            }
            System.out.println(pairs.getKey());
        }
     
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
