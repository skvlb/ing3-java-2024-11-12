package Controleur;

import Modele.DAO.DaoFactory;
import Modele.DAO.FilmDAO;
import Modele.DAO.ProgrammationDAO;
import Modele.Programmation;
import Vue.PageCreationProgrammation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Time;
import java.sql.Date;
import java.util.Random;

public class EmployeControleur {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Test Page Creation Programmation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.setLocationRelativeTo(null);

        PageCreationProgrammation page = new PageCreationProgrammation();
        frame.add(page);

        page.setValiderListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DaoFactory daoFactory = DaoFactory.getInstance();
                String heureDebut = page.getHeureDebut();
                String heureFin = page.getHeureFin();
                String date = page.getDate();

                SimpleDateFormat heureFormat = new SimpleDateFormat("HH:mm");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

                try {
                    java.util.Date parsedHeureDebut = heureFormat.parse(heureDebut);
                    Time heureDebutSQL = new Time(parsedHeureDebut.getTime());

                    java.util.Date parsedHeureFin = heureFormat.parse(heureFin);
                    // Conversion de l'objet java.util.Date en java.sql.Time
                    Time heureFinSQL = new Time(parsedHeureFin.getTime());

                    // Parsing de la chaîne pour la date
                    java.util.Date parsedDate = dateFormat.parse(date);
                    // Conversion de l'objet java.util.Date en java.sql.Date
                    Date dateSQL = new Date(parsedDate.getTime());
                    int salle_id= Integer.parseInt(page.getNumeroSalle());
                    // Génération de l'ID de programmation
                    Random random = new Random();
                    int id = random.nextInt(10000) + 1;
                    FilmDAO filmDAO = daoFactory.getFilmDAO();
                    int id_film=filmDAO.getIdFilmParTitre(page.getNomFilm());
                    Programmation programmation = new Programmation(id, id_film, salle_id,heureDebutSQL, heureFinSQL, dateSQL);
                    ProgrammationDAO programmationDAO = daoFactory.getProgrammationDAO();
                    programmationDAO.ajouterProgrammation(programmation);


                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
            }
        });

        frame.setVisible(true);
    }
}
