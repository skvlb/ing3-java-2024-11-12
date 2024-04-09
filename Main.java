import Modele.Billet;
import Modele.DAO.BilletDAO_fonctions;
import java.sql.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Billet mon_billet = new Billet(1, 3, 5, 6, 20, true);
        // Déclarations des paramètres de connexion
        String url = "jdbc:mysql://localhost:3306/cinema"; // URL de connexion
        String utilisateur = "root"; // Nom d'utilisateur de la base de données
        String motDePasse = ""; // Mot de passe de la base de données

        try {
            // Connexion à la base de données
            Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
            BilletDAO_fonctions mafonction = new BilletDAO_fonctions(connexion);
            mafonction.ajouterBillet(mon_billet);
        } catch (SQLException e) {
            // Gestion des exceptions SQL
            e.printStackTrace();
        }
    }

}