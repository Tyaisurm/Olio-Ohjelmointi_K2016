/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package parsing;

/**
 *
 * @author m7942
 */
public class TheatreData {
    public TheatreData(){
    }
    
    protected int id;
    protected String name;
    
    public int getID(){
        return id;
    }
    public String getName(){
        return name;
    }
    @Override
    public String toString(){
        return this.name;
    }
}
