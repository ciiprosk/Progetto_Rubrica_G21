/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.progetto.validazioneContatti;

import it.unisa.diem.progetto.rubrica.Contatto;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *@brief La classe implementa l'interfaccia funzionale Validator
 */
public class EMailValidator implements Validator{
    /**
     * 
     * @param email
     * @return 
     */
     @Override
    public boolean verifica(String email) {
        if (email.trim().isEmpty()) {
            return true;
        }

        
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    @Override
    public boolean inserito(String eMail) {
        
        if (eMail.trim().isEmpty())
            return false;
        else
        return true;   
    }
    
}
