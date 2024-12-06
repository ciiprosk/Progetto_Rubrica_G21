++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.progetto.gestioneContatti;

import it.unisa.diem.progetto.rubrica.Contatto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @brief La classe prevede tutte le operazioni che devono essere effettuate sul database.
 * 
 */

public class Database {
    
    private  static String URL;
    private static  String username;
    private static String password;
    private static Connection connection=null;
    
    /**
     * @brief Costruttore della classe
     * Il costruttore prede da un file speciale tutte le informazioni che gli serviranno per la connessione al database al database.
     * 
     * I parametri vengono letti da un file speciale che garantisce sicurezza, ad esempio la password non viene mai visualizzata a video.
     * 
     * @param URL
     * @param username
     * @param password 
     */
    public Database(String URL, String username, String password){
        this.URL=URL;
        this.username=username;
        this.password=password;
    }

    /**
     * @brief Questo metodo statico esegue la connessione al database, se la connessione fallisce viene generato un messaggio di errore.
     * 
     * @pre Gli attributi per la connessione sono stati correttamente inizializzati nel costruttore.
     * @post La variabile d ritorno contiene il link di connessione al database.
     * 
     * @return Connection link al database PostgreSQL.
     */  
    public static Connection connessione(){
        try{
            if(connection==null || connection.isClosed())
                connection= DriverManager.getConnection(URL, username, password);
        }catch(SQLException e){
            System.err.println("Connesione al databse fallita");
        }
        return connection;
    }
    
    /**
     * @brief Il metodo aggiunge un nuovo contatto nel database.
     * 
     * @pre La cnnessione al database è avvenuta con successo.
     * @post Il contatto è stato aggiunto come nuova riga nel database.
     * 
     * @return boolean: true se il contatto è stato aggiunto, false altrienti.
     */    
    public static boolean aggiungiContatto(){
        
    }
    
    /**
     * @bief Il metodo modifica uno dei contatti presenti tra le colonne della tabella del database.
     * 
     * @pre La cnnessione al database è avvenuta con successo.
     * @post Il contatto è stato modificato.
     * 
     * @return boolean: true se il contatto è stato modificato, false altrienti.
     */
    public static boolean modificaContatto(){
        
    }
    
    /**
     * @brief Il metodo elimina un contatto dalla tabella del database.
     * 
     * @pre La connessione al database è avvenuta con successo.
     * @post Il contatto è stato  eliminato. 
     * 
     * @return boolean: true se il contatto è stato eliminato, false altrienti.
     */    
    public static boolean eliminaContatto(){
        
    }
    
    /**
     * @rief Il metodo elimina tutti i contatti presenti nella tabella del database.
     * 
     * @pre La connessione al database è avvenuta con successo ed è presente almeno un contatto nella tabella.
     * @post I contatti sono stati eliminati e la tabella è vuota.
     * 
     * @return boolean: true se tutti i contatti sono stati eliminati, false altrimenti.
     */    
     public static boolean eliminaTuttiIContatti(){
         
    }
     
    /**
     * @brief Il metodo preleva i contatti dalla tabella e li salva in una lista.
     * 
     * @pre La connessione al database è avvenuta con successo ed è presente almeno un contatto nella tabella.
     *  
     * @return La lista dei contatti presneti nella tabella del database in ordine di cognome.
     */
    public static List<Contatto> prelevaContattiCognome() {
         
    }
    
    /**
     * @brief Il metodo preleva i contatti dalla tabella e li inserusce in una lista.
     * 
     * @pre La connessione al database è avvenuta con successo ed è presente almeno un contatto nella tabella.
     *  
     * @return La lista dei contatti presenti nella tabella del database in ordine di nome
     */
    public static List<Contatto> prelevaContattiNome() {
         
    } 
    
     
    /**
     * @brief Il metodo chiude la connessione al database a cui era collegato.
     * 
     * @pre conn!=null Il paramentro di ingresso non deve essere nullo
     * @post La connessione viene chiusa.
     * 
     * 
     */   
    public static void chiusuraConnessione(){
        try{
            if(!(connection==null) && !(connection.isClosed()))
                connection.close();
        }catch(SQLException e){
            System.err.println("Errore durante la chiusura della connessione: ");
        }        
    }
    


}
