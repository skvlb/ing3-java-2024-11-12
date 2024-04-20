package Modele;

import Modele.DAO.DaoFactory;
import Modele.DAO.UtilisateurDAO;
import Modele.*;
import Modele.DAO.*;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
public class TestBug {
    public static void main(String[] args) {
        DaoFactory daoFactory = DaoFactory.getInstance();
        FilmDAO filmDAO = daoFactory.getFilmDAO();
        Film mon_film = new Film(3,"blabla",15,"LILIAN","C:\\Projet_Java_ING3\\Matriximg.jpg");
        //Film mon_film2 = new Film(6,"bloublou",12,"LAlo","C:\\Projet_Java_ING3\\Matriximg.jpg");
        filmDAO.ajouterFilm(mon_film);
        //filmDAO.ajouterFilm(mon_film2);
        //List<Film> film = new ArrayList<>();
        //film=filmDAO.getAllFilms();
        Time heureDebut = new Time(10, 0, 0);
// Créer une heure de fin (par exemple 12:30:00)
        Time heureFin = new Time(12, 30, 0);
        Time heureDebut2     = new Time(14, 0, 0);
// Créer une heure de fin (par exemple 12:30:00)
        Time heureFin2 = new Time(16, 30, 0);
        Date date1 = Date.valueOf("2024-04-17");
        Programmation ma_programmation = new Programmation(4,3,4,heureDebut,heureFin,date1);
        Programmation ma_programmation2 = new Programmation(5,3,4,heureDebut2,heureFin2,date1);
        ProgrammationDAO programmationDAO = daoFactory.getProgrammationDAO();
        programmationDAO.ajouterProgrammation(ma_programmation);
        programmationDAO.ajouterProgrammation(ma_programmation2);
        List<Time> horraires = new ArrayList<>();
        //horraires=programmationDAO.getHorairesParIdFilmEtDate(3, date1);
        for(int i= 0;i<horraires.size();i++){
            System.out.println(horraires.get(i));
        }
    }
}
