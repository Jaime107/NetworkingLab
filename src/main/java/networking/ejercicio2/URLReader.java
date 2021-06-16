/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networking.ejercicio2;

import java.net.URL;


/**
 *
 * @author Jaime107
 */
public class URLReader {
    
    public static void main(String[] args) throws Exception {

        String indexPath = "resultado.html";
        URLMaker urlMkr = new URLMaker();
        URL myURL = urlMkr.ReadURL();
        urlMkr.WriteURL(myURL,indexPath);
        
        
        
        
        
        
        
    }

}




