
package it.unisa.diem.progetto.gestioneContatti;

import it.unisa.diem.progetto.rubrica.Contatto;
import java.sql.Connection;
import java.util.List;

/**
 * @brief L'interfaccia è stata creata per diminuire il livello di accoppiamento tra le classi.
 */
public interface DatabaseManager {
    
    Connection connessione();
    
    boolean aggiungiContatto(Contatto c);

    boolean eliminaContatto(Contatto c);

    boolean eliminaTuttiIContatti();

    Contatto recuperaContattoById(int id);

    List<Contatto> prelevaContattiCognome();

    List<Contatto> prelevaContattiNome();

    void chiudiConnessione();
}
