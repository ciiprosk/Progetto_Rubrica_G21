
package it.unisa.diem.progetto.gestioneContatti;

import it.unisa.diem.progetto.rubrica.Contatto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @brief La classe prevede tutte le operazioni che devono essere effettuate sul database.
 * 
 */

public class Database implements DatabaseManager{
    
    private  final String URL= "jdbc:postgresql";
    private final String link="database-1.czikiq82wrwk.eu-west-2.rds.amazonaws.com";
    private final String db_name="progetto";
    private  String username="postgres";
    private String password="Farinotta01_";
    private Connection connection=null;
    
    
    public Database(){
        //crea sololo spazio in memoria con i metodi che si possono utilizzare e avvia la connessione
         try{
            if(connection==null || connection.isClosed())
                connection= DriverManager.getConnection(URL, username, password);
             System.out.println("connessione riuscita");
        }catch(SQLException e){
            System.err.println("Connesione al databse fallita");
        }
    }
    


    /**
     * @brief Il metodo ritorna un riferiento alla connession eavvenuta nel costruttore
     */  
    @Override
    public Connection riferimentoConnessione(){
         try{
            if(connection==null || connection.isClosed())
                connection= DriverManager.getConnection(URL, username, password);
             System.out.println("connessione riuscita");
        }catch(SQLException e){
            System.err.println("Connesione al databse fallita");
        }
       
        return connection;
    }
    private boolean verificaConnessione(){
        if(connection!=null) return true;
        return false;
    }
    /**
     * @param c
     * @brief Il metodo aggiunge un nuovo contatto nel database.
     * 
     * @pre La cnnessione al database è avvenuta con successo.
     * @post Il contatto è stato aggiunto come nuova riga nel database.
     * 
     * @return boolean: true se il contatto è stato aggiunto, false altrienti.
     */ 
    @Override
    public boolean aggiungiContatto(Contatto c){
        
        String query="INSERT INTO contatti"+ " values";
       if(!verificaConnessione()){
           connection=riferimentoConnessione();
       }
       try(Statement stmt=connection.createStatement()){
           
       }catch(SQLException e){
           System.err.println("Fallimento nell'inaerimento di dati");
       };
        return true;
    }
    
    /**
     * @param c
     * @bief Il metodo modifica uno dei contatti presenti tra le colonne della tabella del database.
     * 
     * @pre La cnnessione al database è avvenuta con successo.
     * @post Il contatto è stato modificato.
     * 
     * @return boolean: true se il contatto è stato modificato, false altrienti.
     */
    @Override
    public boolean modificaContatto(Contatto c){
                throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * @param c
     * @brief Il metodo elimina un contatto dalla tabella del database.
     * 
     * @pre La connessione al database è avvenuta con successo.
     * @post Il contatto è stato  eliminato. 
     * 
     * @return boolean: true se il contatto è stato eliminato, false altrienti.
     */    
    @Override
    public boolean eliminaContatto(Contatto c){
                throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * @rief Il metodo elimina tutti i contatti presenti nella tabella del database.
     * 
     * @pre La connessione al database è avvenuta con successo ed è presente almeno un contatto nella tabella.
     * @post I contatti sono stati eliminati e la tabella è vuota.
     * 
     * @return boolean: true se tutti i contatti sono stati eliminati, false altrimenti.
     */    
    @Override
     public boolean eliminaTuttiIContatti(){
          throw new UnsupportedOperationException("Not supported yet.");       
    }
     
    /**
     * @brief Il metodo preleva i contatti dalla tabella e li salva in una lista.
     * 
     * @pre La connessione al database è avvenuta con successo ed è presente almeno un contatto nella tabella.
     *  
     * @return La lista dei contatti presneti nella tabella del database in ordine di cognome.
     */
    @Override
    public List<Contatto> prelevaContattiCognome() {
        throw new UnsupportedOperationException("Not supported yet.");    
    }
    
    /**
     * @brief Il metodo preleva i contatti dalla tabella e li inserusce in una lista.
     * 
     * @pre La connessione al database è avvenuta con successo ed è presente almeno un contatto nella tabella.
     *  
     * @return La lista dei contatti presenti nella tabella del database in ordine di nome
     */
    public  List<Contatto> prelevaContattiNome() {
        throw new UnsupportedOperationException("Not supported yet.");
    } 
    
     
    /**
     * @brief Il metodo chiude la connessione al database a cui era collegato.
     * 
     * @pre conn!=null Il paramentro di ingresso non deve essere nullo
     * @post La connessione viene chiusa.
     * 
     * 
     */   
    @Override
    public void chiudiConnessione(){
        try{
            if(!(connection==null) && !(connection.isClosed()))
                connection.close();
        }catch(SQLException e){
            System.err.println("Errore durante la chiusura della connessione: ");
        }        
    }
    


}
