
package it.unisa.diem.progetto.rubrica;



import it.unisa.diem.progetto.gestioneContatti.DatabaseManager;
import it.unisa.diem.progetto.gestioneContatti.ImportaEsporta;
import java.sql.Connection;
import java.util.ArrayList;

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
        return db.aggiungiContatto(c);
    }


    
    /**
     * 
     * @brief Il metodo modifica un contatto in rubrica .
     * 
     * @pre Il contatto esiste.
     * @post Il contatto è correttamente modificato
     * 
     * @param[in] c Contatto da modificare.
     * @return boolean: true il contatto è modificato correttamente, false altrimenti.
     */
    public boolean modificaContatto(Contatto c){
        return db.modificaContatto(c);
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
        return db.eliminaContatto(c);
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
        return db.eliminaTuttiIContatti();
 
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
        //1. prende due liste di contatti da database, una con cognomi e una con nomi
        List<Contatto> lista1=db.prelevaContattiCognome();
        List<Contatto> lista2=db.prelevaContattiNome();
        
        List <Contatto> listaDaEsportare=new ArrayList<>();
        listaDaEsportare.addAll(lista1);
        listaDaEsportare.addAll(lista2);
        //la lista deve essere passata alla classe che si occupa di esportatre i dati
        ImportaEsporta ie=new ImportaEsporta();
        ie.esporta(listaDaEsportare, nomefile);
        
        throw new UnsupportedOperationException("Not supported yet.");
    }
    /**
     * @brief Il metodo chiude la rubrica richiamando il metodo di chiususra della connessione dell'interfaccia DatabaseManager
     */
    public void chiudiRubrica(){
        db.chiudiConnessione();
    }
    
}
