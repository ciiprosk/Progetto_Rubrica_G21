package it.unisa.diem.progetto.proveTest;




import it.unisa.diem.progetto.gestioneContatti.Database;
import it.unisa.diem.progetto.gestioneContatti.DatabaseCopia;
import it.unisa.diem.progetto.gestioneContatti.DatabaseManager;
import it.unisa.diem.progetto.rubrica.Contatto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rosap
 */
public class TestDatabase {
//    private static String URL;
//    private static String USER;
//    private static String PASSWORD;
//    
//    public Database(){
//        URL="jdbc:postgresql://localhost:5432/Database";
//        USER="Database";
//        PASSWORD="database";
//    }
//    //ritorna un oggetto di tipo connection che è collegato al database creato
//    public Connection databaseConnection() throws SQLException{
//        return DriverManager.getConnection(URL, USER, PASSWORD);
//    }

     public static void main(String[] args) throws SQLException {
         //connessione al database
         DatabaseManager db=new DatabaseCopia("test");
    
      Contatto c=new Contatto("Rossi", "Rosa", "", "", "", "", "", "");
      Contatto c1=new Contatto("", "dio", "", "", "", "", "", "");
      Contatto c2=new Contatto("Passaro", "", "", "", "", "", "", "");
     Contatto c3=new Contatto("Merrino", "Merrino", "", "", "", "", "", "");
//      Contatto c4=new Contatto("CICCIO", "    ", "", "", "", "", "", "");
      db.eliminaTuttiIContatti();
       db.aggiungiContatto(c);
      db.aggiungiContatto(c1);
         System.out.println(c1.getId());
//      db.aggiungiContatto(c2);
//      db.aggiungiContatto(c3);
//      c.setCognome("Cambiatoooo");
//      if(db.modificaContatto(c)){
//          System.out.println("cambiato");
//      } 
//      if(db.eliminaContatto(c))
//             System.out.println("eliminatoooooo");;
      List<Contatto> lista= new ArrayList<>();
      lista= db.prelevaContattiCognome();
         System.out.println("LISTA COGNOMI");
         System.out.println(lista);
         System.out.println("\n");
         System.out.println("\n");
//         
         System.out.println("LISTA NOMI");
      List<Contatto> lista1= new ArrayList<>();
      lista1= db.prelevaContattiNome();
      System.out.println(lista1);
////        
      
      db.chiudiConnessione();
      
     

       
    }
}
