/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.progetto.validazioneContatti;

/**
 * @defgroup it_unisa_diem_progetto_validazioneContatti
 * @brief La classe implementa l'interfaccia funzionale Validator
 */
public class NumTelefonoValidator implements Validator {

    /**
     * @brief Il metodo verifica che la stringa inserita telefono sia corretta.
     * Viene verificato che la stringa si formata da numeri, la lunghezza non è verificata perché i numeri di telefono possono cambiare la 
     * presenza di numeri a seconda del paese. 
     * @param numTelefono La stringa inserita dall'utente.
     * @return boolean: true se a stringa inserita è "" oppure se non è "" controlla che la prima lettera non sia un carattere speciale.
     */
    @Override
    public boolean verifica(String numTelefono) {
        if (numTelefono.trim().isEmpty()) {
            return true;
        }
        return numTelefono.matches("\\d+");
    }
    /**
     * @brief Il metodo verifica che l'utente abbia inserito il nome o il cognome.
     * @param numTelefono Stringa inserita.
     * @return boolean: true, l'utente ha inserito una stringa, false altrimenti.
     */

    @Override
    public boolean inserito(String numTelefono) {
        return !numTelefono.trim().isEmpty();
    }
}
