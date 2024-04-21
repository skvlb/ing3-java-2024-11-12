package Modele.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Modele.Utilisateur;

public class UtilisateurDaoImpl implements UtilisateurDAO{
    private final DaoFactory daoFactory;

    public UtilisateurDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
    @Override
    public boolean verifierMotDePasse(String email, String motDePasse) {
        String query = "SELECT mot_de_passe FROM utilisateur WHERE email = ?";
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String motDePasseBD = resultSet.getString("mot_de_passe");
                    return motDePasse.equals(motDePasseBD);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // si l'e-mail n'existe pas dans la base de données
    }
    public void ajouterUtilisateur(Utilisateur utilisateur) {
        String query = "INSERT INTO utilisateur (id_utilisateur,nom, prenom, email, mot_de_passe, telephone, type) VALUES (?,?, ?, ?, ?, ?, ?)";
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, utilisateur.getId());
            preparedStatement.setString(2, utilisateur.getNom());
            preparedStatement.setString(3, utilisateur.getPrenom());
            preparedStatement.setString(4, utilisateur.getEmail());
            preparedStatement.setString(5, utilisateur.getMotDePasse());
            preparedStatement.setString(6, utilisateur.getTelephone());
            preparedStatement.setInt(7, utilisateur.getTypeClientID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void supprimerUtilisateur(int idUtilisateur) {
        String query = "DELETE FROM utilisateur WHERE id_utilisateur = ?";
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, idUtilisateur);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Utilisateur> listerUtilisateurs() {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        try (Connection connection = daoFactory.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM utilisateur")) {
            while (resultSet.next()) {
                Utilisateur utilisateur = new Utilisateur(
                        resultSet.getInt("id_utilisateur"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("email"),
                        resultSet.getString("mot_de_passe"),
                        resultSet.getString("telephone"),
                        resultSet.getInt("type")
                );
                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilisateurs;
    }
    public void setConnection(String email, boolean isConnected) {
        String query = "UPDATE utilisateur SET connection = ? WHERE email = ?";
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setBoolean(1, isConnected);
            preparedStatement.setString(2, email);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String getTypeUtilisateurParEmail(String email) {
        String typeUtilisateur = null;
        String query = "SELECT type FROM utilisateur WHERE email = ?";
        
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                typeUtilisateur = resultSet.getString("type");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return typeUtilisateur;
    }
    public int getIdUtilisateurParEmail(String email) {
        int idUtilisateur = -1; // valeur par defaut

        String query = "SELECT id_utilisateur FROM utilisateur WHERE email = ?";
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    idUtilisateur = resultSet.getInt("id_utilisateur");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idUtilisateur;
    }

    public String getEmailUtilisateurParId(int idUtilisateur) {
        String email = null;
        String query = "SELECT email FROM utilisateur WHERE id_utilisateur = ?";
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, idUtilisateur);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    email = resultSet.getString("email");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return email;
    }
}

