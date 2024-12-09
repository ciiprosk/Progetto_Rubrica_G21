
package it.unisa.diem.progetto.rubrica;



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
     this.db=db;
       
                }

    /**
     * @brief Il metodo aggiuge un contatto in rubrica 
     * 
     * @param[in] c Contatto da aggiungere alla rubrica
     * @return boolean: true il contatto è aggiunto correttamente, false altrimenti
     */
    public boolean aggiungiContatto(Contatto c){
              throw new UnsupportedOperationException("Not supported yet.");
 
    }

    public boolean salvaContatto(Contatto c){
              throw new UnsupportedOperationException("Not supported yet.");  
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
                throw new UnsupportedOperationException("Not supported yet.");
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
                throw new UnsupportedOperationException("Not supported yet.");
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
                throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public List listaContatti(){
                throw new UnsupportedOperationException("Not supported yet.");

    }
    
    
    public void visualizzaContatto(Contatto c){
                        throw new UnsupportedOperationException("Not supported yet.");
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
               throw new UnsupportedOperationException("Not supported yet.");
 
    }
    
    /**
     * @brief Il metodo importa tutti i contatti presenti su un file in rubrica.
     * 
     * @post I contatti sono salvati in rubrica.
     * 
     * @return .
     */
    public List importaContatti(String nomefile){
                throw new UnsupportedOperationException("Not supported yet.");

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
                throw new UnsupportedOperationException("Not supported yet.");
    }
    /**
     * @brief Il metodo chiude la rubrica richiamando il metodo di chiususra della connessione dell'interfaccia DatabaseManager
     */
    public void chiudiRubrica(){
        db.chiudiConnessione();
    }
    
}
