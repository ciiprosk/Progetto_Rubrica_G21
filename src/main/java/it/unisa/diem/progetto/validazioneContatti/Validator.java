
package it.unisa.diem.progetto.validazioneContatti;

/**
 * @brief Interfaccia Validator per validare i contatti
 */
public interface Validator {

    boolean verifica(String dato);

    boolean inserito(String dato);

}
