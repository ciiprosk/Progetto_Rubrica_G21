/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package it.unisa.diem.progetto.rubrica;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContattoTest {

    private Contatto instance;

    @BeforeEach
    public void setUp() {
        instance = new Contatto("Rossi", "Mario", "123", "456", "789", "email1@example.com", "email2@example.com", "email3@example.com");
    }

    @Test
    public void testSetAndGetNome() {
        System.out.println("setNome & getNome");
        String nuovoNome = "Luigi";
        instance.setNome(nuovoNome);
        assertEquals(nuovoNome, instance.getNome());
    }

    @Test
    public void testSetAndGetCognome() {
        System.out.println("setCognome & getCognome");
        String nuovoCognome = "Verdi";
        instance.setCognome(nuovoCognome);
        assertEquals(nuovoCognome, instance.getCognome());
    }

    @Test
    public void testSetAndGetTelefono1() {
        System.out.println("setTelefono1 & getTelefono1");
        String nuovoTelefono1 = "987654321";
        instance.setTelefono1(nuovoTelefono1);
        assertEquals(nuovoTelefono1, instance.getNumTelefono1(), "Il telefono1 non è stato impostato correttamente.");
    }

    @Test
    public void testSetAndGetTelefono2() {
        System.out.println("setTelefono2 & getTelefono2");
        String nuovoTelefono2 = "654321987";
        instance.setTelefono2(nuovoTelefono2);
        assertEquals(nuovoTelefono2, instance.getNumTelefono2(), "Il telefono2 non è stato impostato correttamente.");
    }

    @Test
    public void testSetAndGetTelefono3() {
        System.out.println("setTelefono3 & getTelefono3");
        String nuovoTelefono3 = "321987654";
        instance.setTelefono3(nuovoTelefono3);
        assertEquals(nuovoTelefono3, instance.getNumTelefono3(), "Il telefono3 non è stato impostato correttamente.");
    }

    @Test
    public void testSetAndGetEmail1() {
        System.out.println("setEmail1 & getEmail1");
        String nuovaEmail1 = "nuovaEmail1@example.com";
        instance.setEMail1(nuovaEmail1);
        assertEquals(nuovaEmail1, instance.getEMail1());
    }

    @Test
    public void testSetAndGetEmail2() {
        System.out.println("setEmail2 & getEmail2");
        String nuovaEmail2 = "nuovaEmail2@example.com";
        instance.setEMail2(nuovaEmail2);
        assertEquals(nuovaEmail2, instance.getEMail2());
    }

    @Test
    public void testSetAndGetEmail3() {
        System.out.println("setEmail3 & getEmail3");
        String nuovaEmail3 = "nuovaEmail3@example.com";
        instance.setEMail3(nuovaEmail3);
        assertEquals(nuovaEmail3, instance.getEMail3());
    }

    @Test
    public void testEquals() {
        System.out.println("equals");
        Contatto instance2 = new Contatto("Rossi", "Mario", "123", "456", "789", "email1@example.com", "email2@example.com", "email3@example.com");
        Contatto instance3 = new Contatto("Bianchi", "Luigi", "987", "654", "321", "email4@example.com", "email5@example.com", "email6@example.com");

        assertTrue(instance.equals(instance2));
        assertFalse(instance.equals(instance3));
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        String expected = "Nome: Mario\n"
                        + "Cognome: Rossi\n"
                        + "Telefono 1: 123\n"
                        + "Telefono 2: 456\n"
                        + "Telefono 3: 789\n"
                        + "E-mail1: email1@example.com\n"
                        + "E-mail2: email2@example.com\n"
                        + "E-mail3: email3@example.com\n\n";

        assertEquals(expected, instance.toString(), "La rappresentazione in stringa non è corretta.");
    }
}

