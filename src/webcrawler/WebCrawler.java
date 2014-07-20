/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webcrawler;

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


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
        System.getProperties().put("http.proxyHost", "web-proxy.cce.hp.com");
        System.getProperties().put("http.proxyPort", "8080");
        
        for (String lns : links) {
            System.out.println("URLs present in " + lns + ":\n");
            WebCrawler wc = new WebCrawler();
            wc.crawl(lns);
        }
    }
    
    public void crawl(String url) {
        
        ArrayList<String> urls = new ArrayList<>();
        ArrayList<String> visited = new ArrayList<>();
        
        urls.add(url);
        visited.add(url);
        
        while (urls.size() > 0) {
            Document doc;
            try {
                doc = Jsoup.connect(urls.get(0)).get();
                // getting all links
                Elements links = doc.select("a[href]");
                for (Element link : links) {
                    
                    //getting the value from href attribute
                    System.out.println(link.attr("href"));
                    
                    if (visited.contains(link.attr("href"))) {
                        
                    } else {
                        urls.add(link.attr("href"));
                        visited.add(link.attr("href"));
                    }
                }
                
            } catch (IOException e) {
                System.out.println(urls.get(0) + " not working");
            }
            urls.remove(0);
        }
        for ( String i : visited) {
            System.out.println(i);
        }
    }
    
}
