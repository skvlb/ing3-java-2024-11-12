package Modele.DAO;
import Modele.Film;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

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
        String query = "SELECT id_film, titre, duree, auteur, image_path FROM film WHERE id_film = ?";
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Film(
                        resultSet.getInt("id_film"),
                        resultSet.getString("titre"),
                        resultSet.getInt("duree"),
                        resultSet.getString("auteur"),
                        resultSet.getString("image_path")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Film> getAllFilms() {
        List<Film> films = new ArrayList<>();
        String query = "SELECT id_film, titre, duree, auteur, image_path FROM film";
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Film film = new Film(
                    resultSet.getInt("id_film"),
                    resultSet.getString("titre"),
                    resultSet.getInt("duree"),
                    resultSet.getString("auteur"),
                    resultSet.getString("image_path")
                );
                films.add(film);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return films;
    }
    }


