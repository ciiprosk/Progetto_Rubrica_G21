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
public class NumTelefonoValidatorTest {
    private NumTelefonoValidator instance;
    
    public NumTelefonoValidatorTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        instance = new NumTelefonoValidator();
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of verifica method, of class NumTelefonoValidator.
     */
    @Test
    public void testVerifica1() {
        System.out.println("verifica");
        String numTelefono = "";
        
        boolean expResult = true;
        boolean result = instance.verifica(numTelefono);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testVerifica2() {
        System.out.println("verifica");
        String numTelefono = "1";      //non importa quante cifre, ma devono essere presenti solo cifre decimeli 
        
        boolean expResult = true;
        boolean result = instance.verifica(numTelefono);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testVerifica3() {
        System.out.println("verifica");
        String numTelefono = "a";
        
        boolean expResult = false;
        boolean result = instance.verifica(numTelefono);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testVerifica4() {
        System.out.println("verifica");
        String numTelefono = "1a";    
        
        boolean expResult = false;
        boolean result = instance.verifica(numTelefono);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of inserito method, of class NumTelefonoValidator.
     */
    @Test
    public void testInserito1() {
        System.out.println("inserito");
        String numTelefono = "";
        NumTelefonoValidator instance = new NumTelefonoValidator();
        boolean expResult = false;
        boolean result = instance.inserito(numTelefono);
        assertEquals(expResult, result);
       
    }
   
    
    @Test
    public void testInserito2() {
        System.out.println("inserito");
        String numTelefono = "a";
        NumTelefonoValidator instance = new NumTelefonoValidator();
        boolean expResult = true;
        boolean result = instance.inserito(numTelefono);
        assertEquals(expResult, result);
       
    }
    
    
    
}
