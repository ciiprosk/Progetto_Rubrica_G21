package it.unisa.diem.progetto.gestioneContatti;

import it.unisa.diem.progetto.rubrica.Contatto;
import it.unisa.diem.progetto.validazioneContatti.EMailValidator;
import it.unisa.diem.progetto.validazioneContatti.NomeCognomeValidator;
import it.unisa.diem.progetto.validazioneContatti.NumTelefonoValidator;
import it.unisa.diem.progetto.validazioneContatti.Validator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @brief La classe prevede tutte le operazioni che devono essere effettuate sul
 * database. La classe non prevede alcun metodo che modifichi direttamente il
 * contatto ma sfrutta i metodii di eliminazione e inserimento.
 *
 */
public final class Database implements DatabaseManager {

    private final String URL = "jdbc:postgresql://database-1.czikiq82wrwk.eu-west-2.rds.amazonaws.com:5432/postgres";

    private final String table_name;

    private String username = "postgres";
    private String password = "Farinotta01_";

    private String usernameLocale = "postgres";
    private String passwordLocale = "Farinotta01_";
    private Connection connection = null;

    private final String URLLocale = "jdbc:postgresql://localhost:5432/postgres";

    public Database(String table_name) {
        //appena viene chiamato si apre la connessione
        this.table_name = table_name;
        connessione();

    }

    /**
     * @return @brief Il metodo ritorna un riferimento alla connessione, se si è
     * connessi a Internet si connetterà a un database remoto altrienti
     * bisognerà configurare un database locale con delle credenziali mostrate
     * poi nel file README di github.
     *
     */
    @Override
    public Connection connessione() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, username, password);
            }
            System.out.println("connessione riuscita");
        } catch (SQLException e) {
            System.err.println("Connesione al fallita al database remoto");
            try {
                if (connection == null || connection.isClosed()) {
                    connection = DriverManager.getConnection(URLLocale, usernameLocale, passwordLocale);
                }
            } catch (SQLException ex) {
                System.err.println("fallita la connessione al database locale");
            }
        }

        return connection;
    }

    /**
     *
     * @brief Il metodo preleva la stringa di connessione al database,
     * utilizzato per i casi di test.
     * @return La stringa di connessione.
     */
    public Connection getConnectionReference() {
        return connection;
    }

    /**
     * @brief Il metodo verifica che i dati inseriti in input siano corretti
     * @param c E' il contatto passato alla funzione
     * @return boolean Ritorna false se almeno una delle condizioni risulta non
     * soddisfatta, altrimenti true
     */
    private boolean verificaInput(Contatto c) {
        Validator nomeVal = new NomeCognomeValidator();
        Validator cognomeVal = new NomeCognomeValidator();
        Validator numTelefonoVal = new NumTelefonoValidator();
        Validator emailVal = new EMailValidator();

        boolean nomeValido = nomeVal.verifica(c.getNome());
        boolean cognomeValido = cognomeVal.verifica(c.getCognome());
        boolean nomeCognomeNonVuoti = !(c.getNome().trim().isEmpty() && c.getCognome().trim().isEmpty());

        boolean telefono1Valido = numTelefonoVal.verifica(c.getNumTelefono1());
        boolean telefono2Valido = numTelefonoVal.verifica(c.getNumTelefono2());
        boolean telefono3Valido = numTelefonoVal.verifica(c.getNumTelefono3());

        boolean email1Valida = emailVal.verifica(c.getEMail1());
        boolean email2Valida = emailVal.verifica(c.getEMail2());
        boolean email3Valida = emailVal.verifica(c.getEMail3());

        return (nomeValido && cognomeValido && nomeCognomeNonVuoti
                && telefono1Valido && telefono2Valido && telefono3Valido
                && email1Valida && email2Valida && email3Valida);

    }

    /**
     *
     * @brief Il metodo aggiunge un nuovo contatto nel database.
     *
     * @pre La connessione al database è avvenuta con successo.
     * @post Il contatto è stato aggiunto come nuova riga nella tabella del
     * database.
     * @param c
     * @return boolean: true se il contatto è stato aggiunto, false altrienti.
     */
    @Override
    public boolean aggiungiContatto(Contatto c) {
        if (!verificaInput(c)) {
            return false;
        }
        int row = 0;

        String query = "INSERT INTO " + table_name + "(nome, cognome, telefono1, telefono2, telefono3, email1, email2, email3) VALUES( ?, ?, ?, ?, ?, ?, ?, ?)";

        //dopo l'esecuzione della query il dirver jdbc ritorna il valore generato di tipo intero
        try ( PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getCognome());
            stmt.setString(3, c.getNumTelefono1());
            stmt.setString(4, c.getNumTelefono2());
            stmt.setString(5, c.getNumTelefono3());
            stmt.setString(6, c.getEMail1());
            stmt.setString(7, c.getEMail2());
            stmt.setString(8, c.getEMail3());

            row = stmt.executeUpdate();
            // Ottiene l'ID generato
            try ( ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    c.setId(generatedId);
                    System.out.println("ID GENERATO: " + c.getId());
                }
            }

        } catch (SQLException e) {
            System.err.println("Fallimento nell'inaerimento di dati");

        }
        return row > 0;
    }

    /**
     * @param c
     * @brief Il metodo elimina un contatto dalla tabella del database.
     *
     * @pre La connessione al database è avvenuta con successo.
     * @post Il contatto è stato eliminato.
     *
     * @return boolean: true se il contatto è stato eliminato, false se il
     * contatto non è presente o per qualche errore del database.
     */
    @Override
    public boolean eliminaContatto(Contatto c) {
        int rows = 0;
        String query = "DELETE FROM " + table_name + " WHERE id=" + c.getId();
        try ( Statement stmt = connection.createStatement()) {
            rows = stmt.executeUpdate(query);

        } catch (SQLException e) {

        }
        return rows > 0;
    }

    /**
     * @rief Il metodo elimina tutti i contatti presenti nella tabella del
     * database.
     *
     * @pre La connessione al database è avvenuta con successo ed è presente
     * almeno un contatto nella tabella.
     * @post I contatti sono stati eliminati e la tabella è vuota.
     *
     * @return boolean: true se tutti i contatti sono stati eliminati, false
     * altrimenti.
     */
    @Override
    public boolean eliminaTuttiIContatti() {

        String query = "TRUNCATE TABLE " + table_name + " RESTART IDENTITY";
        try ( Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            System.err.println("cancwllazione fallita");
            return false;
        }
    }

    /**
     * @brief Il metodo preleva i contatti dalla tabella e li salva in una
     * lista.
     *
     * @pre La connessione al database è avvenuta con successo ed è presente
     * almeno un contatto nella tabella.
     *
     * @return La lista dei contatti presneti nella tabella del database in
     * ordine di cognome.
     */
    @Override
    public List<Contatto> prelevaContattiCognome() {
        List<Contatto> listaCognomi = new ArrayList<>();
        String query = "SELECT * FROM "
                + table_name + " WHERE cognome IS NOT NULL AND TRIM(cognome)!='' ORDER BY cognome ASC, nome ASC";
        try ( Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("nome");
                String surname = rs.getString("cognome");

                String telefono1 = rs.getString("telefono1");
                String telefono2 = rs.getString("telefono2");
                String telefono3 = rs.getString("telefono3");

                String eMail1 = rs.getString("email1");
                String eMail2 = rs.getString("email2");
                String eMail3 = rs.getString("email3");
                Contatto app = new Contatto(id, surname, name, telefono1, telefono2, telefono3, eMail1, eMail2, eMail3);
                listaCognomi.add(app);

            }

        } catch (SQLException e) {
            System.out.println("Problemi");
        }
        return listaCognomi;
    }

    /**
     * @param id
     *
     * brief Il metodo recupera il contatto con l'id ricevuto in input
     *
     * @pre La connessione al database è avvenuta con successo ed è presente
     * almeno un contatto nella tabella.
     *
     *
     * @return Il contatto con l'id corrispondente se presente nel database,
     * altrimenti null
     */
    @Override
    public Contatto recuperaContattoById(int id) {
        String query = "SELECT * FROM " + table_name + " WHERE id = ?";
        try ( PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id); // Imposta l'ID del contatto
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String nome = rs.getString("nome");
                String cognome = rs.getString("cognome");
                String tel1 = rs.getString("telefono1");
                String tel2 = rs.getString("telefono2");
                String tel3 = rs.getString("telefono3");
                String email1 = rs.getString("email1");
                String email2 = rs.getString("email2");
                String email3 = rs.getString("email3");

                Contatto contatto = new Contatto(cognome, nome, tel1, tel2, tel3, email1, email2, email3);

                contatto.setId(id); // Imposta l'ID del contatto recuperato

                //Contatto contatto = new Contatto(id, cognome, nome, tel1, tel2, tel3, email1, email2, email3); IN ALTERNATIVA, FA LA STESSA COSA MA CON UNA RIGA IN MENO
                return contatto;
            }

        } catch (SQLException e) {
            System.err.println("Errore durante il recupero del contatto: " + e.getMessage());
        }
        return null; // Ritorna null se non viene trovato il contatto
    }

    /**
     * @brief Il metodo preleva i contatti dalla tabella e li inserusce in una
     * lista.
     *
     * @pre La connessione al database è avvenuta con successo ed è presente
     * almeno un contatto nella tabella.
     *
     * @return La lista dei contatti presenti nella tabella del database in
     * ordine di nome
     */
    @Override
    public List<Contatto> prelevaContattiNome() {
        List<Contatto> listaNomi = new ArrayList<>();
        String query = "SELECT id, nome, telefono1, telefono2, telefono3, email1, email2, email3 FROM "
                + table_name + " WHERE  (cognome IS NULL OR TRIM(cognome) = '') ORDER BY nome ASC";
        try ( Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("nome");

                String telefono1 = rs.getString("telefono1");
                String telefono2 = rs.getString("telefono2");
                String telefono3 = rs.getString("telefono3");

                String eMail1 = rs.getString("email1");
                String eMail2 = rs.getString("email2");
                String eMail3 = rs.getString("email3");
                Contatto app = new Contatto(id, "", name, telefono1, telefono2, telefono3, eMail1, eMail2, eMail3);
                listaNomi.add(app);
            }

        } catch (SQLException e) {
            System.out.println("Problemi");
        }
        return listaNomi;
    }

    /**
     * @brief Il metodo chiude la connessione al database a cui era collegato.
     *
     * @pre conn!=null Il paramentro di ingresso non deve essere nullo
     * @post La connessione viene chiusa.
     *
     *
     */
    @Override
    public void chiudiConnessione() {
        try {
            if (!(connection == null) && !(connection.isClosed())) {
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println("Errore durante la chiusura della connessione: ");
        }
    }

}
