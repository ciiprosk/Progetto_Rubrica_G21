/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package it.unisa.diem.progetto.gestioneContatti;

import it.unisa.diem.progetto.rubrica.Contatto;
import java.sql.Connection;
import java.sql.SQLException;
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
public class DatabaseCopiaTest {
        
    DatabaseCopia instance;  // Classe da testare
    Connection connection;   // Connessione da verificare
        
    @BeforeEach
    public void setUp() {
        instance = new DatabaseCopia("test"); // Inizializza l'oggetto DatabaseCopia
    }

    @Test
    public void testConnessione() {
        System.out.println("Verifica connessione al database");

        connection=instance.getConnectionReference();
        assertNotNull(connection);
    }



    /**
     * Test of aggiungiContatto method, of class DatabaseCopia.
     */
    @Test
    public void testAggiungiContatto1() {
        System.out.println("aggiungiContatto");
        
        boolean expResult = true;
        boolean result = instance.aggiungiContatto(new Contatto("nome", "cognome", "","", "", "", "", ""));
        assertEquals(expResult, result);
        
    }
    @Test
    public void testAggiungiContatto2() {
        System.out.println("aggiungiContatto");
        
        boolean expResult = false;
        boolean result = instance.aggiungiContatto(new Contatto("", " ", "","", "", "", "", ""));
        assertEquals(expResult, result);
        
    }

    /**
     * Test of modificaContatto method, of class DatabaseCopia.
     */
    @Test
    public void testModificaContatto() {
        System.out.println("modificaContatto");
        Contatto c = null;
    
        boolean expResult = false;
        boolean result = instance.modificaContatto(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminaContatto method, of class DatabaseCopia.
     */
    @Test
    public void testEliminaContatto() {
        System.out.println("eliminaContatto");
        Contatto c = null;

        boolean expResult = false;
        boolean result = instance.eliminaContatto(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminaTuttiIContatti method, of class DatabaseCopia.
     */
    @Test
    public void testEliminaTuttiIContatti() {
        System.out.println("eliminaTuttiIContatti");
   
        boolean expResult = false;
        boolean result = instance.eliminaTuttiIContatti();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of prelevaContattiCognome method, of class DatabaseCopia.
     */
    @Test
    public void testPrelevaContattiCognome() {
        System.out.println("prelevaContattiCognome");

        List<Contatto> expResult = null;
        List<Contatto> result = instance.prelevaContattiCognome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of recuperaContattoById method, of class DatabaseCopia.
     */
    @Test
    public void testRecuperaContattoById() {
        System.out.println("recuperaContattoById");
        int id = 0;
   
        Contatto expResult = null;
        Contatto result = instance.recuperaContattoById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of prelevaContattiNome method, of class DatabaseCopia.
     */
    @Test
    public void testPrelevaContattiNome() {
        System.out.println("prelevaContattiNome");

        List<Contatto> expResult = null;
        List<Contatto> result = instance.prelevaContattiNome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of chiudiConnessione method, of class DatabaseCopia.
     */
    @Test
    public void testChiudiConnessione() {
        System.out.println("chiudiConnessione");
  
        instance.chiudiConnessione();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
