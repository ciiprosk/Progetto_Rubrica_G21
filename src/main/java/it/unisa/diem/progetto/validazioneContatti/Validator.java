
package it.unisa.diem.progetto.validazioneContatti;

/**
 * @defgroup it_unisa_diem_progetto_validazioneContatti
 * @packege @validazioneContatti
 * @brief Interfaccia Validator per validare i contatti
 */
public interface Validator {

    boolean verifica(String dato);

    boolean inserito(String dato);

}
