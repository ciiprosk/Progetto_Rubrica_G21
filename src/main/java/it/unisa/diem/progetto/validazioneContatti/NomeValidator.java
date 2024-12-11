/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.progetto.validazioneContatti;

/**
 *
 * @author Utente
 */
public class NomeValidator implements Validator {

    @Override
    public boolean verifica(String nome) {
        
        if (nome.trim().isEmpty())
            return true;
        
        return nome.matches("^[a-zA-Z].*");
        
    }
    
    public boolean inserito(String nome) {
        if (nome.trim().isEmpty())
            return false;
        else
        return true;
    }
}
