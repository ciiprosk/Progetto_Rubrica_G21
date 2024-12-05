
package it.unisa.diem.progetto.rubrica;

/**
 * @brief @brief La classe contiene tutti gli attributi e i metodi per gestire un singolo contatto.
 */
public class Contatto {
    private String cognome;
    private String nome;
    //Usiamo vettori di String 
    private String[] numTelefono=new String[3];
    private String[] eMail=new String[3];
    //Utilizziamo un id sequenziale per la gestione di conflitti i contatti
    private static int cont=0;
    private final int id;
   
//    public Contatto(String cognome, String nome) {
//        
//        this.cognome = cognome;
//        this.nome = nome;
//        this.id =+ cont;
//        
//        
//    }
    /**
     * @brief Costruttore della classe Contatto
     *  Nella fase di impementazione verranno aggiunte poi le opportune verifiche per la gestione dei parametri
     *  L'id è un numero sequenziale asssegnato a ogni utente per poter gestire correttamente gli omonimi
     * @param[in] cognome
     * @param[in] nome
     * @param[in] numTelefono
     * @param [in] eMail 
     */
    public Contatto(String cognome, String nome, String[] numTelefono, String[] eMail) {
        this.cognome = cognome;
        this.nome = nome;
        this.numTelefono = numTelefono;
        this.eMail = eMail;
        this.id =+ cont;
        
    }
    /**
     * @brief Il metodo permette di aggiornare il nome del contatto.
     * Per aggiornare si intende: aggigere se non esiste e modificare se esiste
     * 
    * @pre
    * @post Il nome è impostato correttamente
    * 
    * @param[in] nome 
    */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * @brief Il metodo permette di aggiornare il cognome del contatto.
     * Per aggiornare si intende: aggigere se non esiste e modificare se esiste
     * 
    * @pre
    * @post Il cognome è impostato correttamente
    * 
    * @param[in] cognome
    */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    
    /**
     * @brief Il metodo permette di aggiornare il numero di telefono del contatto.
     * Per aggiornare si intende: aggigere se non esiste e modificare se esiste.
     * 
     * 
    * @pre
    * @post Il numero di telefono è impostato correttamente.
    * 
    * @param[in] numTelefono
    */
    public void setNumTelefono(String[] numTelefono) {
        this.numTelefono = numTelefono;
    }
    
    /**
     * @brief Il metodo permette di aggiornare l'e-mail del contatto.
     * Per aggiornare si intende: aggigere se non esiste e modificare se esiste.
     * 
    * @pre
    * @post L'e-mailè impostato correttamente.
    * 
    * @param[in] cognome
    */
    public void setEMail(String[] eMail) {
        this.eMail = eMail;
    }
    
    /**
     * @brief Il metodo ritorna il nome del contattose presente;
     * 
     * @return nome Il nome del contatto.
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * @brief Il metodo ritorna il cognome del contatto se presente;
     * 
     * @return cognome Il cognome del contatto.
     */
    public String getCognome() {
        return cognome;
    }
    
    /**
     * @brief Il metodo ritorna il numero di telefono del contatto se presente;
     * 
     * @return numTelefono Il numero di telefono del contatto.
     */
    public String[] getNumTelefono() {
        return numTelefono;
    }
    
    /**
     * @brief Il metodo ritorna l'e-mail del contatto se presente;
     * 
     * @return eMail IL'e-mail del contatto.
     */
    public String[] geteMail() {
        return eMail;
    }

    /**
     * @brief Il metodo ritorna l'id del contatto se presente;
     * 
     * @pre Il contatto ha un id 
     * 
     * @return id L'id del contatto.
     */
    public int getId() {
        return id;
    }
    
    


    
}
