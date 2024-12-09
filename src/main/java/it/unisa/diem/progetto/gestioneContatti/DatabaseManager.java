/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package it.unisa.diem.progetto.gestioneContatti;

import java.sql.Connection;
import it.unisa.diem.progetto.rubrica.Contatto;
import java.util.List;
/**
 *
 * @author rosap
 */
public interface DatabaseManager {
        public Connection connessione();
        boolean aggiungiContatto(Contatto c);
        boolean modificaContatto(Contatto c);
        boolean eliminaContatto(Contatto c);
        boolean eliminaTuttiIContatti();
        List<Contatto> prelevaContattiCognome();
        List<Contatto> prelevaContattiNome();
        void chiudiConnessione();
}
