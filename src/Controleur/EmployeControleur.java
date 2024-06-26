package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

import javax.swing.JOptionPane;

import Modele.Programmation;
import Modele.DAO.DaoFactory;
import Modele.DAO.FilmDAO;
import Vue.PageCreationProgrammation;

public class EmployeControleur {
    private PageCreationProgrammation page;

    public EmployeControleur(PageCreationProgrammation page) {
        this.page = page;
        this.page.setValiderListener(new ValiderProgrammationListener());
        
    }

    class ValiderProgrammationListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            validerProgrammation();
        }
    }

    public void validerProgrammation() {
        String heureDebut = page.getHeureDebut();
        String heureFin = page.getHeureFin();
        String date = page.getDate();

        SimpleDateFormat heureFormat = new SimpleDateFormat("HH:mm");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);

        try {
            Time heureDebutSQL = new Time(heureFormat.parse(heureDebut).getTime());
            Time heureFinSQL = new Time(heureFormat.parse(heureFin).getTime());
            Date dateSQL = new Date(dateFormat.parse(date).getTime());

            int salle_id = Integer.parseInt(page.getNumeroSalle());
            Random random = new Random();
            int id = random.nextInt(100,10000) + 1;

            FilmDAO filmDAO = DaoFactory.getInstance().getFilmDAO();
            int id_film = filmDAO.getIdFilmParTitre(page.getNomFilm());

            Programmation programmation = new Programmation(id, id_film, salle_id, heureDebutSQL, heureFinSQL, dateSQL);
            DaoFactory.getInstance().getProgrammationDAO().ajouterProgrammation(programmation);

            // aaffichage du message pop-up
            JOptionPane.showMessageDialog(null, "Programmation ajoutée avec succès!");
        } catch (ParseException ex) {
            // affichage du message pop-up en cas d'erreur
            JOptionPane.showMessageDialog(null, "Erreur lors du parsing de la date: " + ex.getMessage(), "Erreur de Parsing", JOptionPane.ERROR_MESSAGE);
        }
    }
}