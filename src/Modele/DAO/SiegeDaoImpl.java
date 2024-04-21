package Modele.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SiegeDaoImpl implements SiegeDAO{
    private DaoFactory daoFactory;

    public SiegeDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public void decrementerPlaces(int idSalle) {
        String query = "UPDATE salle SET nombre_places = nombre_places - 1 WHERE id_salle = ?";

        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idSalle);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ajouterSiege(String emailUtilisateur, int placePrise, int idSalle) {
        String query = "INSERT INTO siege (email_utilisateur, place_prise, id_salle) VALUES (?, ?, ?)";

        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, emailUtilisateur);
            statement.setInt(2, placePrise);
            statement.setInt(3, idSalle);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Integer> listerPlacesPrises(int idSalle) {
        List<Integer> placesPrises = new ArrayList<>();
        String query = "SELECT place_prise FROM siege WHERE id_salle = ?";

        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idSalle);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int placePrise = resultSet.getInt("place_prise");
                    placesPrises.add(placePrise);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return placesPrises;
    }
}
