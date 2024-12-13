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
 * @author Utente
 */
public class NomeCognomeValidatorTest {
    private NomeCognomeValidator instance;
    
    public NomeCognomeValidatorTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        instance = new NomeCognomeValidator();
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of verifica method, of class NomeCognomeValidator.
     */
    @Test
    public void testVerifica1() {
        
        System.out.println("verifica");
        String dato = "";
        
        boolean expResult = true;
        boolean result = instance.verifica(dato);
        assertEquals(expResult, result);

    }
    
    @Test
    public void testVerifica2() {
        
        System.out.println("verifica");
        String dato = "a";
        
        boolean expResult = true;
        boolean result = instance.verifica(dato);
        assertEquals(expResult, result);

    }
    
    @Test
    public void testVerifica3() {
        
        System.out.println("verifica");
        String dato = "_";
        
        boolean expResult = false;
        boolean result = instance.verifica(dato);
        assertEquals(expResult, result);

    }

    /**
     * Test of inserito method, of class NomeCognomeValidator.
     */
    @Test
    public void testInserito1() {
        System.out.println("inserito");
        String dato = "";

        boolean expResult = false;
        boolean result = instance.inserito(dato);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testInserito2() {
        System.out.println("inserito");
        String dato = "a";

        boolean expResult = true;
        boolean result = instance.inserito(dato);
        assertEquals(expResult, result);
        
    }
    
}


