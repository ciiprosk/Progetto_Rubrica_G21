
package it.unisa.diem.progetto.rubrica;

/**
 * @brief @brief La classe contiene tutti gli attributi e i metodi per gestire un singolo contatto.
 */
public class Contatto {
    private String cognome;
    private String nome;
    //Usiamo vettori di String 
    private String tel1;
    private String tel2;
    private String tel3;
    private String eMail1;
    private String eMail2;
    private String eMail3;
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
    public Contatto(String cognome, String nome, String tel1, String tel2, String tel3, String eMail1, String eMail2,String eMail3) {
        this.cognome = cognome;
        this.nome = nome;
       this.tel1=tel1;
        this.tel2=tel2;
       this.tel3=tel3;
        
       this.eMail1=eMail1;
       this.eMail2=eMail2;
       this.eMail3=eMail3;
       cont++;
       this.id =cont;
        
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
    public void setTelefono1(String tel1) {
        this.tel1= tel1;
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
    public void setTelefono2(String tel2) {
        this.tel2= tel2;
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
    public void setTelefono3(String tel3) {
        this.tel3= tel3;
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
    public void setEMail1(String eMail1) {
        this.eMail1 = eMail1;
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
    public void setEMail2(String eMail2) {
        this.eMail2 = eMail2;
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
    public void setEMail3(String eMail3) {
        this.eMail3 = eMail3;
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
    public String getNumTelefono1() {
        return tel1;
    }
    
    /**
     * @brief Il metodo ritorna il numero di telefono del contatto se presente;
     * 
     * @return numTelefono Il numero di telefono del contatto.
     */
    public String getNumTelefono2() {
        return tel2;
    }
    
    /**
     * @brief Il metodo ritorna il numero di telefono del contatto se presente;
     * 
     * @return numTelefono Il numero di telefono del contatto.
     */
    public String getNumTelefono3() {
        return tel3;
    }
    
    /**
     * @brief Il metodo ritorna l'e-mail del contatto se presente;
     * 
     * @return eMail L'e-mail del contatto.
     */
    public String getEMail1() {
        return eMail1;
    }
    /**
     * @brief Il metodo ritorna l'e-mail del contatto se presente;
     * 
     * @return eMail L'e-mail del contatto.
     */
    public String getEMail2() {
        return eMail2;
    }
    
     /**
     * @brief Il metodo ritorna l'e-mail del contatto se presente;
     * 
     * @return eMail L'e-mail del contatto.
     */
    public String getEMail3() {
        return eMail3;
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
    
        @Override
    public String toString(){
        StringBuffer str=new StringBuffer();
        str.append("Nome: "+ nome+ "\n");
        str.append("Cognome: "+ cognome+ "\n");
        
        str.append("Telefono 1: "+ tel1+ "\n");
        str.append("Telefono 2: "+ tel2+ "\n");
        str.append("Telefono 3: "+ tel3+ "\n");
        
        str.append("E-mail1: "+ eMail1+ "\n");
        str.append("E-mail2: "+ eMail2+ "\n");
        str.append("E-mail3: "+ eMail3+ "\n");
        str.append("\n");
        return str.toString();
    }
    


    
}
