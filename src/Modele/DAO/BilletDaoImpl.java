package modele.DAO;

import modele.Billet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BilletDaoImpl implements BilletDAO{
    private final DaoFactory daoFactory;

    public BilletDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public void ajouterBillet(Billet billet) {
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO billet (id_billet, client_id, id_programmation, prix_base, annulation) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, billet.getId_billet());
            preparedStatement.setInt(2, billet.getId_client());
            preparedStatement.setInt(3, billet.getId_programmation()); // Utilisation de la nouvelle colonne id_programmation
            preparedStatement.setDouble(4, billet.getPrix());
            preparedStatement.setBoolean(5, billet.isAnnulation());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer les erreurs de connexion ou de requête SQL
        }
    }

        @Override
        public void supprimerBillet(int billetId) {
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM billet WHERE id_billet = ?")) {
            preparedStatement.setInt(1, billetId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        @Override
        public List<Billet> listerBillets() {
        List<Billet> billets = new ArrayList<>();
        try (Connection connection = daoFactory.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM billet")) {
            while (resultSet.next()) {
                Billet billet = new Billet(
                        resultSet.getInt("id_billet"),
                        resultSet.getInt("client_id"),
                        resultSet.getInt("id_programmation"),
                        resultSet.getDouble("prix_base"),
                        resultSet.getBoolean("annulation")
                );
                billets.add(billet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer les erreurs de connexion ou de requête SQL
        }
        return billets;
    }

    }
