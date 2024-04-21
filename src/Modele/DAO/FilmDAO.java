package Modele.DAO;

import Modele.Film;

import java.util.List;

public interface FilmDAO {
        // méthodes CRUD pour la gestion des films
        void ajouterFilm(Film film);
        void modifierFilm(Film film);
        void supprimerFilm(int id);
        Film getFilmById(int id);
        List<Film> getAllFilms();
        public String rechercherFilmparNom(String nomFilm);
        public int getIdFilmParTitre(String titre);
        public List<String> obtenirTitresDesFilms();
}
