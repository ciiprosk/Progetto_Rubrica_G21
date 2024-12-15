/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package it.unisa.diem.progetto.gestioneContatti;

import java.sql.Connection;
import it.unisa.diem.progetto.rubrica.Contatto;
import java.util.List;

/**
 * @defgroup it_unisa_diem_progetto_gestioneContatti
 * @brief L'interfaccia è stata creata per diminuire il livello di accoppiamento tra le classi.
 */
public interface DatabaseManager {

    public Connection connessione();

    boolean aggiungiContatto(Contatto c);

    boolean eliminaContatto(Contatto c);

    boolean eliminaTuttiIContatti();

    Contatto recuperaContattoById(int id);

    List<Contatto> prelevaContattiCognome();

    List<Contatto> prelevaContattiNome();

    void chiudiConnessione();
}
