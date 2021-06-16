/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networking;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jaime107
 */
public class analizadorUrl {
    /** Metodo principal en el cual al final se muestra al usuario la información.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        readUrl();   
    }
    
    
    //EJERCICIO 1
    private static void readUrl() {
        try {
            
            URL myUrl = new URL("http://www.escuelaing.edu.co:80/es/comunidad/estudiantes?id=211432#00h02m30s");
            System.out.println("Protocolo: "+myUrl.getProtocol());
            System.out.println("Autoridad: "+myUrl.getAuthority());
            System.out.println("Host: "+myUrl.getHost());
            System.out.println("Puerto: "+myUrl.getPort());
            System.out.println("Host: "+myUrl.getPath());
            System.out.println("Query: "+ myUrl.getQuery());
            System.out.println("File: "+ myUrl.getFile());
            System.out.println("Ref:   "+ myUrl.getRef());
                       
        } catch (MalformedURLException ex) {
            Logger.getLogger(analizadorUrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
}
    

