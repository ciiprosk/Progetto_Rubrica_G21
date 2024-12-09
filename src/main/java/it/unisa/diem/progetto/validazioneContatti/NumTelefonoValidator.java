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
     * @param c
     * @return 
     */
    @Override
    public boolean verifica(Contatto c) {
       return c.getNumTelefono1().matches("\\d+") && c.getNumTelefono2().matches("\\d+") && c.getNumTelefono3().matches("\\d+");
    }
}