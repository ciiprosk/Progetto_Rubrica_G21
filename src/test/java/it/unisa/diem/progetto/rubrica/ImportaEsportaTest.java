/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.progetto.rubrica;

import it.unisa.diem.progetto.gestioneContatti.ImportaEsporta;
import it.unisa.diem.progetto.rubrica.Contatto;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Test della classe ImportaEsporta.
 */
public class ImportaEsportaTest {

    @Test
    public void testImporta() throws Exception {
        System.out.println("importa");

        File tempFile = File.createTempFile("rubrica_test_importa", ".csv");
        try ( FileWriter writer = new FileWriter(tempFile)) {
            writer.write(",Ernesto,1234567890,,,email1@example.com,,\n");
            writer.write("ProtoleoMarioIV,Di Genova,0987654321,,,email2@example.com,,\n");
            writer.flush();
        }

        ImportaEsporta instance = new ImportaEsporta();
        List<Contatto> result = instance.importa(tempFile.getAbsolutePath());

        List<Contatto> expResult = new ArrayList<>();
        expResult.add(new Contatto("", "Ernesto", "1234567890", "", "", "email1@example.com", null, null));
        expResult.add(new Contatto("ProtoleoMarioIV", "Di Genova    ", "0987654321", "", "", "email2@example.com", null, null));

        assertEquals(expResult.size(), result.size());
        for (int i = 0; i < expResult.size(); i++) {
            Contatto expected = expResult.get(i);
            Contatto actual = result.get(i);

            assertEquals(expected.getCognome(), actual.getCognome());
            assertEquals(expected.getNome(), actual.getNome());
            assertEquals(expected.getNumTelefono1(), actual.getNumTelefono1());
            assertEquals(expected.getNumTelefono2(), actual.getNumTelefono2());
            assertEquals(expected.getNumTelefono3(), actual.getNumTelefono3());
            assertEquals(expected.getEMail1(), actual.getEMail1());
            assertEquals(expected.getEMail2(), actual.getEMail2());
            assertEquals(expected.getEMail3(), actual.getEMail3());

        }

        tempFile.delete();
    }

    @Test
    public void testEsporta() throws Exception {
        System.out.println("esporta");

        List<Contatto> contatti = new ArrayList<>();
        contatti.add(new Contatto("Esposito", "Ciro", "1234567890", "", "", "email1@example.com", null, null));
        contatti.add(new Contatto("Giarletta", "    Orazio", "0987654321", "", "", "email2@example.com", null, null));

        File tempFile = File.createTempFile("rubrica_test_esporta", ".csv");

        ImportaEsporta.esporta(contatti, tempFile.getAbsolutePath());

        ImportaEsporta instance = new ImportaEsporta();
        List<Contatto> result = instance.importa(tempFile.getAbsolutePath());

        assertEquals(contatti.size(), result.size());
        for (int i = 0; i < contatti.size(); i++) {
            Contatto expected = contatti.get(i);
            Contatto actual = result.get(i);

            assertEquals(expected.getCognome(), actual.getCognome());
            assertEquals(expected.getNome(), actual.getNome());
            assertEquals(expected.getNumTelefono1(), actual.getNumTelefono1());
            assertEquals(expected.getNumTelefono2(), actual.getNumTelefono2());
            assertEquals(expected.getNumTelefono3(), actual.getNumTelefono3());
            assertEquals(expected.getEMail1(), actual.getEMail1());
            assertEquals(expected.getEMail2(), actual.getEMail2());
            assertEquals(expected.getEMail3(), actual.getEMail3());

        }

        tempFile.delete();
    }
}
