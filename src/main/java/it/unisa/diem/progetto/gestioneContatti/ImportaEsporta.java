/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.progetto.gestioneContatti;

import it.unisa.diem.progetto.rubrica.Contatto;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rosap
 */



public class ImportaEsporta {

    /**
     * @brief Il metodo importa una lista di contatti in rubrica
     * 
     * @post I dati sono correttamente importati nel sistema e salvati nel database. La lista dei contatti è aggiornata.
     * 
     * @param filename
     * @return La lista di contatti aggiornata 
     * @throws IOException 
     */
    
    public List<Contatto> importa(String filename) throws IOException {
        List<Contatto> contatti = new ArrayList<>();
        try ( BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");

                String cognome = fields.length > 0 ? fields[0].trim() : null;
                String nome = fields.length > 1 ? fields[1].trim() : null;
                String tel1 = fields.length > 2 ? fields[2].trim() : null;
                String tel2 = fields.length > 3 ? fields[3].trim() : null;
                String tel3 = fields.length > 4 ? fields[4].trim() : null;
                String eMail1 = fields.length > 5 ? fields[5].trim() : null;
                String eMail2 = fields.length > 6 ? fields[6].trim() : null;
                String eMail3 = fields.length > 7 ? fields[7].trim() : null;

                contatti.add(new Contatto(cognome, nome, tel1, tel2, tel3, eMail1, eMail2, eMail3));
            }
        }
        return contatti;
    }

    /**
     *@brief Il metodo esporta la lista di contatti della rubrica su file
     * 
     * @pre Almeno un contatto presente in rubrica
     * @post I dati dei contatti sono esportati con successo nel file
     * 
     * 
     * @param contatti
     * @param filename
     * @throws IOException 
     */
    
    public static void esporta(List<Contatto> contatti, String filename) throws IOException {
        try ( BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Contatto contatto : contatti) {
                // Scrittura nel formato CSV
                bw.write(String.join(",",
                        contatto.getCognome() != null ? contatto.getCognome() : "",
                        contatto.getNome() != null ? contatto.getNome() : "",
                        contatto.getNumTelefono1() != null ? contatto.getNumTelefono1() : "",
                        contatto.getNumTelefono2() != null ? contatto.getNumTelefono2() : "",
                        contatto.getNumTelefono3() != null ? contatto.getNumTelefono3() : "",
                        contatto.getEMail1() != null ? contatto.getEMail1() : "",
                        contatto.getEMail2() != null ? contatto.getEMail2() : "",
                        contatto.getEMail3() != null ? contatto.getEMail3() : ""));
                bw.newLine();
            }
        }
    }
}
