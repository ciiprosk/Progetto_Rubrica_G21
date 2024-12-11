/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.progetto.validazioneContatti;

import it.unisa.diem.progetto.rubrica.Contatto;

/**
 *@brief La classe implementa l'interfaccia funzionale Validator
 */
public class EMailValidator implements Validator{
    /**
     * 
     * @param eMail
     * @return 
     */
     @Override
    public boolean verifica(String eMail) {
        if( eMail.trim().isEmpty())
            return true;
        
        if ( eMail.charAt(0) ==('@'))
            return false;
        
        return eMail.matches(".*@.*");
    }

    @Override
    public boolean inserito(String eMail) {
        
        if (eMail.trim().isEmpty())
            return false;
        else
        return true;   
    }
    
}
