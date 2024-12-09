/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.progetto.validazioneContatti;

/**
 *
 * @brief La classe implementa l'interfaccia funzionale Validator
 */
public class NumTelefonoValidator implements Validator{
    /**
     * 
     * @param dato
     * @return 
     */
    @Override
    public boolean verifica(String dato) {
       return dato.matches("\\d+");
    }
}