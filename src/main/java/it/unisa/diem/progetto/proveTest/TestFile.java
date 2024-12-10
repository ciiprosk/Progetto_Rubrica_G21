/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.progetto.proveTest;

import it.unisa.diem.progetto.gestioneContatti.ImportaEsporta;
import it.unisa.diem.progetto.rubrica.Contatto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ix5lo
 */
public class TestFile{
    
    public static void main(String[] args){
         //connessione al database
         List<Contatto> contatti = new ArrayList<>();
         
         Contatto p = new Contatto("Silano","Omar", null, null, null ,null ,null,null);
         contatti.add(p);
         p = new Contatto("","Omar", null, "32037141414", null ,null ,null,"bella@bellissima.it");
         contatti.add(p);
         p = new Contatto("Passaro","Rosa", null, null, "32037141414" ,null ,null,null);
         contatti.add(p);
         p = new Contatto("Protoleo","Ernesto", "32037141414", null, null ,null ,null,null);
         contatti.add(p);
         
         
         ImportaEsporta ie = new ImportaEsporta();
         
        try {
            //        try {
//            ie.esporta(contatti,"filename.txt");
//        } catch (IOException ex) {
//            Logger.getLogger(TestFile.class.getName()).log(Level.SEVERE, null, ex);
//        }
    contatti = ie.importa("filename.txt");
        } catch (IOException ex) {
            Logger.getLogger(TestFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(contatti);
    }
}

