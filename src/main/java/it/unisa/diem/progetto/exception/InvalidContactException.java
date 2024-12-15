
package it.unisa.diem.progetto.exception;

/**
 * @defgroup it_unisa_diem_progetto_exception
 * @brief Eccezione utilizzata nel caso in cui un utente inserisca dati non validi--> usata per files
 */
public class InvalidContactException extends Exception {

    public InvalidContactException(String message) {
        super(message);
    }
}
