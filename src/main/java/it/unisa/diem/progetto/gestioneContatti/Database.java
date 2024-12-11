
package it.unisa.diem.progetto.gestioneContatti;

import it.unisa.diem.progetto.rubrica.Contatto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @brief La classe prevede tutte le operazioni che devono essere effettuate sul
 * database.
 *
 */
public class Database implements DatabaseManager {

    private final String URL = "jdbc:postgresql://database-1.czikiq82wrwk.eu-west-2.rds.amazonaws.com:5432/postgres";

    private final String table_name = "rubrica";

    private String username = "postgres";
    private String password = "Farinotta01_";
    private Connection connection = null;

    public Database() {
        //appena viene chiamato si apre la connessione
        connessione();

    }

    /**
     * @brief Il metodo ritorna un riferiento alla connession eavvenuta nel
     * costruttore
     */
    @Override
    public Connection connessione() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, username, password);
            }
            System.out.println("connessione riuscita");
        } catch (SQLException e) {
            System.err.println("Connesione al databse fallita");
        }

        return connection;
    }

    /**
     * @param c
     * @brief Il metodo aggiunge un nuovo contatto nel database.
     *
     * @pre La connessione al database è avvenuta con successo.
     * @post Il contatto è stato aggiunto come nuova riga nel database.
     *
     * @return boolean: true se il contatto è stato aggiunto, false altrienti.
     */
    @Override
    public boolean aggiungiContatto(Contatto c) {

        String query = "INSERT INTO " + table_name + "(nome, cognome, telefono1, telefono2, telefono3, email1, email2, email3) VALUES( ?, ?, ?, ?, ?, ?, ?, ?)";

        try ( PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getCognome());
            stmt.setString(3, c.getNumTelefono1());
            stmt.setString(4, c.getNumTelefono2());
            stmt.setString(5, c.getNumTelefono3());
            stmt.setString(6, c.getEMail1());
            stmt.setString(7, c.getEMail2());
            stmt.setString(8, c.getEMail3());
            stmt.executeUpdate();
            // Ottiene l'ID generato
            try ( ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    c.setId(generatedId);
                }
            }
            return true;

        } catch (SQLException e) {
            System.err.println("Fallimento nell'inaerimento di dati");
            return false;
        }

    }

    /**
     * @param c
     * @bief Il metodo modifica uno dei contatti presenti tra le colonne della
     * tabella del database.
     *
     * @pre Il contatto esiste
     * @post Il contatto è stato modificato.
     *
     * @return boolean: true se il contatto è stato modificato, false altrienti.
     */
    @Override
    public boolean modificaContatto(Contatto c) {
        String query = "UPDATE " + table_name + " SET nome=?, cognome=?, telefono1=?, telefono2=?, telefono3=?, email1=?, email2=?, email3=? WHERE id=" + c.getId();
        try ( PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getCognome());
            stmt.setString(3, c.getNumTelefono1());
            stmt.setString(4, c.getNumTelefono2());
            stmt.setString(5, c.getNumTelefono3());
            stmt.setString(6, c.getEMail1());
            stmt.setString(7, c.getEMail2());
            stmt.setString(8, c.getEMail3());

            int rows = stmt.executeUpdate();

            return rows > 0;
        } catch (SQLException e) {
            System.err.println("modifica fallita");
            return false;
        }

    }

    /**
     * @param c
     * @brief Il metodo elimina un contatto dalla tabella del database.
     *
     * @pre La connessione al database è avvenuta con successo.
     * @post Il contatto è stato eliminato.
     *
     * @return boolean: true se il contatto è stato eliminato, false altrienti.
     */
    @Override
    public boolean eliminaContatto(Contatto c) {
        int rows=0;
        String query = "DELETE FROM " + table_name + " WHERE id=" + c.getId();
        try ( Statement stmt = connection.createStatement()) {
            rows = stmt.executeUpdate(query);
            
        } catch (SQLException e) {
            System.err.println("cancwllazione fallita");
            
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
        int rows = 0;
        String query = "TRUNCATE TABLE " + table_name + " RESTART IDENTITY";
        try ( Statement stmt = connection.createStatement()) {
            rows = stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.err.println("cancwllazione fallita");
        }

        return rows > 0;
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
        String query = "SELECT nome, cognome, telefono1, telefono2, telefono3, email1, email2, email3 FROM "
                + table_name + " WHERE cognome IS NOT NULL AND TRIM(cognome)!='' ORDER BY cognome ASC";
        try ( Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString("nome");
                String surname = rs.getString("cognome");

                String telefono1 = rs.getString("telefono1");
                String telefono2 = rs.getString("telefono2");
                String telefono3 = rs.getString("telefono3");

                String eMail1 = rs.getString("email1");
                String eMail2 = rs.getString("email2");
                String eMail3 = rs.getString("email3");
                Contatto app = new Contatto(surname, name, telefono1, telefono2, telefono3, eMail1, eMail2, eMail3);
                listaCognomi.add(app);
            }

        } catch (SQLException e) {
            System.out.println("Problemi");
        }
        return listaCognomi;
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
        String query = "SELECT nome, telefono1, telefono2, telefono3, email1, email2, email3 FROM "
                + table_name + " WHERE  (cognome IS NULL OR TRIM(cognome) = '')ORDER BY nome ASC";
        try ( Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {

                String name = rs.getString("nome");

                String telefono1 = rs.getString("telefono1");
                String telefono2 = rs.getString("telefono2");
                String telefono3 = rs.getString("telefono3");

                String eMail1 = rs.getString("email1");
                String eMail2 = rs.getString("email2");
                String eMail3 = rs.getString("email3");
                Contatto app = new Contatto("", name, telefono1, telefono2, telefono3, eMail1, eMail2, eMail3);
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
