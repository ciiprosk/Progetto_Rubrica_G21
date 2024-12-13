/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package it.unisa.diem.progetto.rubrica;

import it.unisa.diem.progetto.gestioneContatti.Database;
import java.io.File;
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
    private Contatto  c=new Contatto("Rossi", "Rosa", "", "", "", "", "", "");
    private Contatto c1=new Contatto("", "Rosa", "123456", "", "", "", "", "");
    
    private Contatto c2=new Contatto("", "", "123456", "", "", "", "", "");
    private Contatto c3=new Contatto("Prova", "Rosa", "123456", "", "", "", "", "");
    
    private Contatto c4=new Contatto("Prova", "Rosa", "123456", "rosa@gmail", "", "", "", "");
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
        instance=new Rubrica(new Database("test"));
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
        int id=c.getId();
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
        int id=c1.getId();
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
        int id=c2.getId();
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
        String cognomeNome = "";
        Rubrica instance = null;
        List<Contatto> expResult = null;
        List<Contatto> result = instance.ricercaContatto(cognomeNome);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of esisteDuplicato method, of class Rubrica.
     */
    @Test
    public void testEsisteDuplicato() {
        System.out.println("esisteDuplicato");
        String cognome = "";
        String nome = "";
        Rubrica instance = null;
        List<Contatto> expResult = null;
        List<Contatto> result = instance.esisteDuplicato(cognome, nome);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        System.out.println("visualizzaListaContattiCognome");
        Rubrica instance = null;
        List<Contatto> expResult = null;
        List<Contatto> result = instance.visualizzaListaContattiCognome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of visualizzaListaContattiNome method, of class Rubrica.
     */
    @Test
    public void testVisualizzaListaContattiNome_0args() {
        System.out.println("visualizzaListaContattiNome");
        Rubrica instance = null;
        List<Contatto> expResult = null;
        List<Contatto> result = instance.visualizzaListaContattiNome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of visualizzaListaContattiCognome method, of class Rubrica.
     */
    @Test
    public void testVisualizzaListaContattiCognome_List() {
        System.out.println("visualizzaListaContattiCognome");
        List<Contatto> cognomi = null;
        Rubrica instance = null;
        List<Contatto> expResult = null;
        List<Contatto> result = instance.visualizzaListaContattiCognome(cognomi);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of visualizzaListaContattiNome method, of class Rubrica.
     */
    @Test
    public void testVisualizzaListaContattiNome_List() {
        System.out.println("visualizzaListaContattiNome");
        List<Contatto> nomi = null;
        Rubrica instance = null;
        List<Contatto> expResult = null;
        List<Contatto> result = instance.visualizzaListaContattiNome(nomi);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verificaContattiDaFile method, of class Rubrica.
     */
    @Test
    public void testVerificaContattiDaFile() throws Exception {
        System.out.println("verificaContattiDaFile");
        File file = null;
        Rubrica instance = null;
        List<Contatto> expResult = null;
        List<Contatto> result = instance.verificaContattiDaFile(file);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of importaContatti method, of class Rubrica.
     */
    @Test
    public void testImportaContatti() throws Exception {
        System.out.println("importaContatti");
        File file = null;
        Rubrica instance = null;
        List<Contatto> expResult = null;
        List<Contatto> result = instance.importaContatti(file);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of esportaContatti method, of class Rubrica.
     */
    @Test
    public void testEsportaContatti() throws Exception {
        System.out.println("esportaContatti");
        File file = null;
        Rubrica instance = null;
        boolean expResult = false;
        boolean result = instance.esportaContatti(file);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
