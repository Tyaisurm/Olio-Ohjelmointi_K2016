/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mainpackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
/**
 *
 * @author m7942
 */
public class Mainclass
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
        Doge doge = new Doge();
        
        String syoteNimi = "";
        String syoteLausahdus = "";
        
        System.out.print("What did it say: ");
        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        try {
            syoteLausahdus = br1.readLine();
        }
        catch (IOException ex){
        }
        
        System.out.print("And what was its name: ");
        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
        try {
            syoteNimi = br2.readLine();
        }
        catch (IOException ex){
        }
        doge.dogeBuilder(syoteNimi);
        doge.speak(syoteLausahdus);
        
    }
    
}
