/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Integer.parseInt;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author m7942
 */
public class Mainclass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int valinta = 1;
        Character character = null;

        while (valinta != 0) {
            System.out.print("*** TAISTELUSIMULAATTORI ***\n1) Luo hahmo\n2) Taistele hahmolla\n0) Lopeta\nValintasi: ");
            InputStreamReader sysin = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(sysin);
            try {
                valinta = parseInt(br.readLine());
                switch(valinta){
                    case 1:
                        System.out.println("Valitse hahmosi:");
                        System.out.print("1) Kuningas\n2) Ritari\n3) Kuningatar\n4) Peikko\nValintasi: ");
                        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
                        int valinta2 = parseInt(br2.readLine());
                        switch(valinta2){
                            case 1:
                                character = new King();
                                break;
                            case 2:
                                character = new Knight();
                                break;
                            case 3:
                                character = new Queen();
                                break;
                            case 4:
                                character = new Troll();
                                break;
                            default:
                                System.out.println("Virheellinen syöte!");
                        }
                        
                        //:D
                        
                        break;
                    case 2:
                        if(character != null){
                            character.fight();
                        }
                        else{
                            System.out.println("Sinulla ei ole hahmoa!");
                        }
                        break;
                    case 0:
                        //
                        break;
                    default:
                        System.out.println("Virheellinen syöte!");
                }
                //System.out.println(sysin);
            } catch (IOException ex) {
                System.out.println("Error - IOExeption");
            } catch (NumberFormatException ec) {
                System.out.println("Virheellinen syöte!");
            }
            
        }
        
    }

}
