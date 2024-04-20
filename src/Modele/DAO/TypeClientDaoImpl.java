package Modele.DAO;
import Modele.TypeClient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class TypeClientDaoImpl implements TypeClientDAO{
    private DaoFactory daoFactory;

    public TypeClientDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
    public void ajouterTypeClient(TypeClient typeClient) {
        String query = "INSERT INTO typeclient (id_type, description,reduction) VALUES (?, ?,?)";
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, typeClient.getId());
            preparedStatement.setString(2, typeClient.getDescription());
            preparedStatement.setDouble(3,typeClient.getReduction());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<TypeClient> listerTypesClients() {
        List<TypeClient> typesClients = new ArrayList<>();
        String query = "SELECT * FROM typeclient";
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                double reduction = resultSet.getDouble("reduction");
                TypeClient typeClient = new TypeClient(id, nom,reduction);
                typesClients.add(typeClient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typesClients;
    }
}
