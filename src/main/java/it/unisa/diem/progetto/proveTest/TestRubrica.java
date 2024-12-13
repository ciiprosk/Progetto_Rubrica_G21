/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.progetto.proveTest;

import it.unisa.diem.progetto.gestioneContatti.Database;
import it.unisa.diem.progetto.rubrica.Contatto;
import it.unisa.diem.progetto.rubrica.Rubrica;

/**
 *
 * @author rosap
 */
public class TestRubrica {

    public static void main(String[] args) {
        Rubrica rubrica = new Rubrica(new Database("rubrica"));

        Contatto c = new Contatto("Rossi", "Rosa", "", "", "", "", "", "");
        Contatto c1 = new Contatto("", "o", "", "", "", "", "", "");
        Contatto c2 = new Contatto("Passaro", "", "", "", "", "", "", "");
        Contatto c3 = new Contatto("Marco", "Merrino", "", "", "", "", "", "");
        Contatto c4 = new Contatto("CICCIO", "    ", "", "", "", "", "", "");
        rubrica.eliminaTuttiContatti();

        rubrica.aggiungiContatto(c);
        rubrica.aggiungiContatto(c1);
        rubrica.getContattoById(c.getId());
        rubrica.getContattoById(c.getId());

        System.out.println(rubrica.visualizzaListaContattiCognome());
        rubrica.chiudiRubrica();
        // rubrica.aggiungiContatto(c);
    }

}
