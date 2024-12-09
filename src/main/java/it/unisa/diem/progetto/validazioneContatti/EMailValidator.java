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
     * @param c
     * @return 
     */
     @Override
    public boolean verifica(Contatto c) {
        
        if ( c.getEMail1().charAt(0)==('@') && c.getEMail2().charAt(0)==('@') && c.getEMail3().charAt(0)==('@') )
        return false;
        
        return c.getEMail1().matches(".*@.*") && c.getEMail1().matches(".*@.*") && c.getEMail1().matches(".*@.*");
    }
    
}
