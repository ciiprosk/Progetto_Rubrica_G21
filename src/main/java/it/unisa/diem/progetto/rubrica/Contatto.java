
package it.unisa.diem.progetto.rubrica;

/**
 *
 * @author rosap
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
    
    public Contatto(String cognome, String nome, String[] numTelefono, String[] eMail) {
        this.cognome = cognome;
        this.nome = nome;
        this.numTelefono = numTelefono;
        this.eMail = eMail;
        this.id =+ cont;
        
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setNumTelefono(String[] numTelefono) {
        this.numTelefono = numTelefono;
    }

    public void setEMail(String[] eMail) {
        this.eMail = eMail;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String[] getNumTelefono() {
        return numTelefono;
    }

    public String[] geteMail() {
        return eMail;
    }

    public int getId() {
        return id;
    }
    
    


    
}
