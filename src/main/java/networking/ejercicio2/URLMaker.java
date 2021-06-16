/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networking.ejercicio2;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jaime107
 */
public class URLMaker {

    public URLMaker() {
    }
    
    
    public URL ReadURL() {
        System.out.println( "Digite por favor el link a convertir en HTML:  " );
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        URL link= null;
        System.out.println( "Construyendo..." );
    
        try {
            link = new URL(s);
        } catch (MalformedURLException ex) {
            System.out.println( "Error en la URL suministrada." );
            Logger.getLogger(URLMaker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return link;
    
    }
    
    public void WriteURL(URL link,String path){
        
        try (BufferedReader reader
                = new BufferedReader(new InputStreamReader(link.openStream()))) {
            
            File archivo = new File(path);
            BufferedWriter bw;
            String dataText= "";
            bw = new BufferedWriter(new FileWriter(archivo));
            
            String inputLine = null;
            
            while ((inputLine = reader.readLine()) != null) {
                 dataText= dataText + inputLine+"\n"; 
                 System.out.println(inputLine);
            }

             bw.write(dataText);
            bw.close();

            
            

        } catch (IOException x) {
            System.err.println(x);

        }
        
        
    }
}
