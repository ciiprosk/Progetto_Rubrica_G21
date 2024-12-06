
package it.unisa.diem.progetto.rubrica;


import it.unisa.diem.progetto.gestioneContatti.Database;
import it.unisa.diem.progetto.gestioneContatti.DatabaseManager;
import java.sql.Connection;

import java.util.List;

/**
 * @brief La classe contiene tutti gli attributi e i metodi per gestire la rubrica.
 */
public class Rubrica {
    private List<Contatto> rubricaCognome;
    private List<Contatto> rubricaNome;
    private DatabaseManager db;
    private Connection connection;
    
    
    public Rubrica(DatabaseManager db){
        //mancano le inizializzazioni degli attributi
        // Apertura della connessione al database quando viene creato un oggetto Rubrica
        this.db=db;
        connection=db.connessione();
    }

    /**
     * @brief Il metodo aggiuge un contatto in rubrica 
     * 
     * @param[in] c Contatto da aggiungere alla rubrica
     * @return boolean: true il contatto è aggiunto correttamente, false altrimenti
     */
    public boolean aggiungiContatto(Contatto c){
       
    }

    public boolean salvaContatto(Contatto c){
        
    }
    
    /**
     * @brief Il metodo modifica un contatto in rubrica .
     * 
     * @pre Il contatto esiste.
     * @post Il contatto è correttamente modificato
     * 
     * @param[in] c Contatto da modificare.
     * @return boolean: true il contatto è modificato correttamente, false altrimenti.
     */
    public boolean modificaContatto(Contatto c){
        
    }
    
    
    /**
     * @brief Il metodo modifica un contatto in rubrica .
     * 
     * @pre Il contatto esiste.
     * @post Il contatto è correttamente eliminato.
     * 
     * @param[in] c Contatto da eliminare dalla rubrica.
     * @return boolean: true il contatto è eliminato correttamente, false altrimenti.
     */
    public boolean eliminaContatto(Contatto c){
        
    }
    
    /**
     * @brief Il metodo cerca un contatto in rubrica .
     * 
     * @pre Il contatto esiste.
     *  
     * @param[in] cognomeNome Sottostringa del nome/cognome del contatto da cecare. 
     * @return 
     */
    public List<Contatto> ricercaContatto(String cognomeNome){
        
    }
    
    public List listaContatti(){
        
    }
    
    
    public void visualizzaContatto(Contatto c){
        
    }
    
    /**
     * @brief Il metodo cancella tutti icontatti presenti in rubrica.
     * 
     * @pre La rubrica non è vuota.
     * @post La rubrica è correttamente modificata.
     * 
     * @return boolean: true I contatti sono stati eliminati, false altrimenti.
     */
    public boolean eliminaTuttiContatti(){
        
    }
    
    /**
     * @brief Il metodo importa tutti i contatti presenti su un file in rubrica.
     * 
     * @post I contatti sono salvati in rubrica.
     * 
     * @return .
     */
    public List importaContatti(String nomefile){
        
    }
    
     /**
     * @brief Il metodo esporta tutti i contatti presenti in rubrica da un file.
     * 
     * @pre La rubrica non è vuota.
     * @post I contatti sono stati esportati.
     * 
     * @return boolean: true i contatti sono stati correttamente esportati, false altrimenti.
     */
    public boolean esportaContatti(String nomefile){
        
    }
    
    public void chiudiRubrica(){
        db.chiudiConnessione();
    }
    
}
