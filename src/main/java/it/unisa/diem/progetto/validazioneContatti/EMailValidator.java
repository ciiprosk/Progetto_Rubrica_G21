
package it.unisa.diem.progetto.validazioneContatti;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @defgroup it_unisa_diem_progetto_validazioneContatti
 * @packege @validazioneContatti
 * @brief La classe implementa l'interfaccia funzionale Validator
 */
public class EMailValidator implements Validator {

    /**
     * @brief Il metodo verifica che la e-mail inserita dall'utente sia corretta. 
     * E' stato utilizzato il metodo matches
     * ---> [a-zA-Z0-9._%+-]+: accetta lettere maiuscole e minuscole, numeri e i caratteri ._%+- prima della chiocciola @.
     * ---> @: richiede la presenza del simbolo @.
     * ---> [a-zA-Z0-9.-]+: accetta lettere, numeri, punti e trattini dopo la chiocciola (il dominio).
     * ---> \\.: richiede la presenza di un punto (escaped con \\ in Java).
     * ---> [a-zA-Z]{2,}: richiede almeno 2 caratteri (solo lettere) dopo il punto (es. "com", "it").
     * ---> $: segna la fine della stringa
     * @param email La e-mail inserita dall'utente.
     * @return boolean: true La stringa è corretta, false altrimenti.
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
    
    /**
     *  @brief Il metodo verifica che l'utente abbia inserito l'e-mail.
     * @param eMail Stringa inserita.
     * @return boolean: true, l'utente ha inserito una stringa, false altrimenti.
     */
    @Override
    public boolean inserito(String eMail) {
        return !eMail.trim().isEmpty();
    }

}
