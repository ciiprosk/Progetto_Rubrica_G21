/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package it.unisa.diem.progetto.gestioneContatti;

import it.unisa.diem.progetto.rubrica.Contatto;
import java.sql.Connection;
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
public class DatabaseTest {
    
    public DatabaseTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of connessione method, of class Database.
     */
    @Test
    public void testConnessione() {
        System.out.println("connessione");
        Database instance = null;
        Connection expResult = null;
        Connection result = instance.connessione();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of aggiungiContatto method, of class Database.
     */
    @Test
    public void testAggiungiContatto() {
        System.out.println("aggiungiContatto");
        Contatto c = null;
        Database instance = null;
        boolean expResult = false;
        boolean result = instance.aggiungiContatto(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificaContatto method, of class Database.
     */
    @Test
    public void testModificaContatto() {
        System.out.println("modificaContatto");
        Contatto c = null;
        Database instance = null;
        boolean expResult = false;
        boolean result = instance.modificaContatto(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminaContatto method, of class Database.
     */
    @Test
    public void testEliminaContatto() {
        System.out.println("eliminaContatto");
        Contatto c = null;
        Database instance = null;
        boolean expResult = false;
        boolean result = instance.eliminaContatto(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminaTuttiIContatti method, of class Database.
     */
    @Test
    public void testEliminaTuttiIContatti() {
        System.out.println("eliminaTuttiIContatti");
        Database instance = null;
        boolean expResult = false;
        boolean result = instance.eliminaTuttiIContatti();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of prelevaContattiCognome method, of class Database.
     */
    @Test
    public void testPrelevaContattiCognome() {
        System.out.println("prelevaContattiCognome");
        Database instance = null;
        List<Contatto> expResult = null;
        List<Contatto> result = instance.prelevaContattiCognome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of recuperaContattoById method, of class Database.
     */
    @Test
    public void testRecuperaContattoById() {
        System.out.println("recuperaContattoById");
        int id = 0;
        Database instance = null;
        Contatto expResult = null;
        Contatto result = instance.recuperaContattoById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of prelevaContattiNome method, of class Database.
     */
    @Test
    public void testPrelevaContattiNome() {
        System.out.println("prelevaContattiNome");
        Database instance = null;
        List<Contatto> expResult = null;
        List<Contatto> result = instance.prelevaContattiNome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of chiudiConnessione method, of class Database.
     */
    @Test
    public void testChiudiConnessione() {
        System.out.println("chiudiConnessione");
        Database instance = null;
        instance.chiudiConnessione();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
