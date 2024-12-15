/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.progetto.validazioneContatti;

/**
 * @package it.unisa.diem.progetto.validazioneContatti
 * @brief Interfaccia Validator per validare i contatti
 */
public interface Validator {

    boolean verifica(String dato);

    boolean inserito(String dato);

}
