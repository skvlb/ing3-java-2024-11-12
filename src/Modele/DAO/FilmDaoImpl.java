package modele.DAO;
import modele.Film;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmDaoImpl implements FilmDAO {
    private final DaoFactory daoFactory;

    public FilmDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void ajouterFilm(Film film) {
        String query = "INSERT INTO film (titre, duree, auteur) VALUES (?, ?, ?)";
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, film.getTitre());
            preparedStatement.setInt(2, film.getDuree());
            preparedStatement.setString(3, film.getAuteur());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modifierFilm(Film film) {

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

