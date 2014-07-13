/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webcrawler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author spam
 */
public class FileRead {
    @SuppressWarnings("ConvertToTryWithResources")
    public ArrayList<String> read() {
        try {
            File file = new File("C:\\Users\\mahasaty\\Documents\\Progs\\Java\\WebCrawler\\src\\webcrawler\\links.txt");
            FileReader fr = new FileReader(file);
            BufferedReader buff = new BufferedReader(fr);
            String line;
            ArrayList<String> links = new ArrayList<>();
            
            while ((line = buff.readLine()) != null) {
                links.add(line);
            }
            fr.close();
            
            return links;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
