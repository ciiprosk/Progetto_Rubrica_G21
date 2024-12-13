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
        System.out.println("verifica email vuota");
        String email = "";
        boolean expResult = true;
        boolean result = instance.verifica(email);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testVerifica2() {
        System.out.println("verifica testo non valido");
        String email = "/";
        boolean expResult = false;
        boolean result = instance.verifica(email);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testVerifica3() {
        System.out.println("verifica testo valido");
        String email = "a@a.aa";
        boolean expResult = true;
        boolean result = instance.verifica(email);
        assertEquals(expResult, result);
    }

    /**
     * Test of inserito method, of class EMailValidator.
     */
    @Test
    public void testInserito1() {
        System.out.println("Verifica testo non inserito");
        String eMail = "";
        boolean expResult = false;
        boolean result = instance.inserito(eMail);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testInserito2() {
        System.out.println("Verifica testo inserito");
        String eMail = "a";
        boolean expResult = true;
        boolean result = instance.inserito(eMail);
        assertEquals(expResult, result);
    }
    
}
