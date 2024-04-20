package Modele.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;

public class ClientDaoImpl implements ClientDAO{
    private final DaoFactory daoFactory;

    public ClientDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
    public void creerClientParEmail(String email) {
        String query = "INSERT INTO client (email) VALUES (?)";
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void ajouterTypeClientParEmail(String email, int typeClient) {
        String query = "UPDATE client SET type_client_id = ? WHERE email = ?";
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, typeClient);
            preparedStatement.setString(2, email);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
