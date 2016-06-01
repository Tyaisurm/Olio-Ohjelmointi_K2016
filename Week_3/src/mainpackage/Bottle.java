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
public class Bottle {
    
    private String name;
    private String maker;
    private double size;
    private double price;

    public Bottle(String name, double size, double price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }
    
    public Bottle(){
        //oletukset, jos on
        this.name = "Pepsi Max";
        this.size = 0.5;
        this.price = 1.8;
    }
  
    
    
    public String getName(){
        return name;
    }
    
    public String getMaker(){       
    return maker;
    }
    
    public double getSize(){
        return size;
    }
    
    public double getPrice(){
        return price;
    }
}