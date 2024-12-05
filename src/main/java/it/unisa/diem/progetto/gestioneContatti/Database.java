/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.progetto.gestioneContatti;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author rosap
 */
public class Database {
    private String URL;
    private String username;
    private String password;
    
    public Database(String URL, String username, String password){
        this.URL=URL;
        this.username=username;
        this.password=password;
    }
    
    public static Connection connessione(){
        Connection connection =null;
        return connection;
    }
    
    public static boolean aggiungiContatto(){
        
    }
    
    public static boolean modificaContatto(){
        
    }
    
    public static boolean eliminaContatto(){
        
    }
    
     public boolean eliminaTuttIContatti(){
         
    }
     
    public void chiusuraConnessione(){
        
    }
    
    public List<Contatto> visualizzaContatti() {
         
    }
    
    public List<Cntatto> esportaContatti(){
        
    }

}
