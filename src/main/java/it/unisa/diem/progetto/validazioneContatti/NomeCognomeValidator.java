/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.progetto.validazioneContatti;

import it.unisa.diem.progetto.rubrica.Contatto;

/**
 *@brief La classe implementa l'interfaccia funzionale Validator
 */
public class NomeCognomeValidator{
    /**
     * 
     * @param cognome
     * @param nome
     * @return 
     */
    public boolean verifica(String cognome, String nome) {
        
        if (nome.isEmpty() && cognome.isEmpty())
            return false;
        
        if (nome.trim().isEmpty() && cognome.trim().isEmpty())
            return false;
        
        if ( !   (nome.matches("^[a-zA-Z].*") || cognome.matches("^[a-zA-Z].*") )   )
            return false;
        
        
        return true;
    }

}
