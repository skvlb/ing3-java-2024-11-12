package modele.DAO;
import modele.Programmation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProgrammationDaoImpl implements ProgrammationDAO {
    private final DaoFactory daoFactory;

    public ProgrammationDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
    public void ajouterProgrammation(Programmation programmation) {
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO programmation (id_programmation,film_id, salle_id, heure_debut, heure_fin) VALUES (?, ?, ?, ?,?)", Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, programmation.getId());
            preparedStatement.setInt(2, programmation.getFilmId());
            preparedStatement.setInt(3, programmation.getSalleId());
            preparedStatement.setTime(4, programmation.getHeureDebut());
            preparedStatement.setTime(5, programmation.getHeureFin());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer les erreurs de connexion ou de requête SQL
        }
    }

    public void supprimerProgrammation(int programmationId) {
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM programmation WHERE id_programmation = ?")) {
            preparedStatement.setInt(1, programmationId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer les erreurs de connexion ou de requête SQL
        }
    }
    public List<Programmation> getProgrammationParIdFilm(int idFilm) {
        List<Programmation> programmations = new ArrayList<>();
        String query = "SELECT * FROM programmation WHERE film_id = ?";
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idFilm);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id_programmation");
                    int salleId = resultSet.getInt("salle_id");
                    Time heureDebut = resultSet.getTime("heure_debut");
                    Time heureFin = resultSet.getTime("heure_fin");
                    Programmation programmation = new Programmation(id, idFilm, salleId, heureDebut, heureFin);
                    programmations.add(programmation);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer les erreurs de connexion ou de requête SQL
        }
        return programmations;
    }

public List<Programmation> getProgrammationParNomFilm(String nomFilm) {
    List<Programmation> programmations = new ArrayList<>();
    String query = "SELECT p.* FROM programmation p JOIN film f ON p.film_id = f.id_film WHERE f.titre = ?";
    try (Connection connection = daoFactory.getConnection();
         PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setString(1, nomFilm);
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id_programmation");
                int idFilm = resultSet.getInt("film_id");
                int salleId = resultSet.getInt("salle_id");
                Time heureDebut = resultSet.getTime("heure_debut");
                Time heureFin = resultSet.getTime("heure_fin");
                Programmation programmation = new Programmation(id, idFilm, salleId, heureDebut, heureFin);
                programmations.add(programmation);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Gérer les erreurs de connexion ou de requête SQL
    }
    return programmations;
}}

