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
    public int ajouterProgrammation(Programmation programmation) {
        int idProgrammation = -1;
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO programmation (film_id, salle_id, heure_debut, heure_fin) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, programmation.getFilmId());
            preparedStatement.setInt(2, programmation.getSalleId());
            preparedStatement.setTime(3, programmation.getHeureDebut());
            preparedStatement.setTime(4, programmation.getHeureFin());
            preparedStatement.executeUpdate();
            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    idProgrammation = resultSet.getInt(1);
                } }
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer les erreurs de connexion ou de requête SQL
        }
            return idProgrammation;
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
}
