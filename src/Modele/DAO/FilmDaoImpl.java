package Modele.DAO;
import Modele.Film;
import java.sql.*;
import java.util.List;

public class FilmDaoImpl implements FilmDAO {
    private final DaoFactory daoFactory;

    public FilmDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void ajouterFilm(Film film) {
        String query = "INSERT INTO film (id_film,titre, duree, auteur, image_path) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, film.getId());
            preparedStatement.setString(2, film.getTitre());
            preparedStatement.setInt(3, film.getDuree());
            preparedStatement.setString(4, film.getAuteur());
            preparedStatement.setString(5, film.getImagePath()); // Ajouter le chemin d'accès de l'image
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void modifierFilm(Film film) {

    }
    @Override
    public String rechercherFilmparNom(String nomFilm) {
        String resultatRecherche = "";
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM film WHERE titre LIKE ?")) {
            preparedStatement.setString(1, "%" + nomFilm + "%");
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int idFilm = resultSet.getInt("id_film");
                    String titre = resultSet.getString("titre");
                    int duree = resultSet.getInt("duree");
                    String auteur = resultSet.getString("auteur");
                    resultatRecherche += "ID: " + idFilm + ", Titre: " + titre + ", Durée: " + duree + ", Auteur: " + auteur + "\n";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer les erreurs de connexion ou de requête SQL
        }
        return resultatRecherche;
    }
    @Override
    public void supprimerFilm(int id) {
        String query = "DELETE FROM film WHERE id = ?";
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Film getFilmById(int id) {
        return null;
    }

    @Override
    public List<Film> getAllFilms() {
        return null;
    }


}

