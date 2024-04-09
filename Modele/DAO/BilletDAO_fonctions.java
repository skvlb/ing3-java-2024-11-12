package Modele.DAO;
import Modele.Billet;
import java.sql.*;

public class BilletDAO_fonctions implements BilletDAO{
        private Connection connexion;

        public BilletDAO_fonctions(Connection connexion) {
            this.connexion = connexion;
        }

        @Override
        public void ajouterBillet(Billet billet) throws SQLException {
            String query = "INSERT INTO billet (client_id, film_id, salle_id, prix_base, annulation) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connexion.prepareStatement(query)) {
                statement.setInt(1, billet.getId_client());
                statement.setInt(2, billet.getId_film());
                statement.setInt(3, billet.getId_salle());
                statement.setDouble(4, billet.getPrix());
                statement.setBoolean(5, billet.isAnnulation());
                statement.executeUpdate();
            }
        }
        }
