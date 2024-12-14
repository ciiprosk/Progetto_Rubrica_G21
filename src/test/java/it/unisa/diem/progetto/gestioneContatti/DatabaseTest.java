/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package it.unisa.diem.progetto.gestioneContatti;

import it.unisa.diem.progetto.rubrica.Contatto;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

/**
 *
 * @author rosap
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DatabaseTest {

    private Database db;
    private Connection connection;
    //contatti validi cognome
    private Contatto c = new Contatto("Rossi", "Rosa", "", "", "", "", "", "");
    private Contatto c3 = new Contatto("Prova", "Rosa", "123456", "", "", "", "", "");
    
    //contatti non validi
    private Contatto c1 = new Contatto("", "Rosa", "123456", "", "", "", "", "");
    private Contatto c2 = new Contatto("", "", "123456", "", "", "", "", "");
    
    //contatti validi nome
     private Contatto n1 = new Contatto("", "Antonio", "123456", "", "", "", "", "");
     private Contatto n2 = new Contatto("", "Omar", "123456", "", "", "", "", "");
     private Contatto n3 = new Contatto("", "Rosa", "123456", "", "", "", "", "");
    

    public DatabaseTest() {

    }

    @BeforeAll
    public static void setUpClass() {

    }

    @AfterAll
    public static void tearDownClass() {
    }

    //il database viene collegato a un database creato per il test, è un database remoto
    @BeforeEach
    public void setUp() {
        db = new Database("test");
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of connessione method, of class Database.
     */
    @Test
    public void testConnessione() {
        System.out.println("Test connessione");
        connection = db.getConnectionReference();
        assertNotNull(connection);

    }

    /**
     * Test of aggiungiContatto method, of class Database.
     */
    @Test
    @Order(1)
    public void testAggiungiContatto1() {
        System.out.println("Test aggiungiContatto Normale");

        boolean expResult = true;
        boolean result = db.aggiungiContatto(c);
        db.eliminaTuttiIContatti();
        assertEquals(expResult, result);
    }

    /**
     * Test of aggiungiContatto method, of class Database.
     */
    @Test
    @Order(2)
    public void testAggiungiContatto2() {
        System.out.println("Test aggiungiContatto Normale");

        boolean expResult = true;
        boolean result = db.aggiungiContatto(c1);
        db.eliminaTuttiIContatti();
        assertEquals(expResult, result);
    }

    /**
     * Test of aggiungiContatto method, of class Database.
     */
    @Test
    @Order(3)
    public void testAggiungiContatto3() {
        System.out.println("Test aggiungiContatto Normale");

        boolean expResult = false;
        boolean result = db.aggiungiContatto(c2);
        assertEquals(expResult, result);
    }

    /**
     * Test of aggiungiContatto method, of class Database.
     */
    @Test
    public void testAggiungiContatto4() {
        System.out.println("Test aggiungiContatto 1");

        boolean expResult = false;
        boolean result = db.aggiungiContatto(new Contatto("", "", "", "", "", "", "bfew ie@", ""));
        assertEquals(expResult, result);
    }

    @Test
    @Order(5)
    public void testAggiungiContatto5() {
        System.out.println("Test aggiungiContatto Normale");

        boolean expResult = true;
        boolean result = db.aggiungiContatto(c3);
        assertEquals(expResult, result);
    }

    /**
     * Test of eliminaContatto method, of class Database.
     */
    @Test
    public void testEliminaContatto() {
        System.out.println("eliminaContatto");
        Contatto contatto = new Contatto("Rossi", "Rosa", "", "", "", "", "", "");
        db.aggiungiContatto(contatto);
        boolean expResult = true;
        boolean result = db.eliminaContatto(contatto);
        db.eliminaTuttiIContatti();
        assertEquals(expResult, result);

    }

    /**
     * Test of eliminaTuttiIContatti method, of class Database.
     */
    @Test
    public void testEliminaTuttiIContatti() {
        System.out.println("eliminaTuttiIContatti");

        boolean expResult = true;
        boolean result = db.eliminaTuttiIContatti();
        assertEquals(expResult, result);

    }

    /**
     * Test of prelevaContattiCognome method, of class Database.
     */
    @Test
    @Order(5)
    public void testPrelevaContattiCognome() {
        System.out.println("Test prelevaContattiCognome");

        // Preparazione dei dati
        Contatto contatto1 = new Contatto("Bianchi", "Mario", "123456", "", "", "mario.bianchi@example.com", "", "");
        Contatto contatto2 = new Contatto("Rossi", "Anna", "654321", "", "", "anna.rossi@example.com", "", "");

        // Aggiunta dei contatti al database di test
        db.aggiungiContatto(contatto1);
        db.aggiungiContatto(contatto2);

        // Chiamata al metodo da testare
        List<Contatto> result = db.prelevaContattiCognome();

        // Verifica dell'output atteso
        List<Contatto> expected = new ArrayList<>();
        expected.add(contatto1);
        expected.add(contatto2);

        assertEquals(expected, result);

        // Pulizia del database
        db.eliminaTuttiIContatti();
    }

    /**
     * Test of recuperaContattoById method, of class Database.
     */
    @Test
    @Order(6)
    public void testRecuperaContattoById() {
        System.out.println("recuperaContattoById");

        boolean aggiunto = db.aggiungiContatto(c);

        int id = c.getId();

        Contatto result = db.recuperaContattoById(id);

        assertEquals(c, result);
    }

    /**
     * Test of prelevaContattiNome method, of class Database.
     */
    @Test
    @Order(7)
    public void testPrelevaContattiNome() {
        System.out.println("Test prelevaContattiNome");

        // Preparazione dei dati
        Contatto contatto1 = new Contatto("", "Anna", "123456", "", "", "mario.bianchi@example.com", "", "");
        Contatto contatto2 = new Contatto("", "Mario", "654321", "", "", "anna.rossi@example.com", "", "");

        // Aggiunta dei contatti al database di test
        db.aggiungiContatto(contatto1);
        db.aggiungiContatto(contatto2);

        // Chiamata al metodo da testare
        List<Contatto> result = db.prelevaContattiNome();

        // Verifica dell'output atteso
        List<Contatto> expected = new ArrayList<>();
        expected.add(contatto1);
        expected.add(contatto2);

        assertEquals(expected, result);

        // Pulizia del database
        db.eliminaTuttiIContatti();
    }

    /**
     * Test of chiudiConnessione method, of class Database.
     */
    @Test
    public void testChiudiConnessione() {
        System.out.println("chiudiConnessione");

        db.chiudiConnessione();

    }

}
