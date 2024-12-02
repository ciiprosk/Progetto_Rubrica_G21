/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progetto.contatto;

/**
 *
 * @author rosap
 */
public class Contatto {
    private String nome;
    private String cognome;
    private String[] numTelefono;
    private String[] eMail;
    
    private static int id=0;
    private final int seq;
   

    public Contatto(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
        this.seq += id;
    }
    
    public Contatto(String nome, String cognome, String[] numTelefono, String[] eMail) {
        this.nome = nome;
        this.cognome = cognome;
        this.numTelefono = numTelefono;
        this.eMail = eMail;
        this.seq += id;
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

    public void seteMail(String[] eMail) {
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

    public int getSeq() {
        return seq;
    }
    
    


    
}
