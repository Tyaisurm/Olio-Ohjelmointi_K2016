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
public class ShapeHandler {
    
    private ShapeHandler instance;
    
    private ShapeHandler(){
    }
    
    public ShapeHandler getInstance(){
        if(instance == null){
            instance = new ShapeHandler();
        }
        return instance;
    }
    
    
}
