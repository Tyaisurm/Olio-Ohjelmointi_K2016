/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

import java.io.FileNotFoundException;
import java.io.IOException;

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
        ReadAndWriteIO rwIO = new ReadAndWriteIO();
        
        // 2 = zip-file input(that has .txt inside), 1 = normal .txt-file input  
        String input = "zipinput.zip";
        String file = "input.txt";
        String output = "output.txt";
        int choice = 2;
        
        try {
            //System.out.println(System.getProperty("user.dir"));
            
            rwIO.readAndwrite(input, output, file, choice);
        } catch (FileNotFoundException x) {
            //System.out.println(System.getProperty("user.dir"));
            System.out.println(x);

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

}
