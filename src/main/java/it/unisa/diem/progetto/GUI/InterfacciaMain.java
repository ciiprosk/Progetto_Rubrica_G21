/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package it.unisa.diem.progetto.GUI;

import it.unisa.diem.progetto.gestioneContatti.Database;
import it.unisa.diem.progetto.gestioneContatti.DatabaseManager;
import it.unisa.diem.progetto.rubrica.Rubrica;

/**
 *
 * @author anton
 */
public class InterfacciaMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //DA MODIFICARE
    //apro anche la connessione quando chiamo il coatruttore
        Rubrica rubrica=new Rubrica(new Database());
        
    }
    
}
