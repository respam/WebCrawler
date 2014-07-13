/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webcrawler;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;


/**
 *
 * @author spam
 */
public class WebCrawler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FileRead fileR = new FileRead();
        ArrayList<String> links = fileR.read();
        
        for (String lns : links) {
            System.out.println("URLs present in " + lns + ":\n");
            WebCrawler wc = new WebCrawler();
            wc.crawl(lns);
        }
    }
    
    public void crawl(String url) {
        ArrayList<String> urls = new ArrayList<>();
//        ArrayList<String> visited = new ArrayList<>();
        
        urls.add(url);
//        visited.add(url);
        
        while (urls.size() > 0) {
            try {
                URL urlLink = new URL(url);
                BufferedReader in;
                in = new BufferedReader(new InputStreamReader(urlLink.openStream()));
                String htmltext = in.readLine();
                System.out.println(htmltext);
                
            } catch (IOException e) {
                System.out.println(urls.get(0));
            }
            
        }
    }
    
}
