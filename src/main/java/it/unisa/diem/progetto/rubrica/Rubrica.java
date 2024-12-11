package it.unisa.diem.progetto.rubrica;



import it.unisa.diem.progetto.gestioneContatti.DatabaseManager;
import it.unisa.diem.progetto.gestioneContatti.ImportaEsporta;
import java.io.IOException;
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

    
    
    public Rubrica(DatabaseManager db){
     this.db=db;
    }
    
    private void aggiornaListaCognome(){
        rubricaCognome = db.prelevaContattiCognome();
    }
    
    private void aggiornaListaNome(){
        rubricaNome = db.prelevaContattiNome();
        
    }

    /**
     * @brief Il metodo aggiuge un contatto in rubrica 
     * 
     * @param[in] c Contatto da aggiungere alla rubrica
     * @return boolean: true il contatto è aggiunto correttamente, false altrimenti
     */
    public boolean aggiungiContatto(Contatto c){
        if(!db.aggiungiContatto(c))
            return false;
        
        if(c.getCognome() != null)
            aggiornaListaCognome();
            
        else aggiornaListaNome();
        
        return true;
        
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
        if(!db.modificaContatto(c))
            return false;
        
        if(c.getCognome() != null)
            aggiornaListaCognome();
       else aggiornaListaNome();
        
        return true;
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
        if( ! db.eliminaContatto(c)){
            System.out.println("non eliminato");
            return false;
        }
        
        if(c.getCognome() != null)
            aggiornaListaCognome();
            
        else aggiornaListaNome();
        
        return true;
    }
    
     public boolean eliminaContattoCognomeRubrica(Contatto c){
       return rubricaCognome.remove(c);       
    }
    
    /**
     * @brief Il metodo cerca un contatto in rubrica .
     * 
     * @pre Il contatto esiste.
     *  
     * @param[in] cognomeNome Sottostringa del nome/cognome del contatto da cecare. 
     * @return 
     */
    public List<Contatto> ricercaContatto(String cognomeNome) {
    List<Contatto> contattiFiltrati = new ArrayList<>();

    String inputInsensitive = cognomeNome.toLowerCase();
    inputInsensitive = inputInsensitive.trim();

    for (Contatto c : rubricaCognome) {
        String cognomeLower = c.getCognome().toLowerCase();
        String nomeLower = c.getNome().toLowerCase();
        String cognomeNomeConcatenato = (c.getCognome() + " " + c.getNome()).toLowerCase();
        String nomeCognomeConcatenato = (c.getNome() + " " + c.getCognome()).toLowerCase();

        if (cognomeLower.startsWith(inputInsensitive) ||
            nomeLower.startsWith(inputInsensitive) ||
            cognomeNomeConcatenato.startsWith(inputInsensitive) ||
            nomeCognomeConcatenato.startsWith(inputInsensitive)) {
            contattiFiltrati.add(c);
        }
    }

    for (Contatto c : rubricaNome) {
        String nomeLower = c.getNome().toLowerCase();
        if (nomeLower.startsWith(inputInsensitive)) {
            contattiFiltrati.add(c);
        }
    }

    return contattiFiltrati;
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
    
    public List<Contatto> visualizzaListaContattiCognome(){
        return rubricaCognome=db.prelevaContattiCognome();
    }
    
    public List<Contatto> visualizzaListaContattiNome(){
        return rubricaNome=db.prelevaContattiNome();
    }
    
    /**
     * @brief Il metodo importa tutti i contatti presenti su un file in rubrica.
     * 
     * @post I contatti sono salvati in rubrica.
     * 
     * @return .
     */
    public List<Contatto> importaContatti(String nomefile) throws IOException{
        ImportaEsporta ie=new ImportaEsporta();
        List<Contatto> contattiImportati=new ArrayList<>();
        contattiImportati=ie.importa(nomefile);
         for(Contatto c: contattiImportati){
             Contatto app=new Contatto(c.getCognome(),c.getNome(), c.getNumTelefono1(), c.getNumTelefono1(), c.getNumTelefono1(), c.getEMail1(), c.getEMail1(), c.getEMail1());
             eliminaTuttiContatti();
             aggiungiContatto(app);
         }
        return contattiImportati;
       
    }
    
     /**
     * @brief Il metodo esporta tutti i contatti presenti in rubrica da un file.
     * 
     * @pre La rubrica non è vuota.
     * @post I contatti sono stati esportati.
     * 
     * @return boolean: true i contatti sono stati correttamente esportati, false altrimenti.
     */
    public boolean esportaContatti(String nomefile) throws IOException{
        //1. prende due liste di contatti da database, una con cognomi e una con nomi
        List<Contatto> lista1=db.prelevaContattiCognome();
        List<Contatto> lista2=db.prelevaContattiNome();
        
        List <Contatto> listaDaEsportare=new ArrayList<>();
        listaDaEsportare.addAll(lista1);
        listaDaEsportare.addAll(lista2);
        
        //la lista deve essere passata alla classe che si occupa di esportatre i dati        
        ImportaEsporta ie=new ImportaEsporta();
        ie.esporta(listaDaEsportare, nomefile);
        return true;
    }
    /**
     * @brief Il metodo chiude la rubrica richiamando il metodo di chiususra della connessione dell'interfaccia DatabaseManager
     */
    public void chiudiRubrica(){
        db.chiudiConnessione();
    }
    
}