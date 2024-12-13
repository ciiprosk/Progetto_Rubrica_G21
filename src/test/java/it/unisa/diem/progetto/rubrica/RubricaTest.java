/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package it.unisa.diem.progetto.rubrica;

import it.unisa.diem.progetto.gestioneContatti.Database;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author rosap
 */
public class RubricaTest {

    Rubrica instance;
    private Contatto c = new Contatto("Rossi", "Rosa", "", "", "", "", "", "");
    private Contatto c1 = new Contatto("", "Rosa", "123456", "", "", "", "", "");

    private Contatto c2 = new Contatto("", "", "123456", "", "", "", "", "");
    private Contatto c3 = new Contatto("Prova", "Rosa", "123456", "", "", "", "", "");

    private Contatto c4 = new Contatto("Prova", "Rosa", "123456", "rosa@gmail", "", "", "", "");

    public RubricaTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        instance = new Rubrica(new Database("test"));
    }

    @AfterEach
    public void tearDown() {
        Rubrica.chiudiRubrica();
    }

    /**
     * Test of aggiungiContatto method, of class Rubrica.
     */
    @Test
    public void testAggiungiContatto1() {
        System.out.println("aggiungiContatto");

        boolean expResult = true;
        boolean result = instance.aggiungiContatto(c);
        instance.eliminaTuttiContatti();
        assertEquals(expResult, result);

    }

    @Test
    public void testAggiungiContatto2() {
        System.out.println("aggiungiContatto");

        boolean expResult = true;
        boolean result = instance.aggiungiContatto(c1);
        instance.eliminaTuttiContatti();
        assertEquals(expResult, result);

    }

    @Test
    public void testAggiungiContatto3() {
        System.out.println("aggiungiContatto");

        boolean expResult = false;
        boolean result = instance.aggiungiContatto(c2);
        instance.eliminaTuttiContatti();
        assertEquals(expResult, result);

    }

    @Test
    public void testAggiungiContatto4() {
        System.out.println("aggiungiContatto");

        boolean expResult = true;
        boolean result = instance.aggiungiContatto(c3);
        instance.eliminaTuttiContatti();
        assertEquals(expResult, result);
    }

    @Test
    public void testAggiungiContatto5() {
        System.out.println("aggiungiContatto");

        boolean expResult = false;
        boolean result = instance.aggiungiContatto(c4);
        instance.eliminaTuttiContatti();
        assertEquals(expResult, result);
    }

    /**
     * Test of getContattoById method, of class Rubrica.
     */
    @Test
    public void testGetContattoById1() {
        System.out.println("getContattoById");
        instance.aggiungiContatto(c);
        int id = c.getId();
        Contatto expResult = c;
        Contatto result = instance.getContattoById(id);
        instance.eliminaTuttiContatti();
        assertEquals(expResult, result);

    }

    /**
     * Test of getContattoById method, of class Rubrica.
     */
    @Test
    public void testGetContattoById2() {
        System.out.println("getContattoById");
        instance.aggiungiContatto(c1);
        int id = c1.getId();
        Contatto expResult = c1;
        Contatto result = instance.getContattoById(id);
        instance.eliminaTuttiContatti();
        assertEquals(expResult, result);

    }

    /**
     * Test of getContattoById method, of class Rubrica.
     */
    @Test
    public void testGetContattoById3() {
        System.out.println("getContattoById");
        instance.aggiungiContatto(c2);
        int id = c2.getId();
        Contatto expResult = null;
        Contatto result = instance.getContattoById(id);
        instance.eliminaTuttiContatti();
        assertEquals(expResult, result);
    }

    /**
     * Test of eliminaContatto method, of class Rubrica.
     */
    @Test
    public void testEliminaContatto1() {
        System.out.println("eliminaContatto");
        instance.aggiungiContatto(c);
        boolean expResult = true;
        boolean result = instance.eliminaContatto(c);

        assertEquals(expResult, result);
    }

    /**
     * Test of eliminaContatto method, of class Rubrica.
     */
    @Test
    public void testEliminaContatto2() {
        System.out.println("eliminaContatto");
        instance.aggiungiContatto(c1);
        boolean expResult = true;
        boolean result = instance.eliminaContatto(c1);

        assertEquals(expResult, result);
    }

    /**
     * Test of eliminaContatto method, of class Rubrica.
     */
    @Test
    public void testEliminaContatto3() {
        System.out.println("eliminaContatto");
        instance.aggiungiContatto(c2);
        boolean expResult = false;
        boolean result = instance.eliminaContatto(c2);

        assertEquals(expResult, result);
    }

    /**
     * Test of ricercaContatto method, of class Rubrica.
     */
    @Test
    public void testRicercaContatto() {
        System.out.println("ricercaContatto");

        instance.aggiungiContatto(new Contatto("Rossi", "Mario", "1234567890", null, null, null, null, null));
        instance.aggiungiContatto(new Contatto("Bianchi", "Luigi", "0987654321", null, null, null, null, null));
        instance.aggiungiContatto(new Contatto("Verdi", "Giulia", "1122334455", null, null, null, null, null));

        // Test: Ricerca per cognome
        List<Contatto> result = instance.ricercaContatto("Rossi");
        assertEquals(1, result.size());
        assertEquals("Rossi", result.get(0).getCognome());

        // Test: Ricerca per nome
        result = instance.ricercaContatto("Luigi");
        assertEquals(1, result.size());
        assertEquals("Luigi", result.get(0).getNome());

        // Test: Ricerca per cognome + nome
        result = instance.ricercaContatto("Giulia Verdi");
        assertEquals(1, result.size());
        assertEquals("Verdi", result.get(0).getCognome());
        assertEquals("Giulia", result.get(0).getNome());

        // Test: Ricerca con nessun risultato
        result = instance.ricercaContatto("NonEsistente");
        instance.eliminaTuttiContatti();

        assertTrue(result.isEmpty());
    }

    /**
     * Test of eliminaTuttiContatti method, of class Rubrica.
     */
    @Test
    public void testEliminaTuttiContatti1() {
        System.out.println("eliminaTuttiContatti");
        instance.aggiungiContatto(c);
        instance.aggiungiContatto(c1);

        boolean expResult = true;

        boolean result = instance.eliminaTuttiContatti();
        assertEquals(expResult, result);

    }

    /**
     * Test of esisteDuplicato method, of class Rubrica.
     */
    @Test
    public void testEsisteDuplicato() {
        System.out.println("////////////////esisteDuplicato//////////////////////");

        instance.aggiungiContatto(new Contatto("Rossi", "Mario", "1234567890", null, null, null, null, null));
        instance.aggiungiContatto(new Contatto("Bianchi", "Luigi", "0987654321", null, null, null, null, null));

        // Test: Contatto duplicato
        List<Contatto> result = instance.esisteDuplicato("Rossi", "Mario");
        assertEquals(1, result.size());
        assertEquals("Rossi", result.get(0).getCognome());
        assertEquals("Mario", result.get(0).getNome());

        // Test: Contatto non presente
        result = instance.esisteDuplicato("Verdi", "Giovanni");
        assertTrue(result.isEmpty());
    }

    /**
     * Test of eliminaTuttiContatti method, of class Rubrica.
     */
    @Test
    public void testEliminaTuttiContatti2() {
        System.out.println("eliminaTuttiContatti");

        boolean expResult = false; //non ci sono elementi da cancellare

        boolean result = instance.eliminaTuttiContatti();
        assertEquals(expResult, result);

    }

    /**
     * Test of visualizzaListaContattiCognome method, of class Rubrica.
     */
    @Test
    public void testVisualizzaListaContattiCognome_0args() {
        System.out.println("///////////////////visualizzaListaContattiCognome_0arg////////////////////////");
        instance.eliminaTuttiContatti();

        
        instance.aggiungiContatto(c);
        instance.aggiungiContatto(c1);
        instance.aggiungiContatto(c3);
        instance.aggiungiContatto(c4);

        List<Contatto> result = instance.visualizzaListaContattiCognome();
                System.out.println(result);


        assertEquals(3, result.size());
        assertEquals("Prova", result.get(0).getCognome());
        assertEquals("Prova", result.get(1).getCognome());
        assertEquals("Rossi", result.get(2).getCognome());

        instance.eliminaTuttiContatti();
    }

    /**
     * Test of visualizzaListaContattiNome method, of class Rubrica.
     */
    @Test
    public void testVisualizzaListaContattiNome_0args() {
        System.out.println("///////////////////visualizzaListaContattiNome_0arg////////////////////////");
        instance.eliminaTuttiContatti();

        
        instance.aggiungiContatto(c);
        instance.aggiungiContatto(c1);
        instance.aggiungiContatto(c3);
        instance.aggiungiContatto(c4);

        List<Contatto> result = instance.visualizzaListaContattiCognome();
        System.out.println(result);
        
        assertEquals(1, result.size());
        assertEquals("", result.get(0).getCognome());
        assertEquals("Rosa", result.get(0).getNome());

        instance.eliminaTuttiContatti();
    }

    /**
     * Test of verificaContattiDaFile method, of class Rubrica.
     */
    @Test
    public void testVerificaContattiDaFile() throws Exception {
        System.out.println("verificaContattiDaFile");

        File tempFile = File.createTempFile("rubrica_verifica_test", ".csv");
        try ( FileWriter writer = new FileWriter(tempFile)) {
            writer.write("Rossi,Mario,1234567890,,,email1@example.com,email2@example.com,email3@example.com\n");
            writer.write("Bianchi,Luigi,0987654321,,,email4@example.com,email5@example.com,email6@example.com\n");
            writer.flush();
        }

        List<Contatto> result = instance.verificaContattiDaFile(tempFile);

        assertEquals(2, result.size());
        assertEquals("Rossi", result.get(0).getCognome());
        assertEquals("Mario", result.get(0).getNome());
        assertEquals("Bianchi", result.get(1).getCognome());
        assertEquals("Luigi", result.get(1).getNome());

        instance.eliminaTuttiContatti();
        tempFile.delete();
    }

    /**
     * Test of importaContatti method, of class Rubrica.
     */
    @Test
    public void testImportaContatti() throws Exception {
        System.out.println("importaContatti");

        File tempFile = File.createTempFile("rubrica_test", ".csv");
        try ( FileWriter writer = new FileWriter(tempFile)) {
            writer.write("Rossi,Rosa,,,,\n");
            writer.write(",Rosa,123456,,,\n");
            writer.flush();
        }

        List<Contatto> expResult = new ArrayList<>();
        expResult.add(c);
        expResult.add(c1);

        List<Contatto> result = instance.importaContatti(tempFile);
        assertEquals(expResult, result);

        tempFile.delete();
        instance.eliminaTuttiContatti();
    }

    /**
     * Test of esportaContatti method, of class Rubrica.
     */
    @Test
    public void testEsportaContatti() throws Exception {
        System.out.println("////////////////esportaContatti//////////////////////");

        instance.aggiungiContatto(c1);
        instance.aggiungiContatto(c);

        File tempFile = File.createTempFile("rubrica_export_test", ".csv");

        boolean result = instance.esportaContatti(tempFile);

        assertTrue(result);

        try ( BufferedReader reader = new BufferedReader(new FileReader(tempFile))) {
            assertEquals("Rossi,Rosa,,,,,,", reader.readLine());
            assertEquals(",Rosa,123456,,,,,", reader.readLine());
            assertNull(reader.readLine());
        }

        tempFile.delete();
        instance.eliminaTuttiContatti();
    }

    /**
     * Test of chiudiRubrica method, of class Rubrica.
     */
    @Test
    public void testChiudiRubrica() {
        System.out.println("chiudiRubrica");
        Rubrica.chiudiRubrica();

    }

}
