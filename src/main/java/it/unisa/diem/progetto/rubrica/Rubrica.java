package it.unisa.diem.progetto.rubrica;

import it.unisa.diem.oop.exception.InvalidContactException;
import it.unisa.diem.progetto.gestioneContatti.DatabaseManager;
import it.unisa.diem.progetto.gestioneContatti.ImportaEsporta;
import it.unisa.diem.progetto.validazioneContatti.EMailValidator;
import it.unisa.diem.progetto.validazioneContatti.NomeCognomeValidator;
import it.unisa.diem.progetto.validazioneContatti.NumTelefonoValidator;
import it.unisa.diem.progetto.validazioneContatti.Validator;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import java.util.List;

/**
 * @brief La classe contiene tutti gli attributi e i metodi per gestire la
 * rubrica.
 */
public class Rubrica {

    private List<Contatto> rubricaCognome;
    private List<Contatto> rubricaNome;
    private static DatabaseManager db;

    public Rubrica(DatabaseManager db) {
        this.db = db;
        rubricaCognome = new ArrayList<>();
        rubricaNome = new ArrayList<>();
    }

    private void aggiornaListaCognome() {
        rubricaCognome = db.prelevaContattiCognome();
    }

    private void aggiornaListaNome() {
        rubricaNome = db.prelevaContattiNome();

    }
     public boolean verificaInput(Contatto c) {
        Validator nomeVal = new NomeCognomeValidator();
        Validator cognomeVal = new NomeCognomeValidator();
        Validator numTelefonoVal = new NumTelefonoValidator();
        Validator emailVal = new EMailValidator();

        return !(nomeVal.verifica(c.getNome()) && cognomeVal.verifica(c.getCognome())
                && !(c.getNome().trim().isEmpty() && c.getCognome().trim().isEmpty()) 
                && (numTelefonoVal.verifica(c.getNumTelefono1())) && (numTelefonoVal.verifica(c.getNumTelefono2())) && (numTelefonoVal.verifica(c.getNumTelefono3()))
                && (emailVal.verifica(c.getEMail1()) && (emailVal.verifica(c.getEMail1()) && (emailVal.verifica(c.getEMail1())))));
                

    }

    /**
     * @brief Il metodo aggiuge un contatto in rubrica
     *
     * @param[in] c Contatto da aggiungere alla rubrica
     * @return boolean: true il contatto è aggiunto correttamente, false
     * altrimenti
     */
    
    public boolean aggiungiContatto(Contatto c) {
        if(verificaInput(c)) return false;
        if (!db.aggiungiContatto(c)) {
            return false;
        }

        if (c.getCognome() != null) {
            aggiornaListaCognome();
        } else {
            aggiornaListaNome();
        }

        return true;

    }

    public Contatto getContattoById(int id) {
        return db.recuperaContattoById(id);
    }


    /**
     * @brief Il metodo modifica un contatto in rubrica .
     *
     * @pre Il contatto esiste.
     * @post Il contatto è correttamente eliminato.
     *
     * @param[in] c Contatto da eliminare dalla rubrica.
     * @return boolean: true il contatto è eliminato correttamente, false
     * altrimenti.
     */
    public boolean eliminaContatto(Contatto c) {
        if (!db.eliminaContatto(c)) {
            System.out.println("non eliminato");
            return false;
        }

        if (c.getCognome() != null) {
            aggiornaListaCognome();
        } else {
            aggiornaListaNome();
        }

        return true;
    }

    /**
     * @brief Il metodo cerca un contatto in rubrica .
     *
     * @pre Il contatto esiste.
     *
     * @param[in] cognomeNome Sottostringa del nome/cognome del contatto da
     * cecare.
     * @return
     */
    public List<Contatto> ricercaContatto(String cognomeNome) {
        List<Contatto> contattiFiltrati = new ArrayList<>();
        aggiornaListaCognome();
        aggiornaListaNome();

        String inputInsensitive = cognomeNome.toLowerCase();
        inputInsensitive = inputInsensitive.trim();

        for (Contatto c : rubricaCognome) {
            String cognomeLower = c.getCognome().toLowerCase();
            String nomeLower = c.getNome().toLowerCase();
            String cognomeNomeConcatenato = (c.getCognome() + " " + c.getNome()).toLowerCase();
            String nomeCognomeConcatenato = (c.getNome() + " " + c.getCognome()).toLowerCase();

            if (cognomeLower.startsWith(inputInsensitive)
                    || nomeLower.startsWith(inputInsensitive)
                    || cognomeNomeConcatenato.startsWith(inputInsensitive)
                    || nomeCognomeConcatenato.startsWith(inputInsensitive)) {
                contattiFiltrati.add(c);
            }
        }

        for (Contatto c : rubricaNome) {
            String nomeLower = c.getNome().toLowerCase();
            if (nomeLower.startsWith(inputInsensitive)) {
                contattiFiltrati.add(c);
            }
        }

        return contattiFiltrati;
    }

    public List<Contatto> esisteDuplicato(String cognome, String nome) {
        List<Contatto> contattiFiltrati = new ArrayList<>();
        aggiornaListaCognome();

        String cognomeInsensitive = cognome.toLowerCase().trim();
        String nomeInsensitive = nome.toLowerCase().trim();

        for (Contatto c : rubricaCognome) {
            String cognomeLower = c.getCognome().toLowerCase().trim();
            String nomeLower = c.getNome().toLowerCase().trim();

            if (cognomeLower.equals(cognomeInsensitive) && nomeLower.equals(nomeInsensitive)) {
                contattiFiltrati.add(c);
            }
        }

        return contattiFiltrati;
    }


    /**
     * @brief Il metodo cancella tutti icontatti presenti in rubrica.
     *
     * @pre La rubrica non è vuota.
     * @post La rubrica è correttamente modificata.
     *
     * @return boolean: true I contatti sono stati eliminati, false altrimenti.
     */
    public boolean eliminaTuttiContatti() {

    aggiornaListaCognome();
    aggiornaListaNome();


    if ((rubricaCognome == null || rubricaCognome.isEmpty()) && 
        (rubricaNome == null || rubricaNome.isEmpty())) {

        System.out.println("La rubrica è già vuota.");
        return false;
    }

    // Se non sono vuote, procedi con l'eliminazione
    return db.eliminaTuttiIContatti();
}

    public List<Contatto> visualizzaListaContattiCognome() {
        return rubricaCognome = db.prelevaContattiCognome();
    }

    public List<Contatto> visualizzaListaContattiNome() {
        return rubricaNome = db.prelevaContattiNome();
    }

    public List<Contatto> visualizzaListaContattiCognome(List<Contatto> cognomi) {
        return cognomi;
    }

    public List<Contatto> visualizzaListaContattiNome(List<Contatto> nomi) {
        return nomi;
    }

    public List<Contatto> verificaContattiDaFile(File file) throws IOException, InvalidContactException {
        ImportaEsporta ie = new ImportaEsporta();

        List<Contatto> contattiImportati = ie.importa(file.getAbsolutePath());
        NomeCognomeValidator nomeCognomeValidator = new NomeCognomeValidator();
        EMailValidator emailValidator = new EMailValidator();
        NumTelefonoValidator numeroTelefonoValidator = new NumTelefonoValidator();

        for (Contatto c : contattiImportati) {
            if (!nomeCognomeValidator.verifica(c.getNome())
                    || !nomeCognomeValidator.verifica(c.getCognome())
                    || !emailValidator.verifica(c.getEMail1())
                    || !emailValidator.verifica(c.getEMail2())
                    || !emailValidator.verifica(c.getEMail3())
                    || !numeroTelefonoValidator.verifica(c.getNumTelefono1())
                    || !numeroTelefonoValidator.verifica(c.getNumTelefono2())
                    || !numeroTelefonoValidator.verifica(c.getNumTelefono3())) {
                throw new InvalidContactException("Il file contiene dati non validi.");
            }
        }

        return contattiImportati;
    }

    /**
     * @brief Il metodo importa tutti i contatti presenti su un file in rubrica.
     *
     * @post I contatti sono salvati in rubrica.
     *
     * @return .
     */
    public List<Contatto> importaContatti(File file) throws IOException {
        ImportaEsporta ie = new ImportaEsporta();
        return ie.importa(file.getAbsolutePath());
    }

    /**
     * @brief Il metodo esporta tutti i contatti presenti in rubrica da un file.
     *
     * @pre La rubrica non è vuota.
     * @post I contatti sono stati esportati.
     *
     * @return boolean: true i contatti sono stati correttamente esportati,
     * false altrimenti.
     */
    public boolean esportaContatti(File file) throws IOException {
        List<Contatto> lista1 = db.prelevaContattiCognome();
        List<Contatto> lista2 = db.prelevaContattiNome();

        List<Contatto> listaDaEsportare = new ArrayList<>();
        listaDaEsportare.addAll(lista1);
        listaDaEsportare.addAll(lista2);

        ImportaEsporta ie = new ImportaEsporta();
        ie.esporta(listaDaEsportare, file.getAbsolutePath());
        return true;
    }

    /**
     * @brief Il metodo chiude la rubrica richiamando il metodo di chiususra
     * della connessione dell'interfaccia DatabaseManager
     */
    public static void chiudiRubrica() {
        db.chiudiConnessione();
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        aggiornaListaCognome();
        aggiornaListaNome();
        List<Contatto> list = new ArrayList<>();
        list.addAll(rubricaCognome);
        list.addAll(rubricaNome);
        for (Contatto c : list) {
            str.append(c);
        }
        return str.toString();
    }

}
