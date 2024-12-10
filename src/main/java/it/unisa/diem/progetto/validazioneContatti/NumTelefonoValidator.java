/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.progetto.validazioneContatti;

import it.unisa.diem.progetto.rubrica.Contatto;

/**
 *
 * @brief La classe implementa l'interfaccia funzionale Validator
 */
public class NumTelefonoValidator implements Validator{
    /**
     * 
     * @param numTelefono
     * @return 
     */
    @Override
    public boolean verifica(String numTelefono) {
       if( numTelefono.trim().isEmpty())
            return true;
       return numTelefono.matches("\\d+");
    }
}