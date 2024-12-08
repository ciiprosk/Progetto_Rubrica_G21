/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.progetto.validazioneContatti;

import it.unisa.diem.progetto.rubrica.Contatto;

/**
 *@brief La classe implementa l'interfaccia funzionale Validator
 */
public class NomeCognomeValidator implements Validator{
    /**
     * 
     * @param c
     * @return 
     */
     @Override
    public boolean verifica(Contatto c) {
        
        if (c.getNome().isEmpty() && c.getCognome().isEmpty())
            return false;
        
        if ( !   (c.getCognome().matches("^[a-zA-Z].*") || c.getCognome().matches("^[a-zA-Z].*") )   )
            return false;
        
        
        return true;
    }
}
