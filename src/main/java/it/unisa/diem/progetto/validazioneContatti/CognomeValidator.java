/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.progetto.validazioneContatti;

import it.unisa.diem.progetto.rubrica.Contatto;

/**
 *@brief La classe implementa l'interfaccia funzionale Validator
 */
public class CognomeValidator implements Validator{
    /**
     * 
     * @param cognome
     * @return 
     */
    @Override
    public boolean verifica(String cognome) {
        
        if (cognome.trim().isEmpty())
            return true;
        
        return cognome.matches("^[a-zA-Z].*");
        
    }
    
    public boolean inserito(String nome) {
        if (nome.trim().isEmpty())
            return false;
        else
        return true;
    }

}
