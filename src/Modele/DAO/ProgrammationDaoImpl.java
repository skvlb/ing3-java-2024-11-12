package Modele.DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import Modele.Programmation;

public class ProgrammationDaoImpl implements ProgrammationDAO {
    private final DaoFactory daoFactory;

    public ProgrammationDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
    public void ajouterProgrammation(Programmation programmation) {
        String query = "INSERT INTO programmation (id_programmation,film_id, salle_id, heure_debut, heure_fin, date) VALUES (?,?, ?, ?, ?, ?)";
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, programmation.getId());
            preparedStatement.setInt(2, programmation.getFilmId());
            preparedStatement.setInt(3, programmation.getSalleId());
            preparedStatement.setTime(4, programmation.getHeureDebut());
            preparedStatement.setTime(5, programmation.getHeureFin());
            preparedStatement.setDate(6, programmation.getDate());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void supprimerProgrammation(int programmationId) {
        String query = "DELETE FROM programmation WHERE id_programmation = ?";
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, programmationId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
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
                    Date date = resultSet.getDate("date");
                    Programmation programmation = new Programmation(id, idFilm, salleId, heureDebut, heureFin, date);
                    programmations.add(programmation);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
                    Date date = resultSet.getDate("date");
                    Programmation programmation = new Programmation(id, idFilm, salleId, heureDebut, heureFin, date);
                    programmations.add(programmation);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return programmations;
    }
    public List<Programmation> getHorairesParIdFilmEtDate(int idFilm, Date date) {
        List<Programmation> programmations = new ArrayList<>();
        String query = "SELECT id_programmation, salle_id, heure_debut, heure_fin, date FROM programmation WHERE film_id = ? AND date = ?";
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idFilm);
            statement.setDate(2, date);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id_programmation");
                    int salleId = resultSet.getInt("salle_id");
                    Time heureDebut = resultSet.getTime("heure_debut");
                    Time heureFin = resultSet.getTime("heure_fin");
                    Programmation programmation = new Programmation(id, idFilm, salleId, heureDebut, heureFin, date);
                    programmations.add(programmation);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return programmations;
    }
    public Programmation getProgrammationParId(int idProgrammation) {
        String query = "SELECT * FROM programmation WHERE id_programmation = ?";
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idProgrammation);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int filmId = resultSet.getInt("film_id");
                    int salleId = resultSet.getInt("salle_id");
                    Time heureDebut = resultSet.getTime("heure_debut");
                    Time heureFin = resultSet.getTime("heure_fin");
                    Date date = resultSet.getDate("date");
                    return new Programmation(idProgrammation, filmId, salleId, heureDebut, heureFin, date);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
  }
