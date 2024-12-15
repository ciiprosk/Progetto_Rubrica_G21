/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
