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
public class Doge {
    //much wow
    static private String name;
    
    public void speak(String dogeSpeech){
        Doge dogen_nimi = new Doge();
        String dogeNimi = dogen_nimi.getDogename();
        
        Scanner scanner = new Scanner(dogeSpeech);
        while(scanner.hasNext()){
        if(scanner.hasNextInt()){
            System.out.println("Syötteessässäsi oli kokonaisuluku");
        }
        if(scanner.hasNextBoolean()){
            System.out.println("Syötteessäsi oli boolean-arvo");
        }
        scanner.next();
        }
        scanner.close();
        
        if((dogeSpeech.trim()).isEmpty()){
            dogeSpeech = "Much wow";
        }
        
        System.out.println(dogeNimi + ": " + dogeSpeech);
    }
    public String getDogename(){
        return name;
    }
    public void dogeBuilder(String dogeName){
    //DOGES! DOGES EVERYWHERE!
        if((dogeName.trim()).isEmpty()){
            dogeName = "Doge";
        }
        name = dogeName;
        System.out.println("Why, hello there dear sir! My name is " + dogeName);
    }
}
