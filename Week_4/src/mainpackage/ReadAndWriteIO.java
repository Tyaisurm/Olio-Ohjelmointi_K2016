/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 *
 * @author m7942
 */
public class ReadAndWriteIO {

    public void readAndwrite(String inputF, String outputF, String file, int choice) throws FileNotFoundException, IOException {
        if (choice == 1) {
            this.readAndWrite_txt(inputF, outputF);
        }
        if (choice == 2) {
            this.readAndWrite_zip(inputF, outputF, file);

        }
    }

    private void readAndWrite_txt(String inputF, String outputF) throws FileNotFoundException, IOException {
        String inputline;
        BufferedReader in = new BufferedReader(new FileReader(inputF));
        BufferedWriter out = new BufferedWriter(new FileWriter(outputF));
        while ((inputline = in.readLine()) != null) {
            if ((0 != ((inputline.trim().length()))) && ((inputline.length()) < 30)) {
                if (inputline.toLowerCase().contains("v")) {
                    out.write(inputline + "\n");
                    //System.out.println(inputline);
                }
                //out.write(inputline + "\n");
                //System.out.println("TESTI" + inputline);
            }
        }
        out.close();
        in.close();
    }

    private void readAndWrite_zip(String inputF, String outputF, String file) throws FileNotFoundException, IOException {
        String inputline;
        ZipFile zip = new ZipFile(inputF);
        Enumeration<? extends ZipEntry> zipEnum = zip.entries();
        while (zipEnum.hasMoreElements()) {
            ZipEntry zipEntry = zipEnum.nextElement();
            String name = zipEntry.getName();
            if (name.contentEquals(file)) {
                InputStream zipIn = zip.getInputStream(zipEntry);
                BufferedReader in = new BufferedReader(new InputStreamReader(zipIn));
                while((inputline = in.readLine()) != null){
                    System.out.println(inputline);
                
                }
                in.close();
                zipIn.close();
                break;
            }
            else{System.out.println("D:");}

        }
    }
}
