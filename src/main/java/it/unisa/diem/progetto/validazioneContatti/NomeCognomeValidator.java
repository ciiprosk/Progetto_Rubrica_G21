/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.progetto.validazioneContatti;


/**
 *@brief La classe implementa l'interfaccia funzionale Validator
 */
public class NomeCognomeValidator implements Validator{
    /**
     * 
     * @param dato
     * @return 
     */
    @Override
    public boolean verifica(String dato) {
        
        if (dato.trim().isEmpty())
            return true;
        
        return dato.matches("^[a-zA-Z].*");
        
    }
    
    public boolean inserito(String dato) {
        if (dato.trim().isEmpty())
            return false;
        else
        return true;
    }

}
