
package it.unisa.diem.progetto.validazioneContatti;

/**
 * @defgroup it_unisa_diem_progetto_validazioneContatti
 * @brief La classe implementa l'interfaccia funzionale Validator
 */
public class NomeCognomeValidator implements Validator {

    /**
     * @brief Il metodo verifica che la stringa inserita come nome o cognome sia corretta. 
     * @param dato La stringa inserita dall'utente.
     * @return boolean: true se a stringa inserita è "" oppure se non è "" controlla che la prima lettera non sia un carattere speciale.
     */
    @Override
    public boolean verifica(String dato) {

        if (dato.trim().isEmpty()) {
            return true;
        }

        return dato.matches("^[a-zA-Z].*");

    }
     /**
     * @brief Il metodo verifica che l'utente abbia inserito il nome o il cognome.
     * @param dato Stringa inserita.
     * @return boolean: true, l'utente ha inserito una stringa, false altrimenti.
     */

    @Override
    public boolean inserito(String dato) {
        return !dato.trim().isEmpty();
    }

}
