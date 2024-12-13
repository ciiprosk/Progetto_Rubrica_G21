/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package it.unisa.diem.progetto.validazioneContatti;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author anton
 */
public class EMailValidatorTest {
    EMailValidator instance;
    public EMailValidatorTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
         instance = new EMailValidator();
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of verifica method, of class EMailValidator.
     */
    @Test
    public void testVerifica1() {
        System.out.println("verifica");
        String email = "";
        EMailValidator instance = new EMailValidator();
        boolean expResult = false;
        boolean result = instance.verifica(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of inserito method, of class EMailValidator.
     */
    @Test
    public void testInserito() {
        System.out.println("inserito");
        String eMail = "";
        EMailValidator instance = new EMailValidator();
        boolean expResult = false;
        boolean result = instance.inserito(eMail);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
