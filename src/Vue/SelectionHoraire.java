package Vue;

import Modele.DAO.DaoFactory;
import Modele.Film;
import javax.swing.*;
import java.awt.*;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SelectionHoraire extends JPanel {
    private int idFilm;
    private JLabel afficheLabel;
    private JPanel horairesPanel;
    private DaoFactory daoFactory;
    private JSpinner dateSpinner;
    private JButton btnValiderDate;
    private List<Time> horaires;

    public SelectionHoraire(int idFilm, DaoFactory daoFactory) {
        this.idFilm = idFilm;
        this.daoFactory = daoFactory;
        setLayout(new BorderLayout(10, 10));

        // Panneau d'affichage du film
        JPanel affichePanel = new JPanel(new BorderLayout());
        affichePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Panneau pour le titre et les horaires
        JPanel rightPanel = new JPanel(new BorderLayout());
        horairesPanel = new JPanel();

        // Titre "Séances"
        JLabel titrePage = new JLabel("Séances", SwingConstants.CENTER);
        titrePage.setFont(new Font(titrePage.getFont().getName(), Font.BOLD, 24));

        // Configuration du spinner de date
        dateSpinner = createDateSpinner();
        btnValiderDate = createValidateButton();

        // Ajout de l'affiche
        Film film = daoFactory.getFilmDAO().getFilmById(idFilm);
        String imagePath = film.getImagePath();
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage().getScaledInstance(350, 550, Image.SCALE_SMOOTH);
        afficheLabel = new JLabel(new ImageIcon(image));
        affichePanel.add(afficheLabel, BorderLayout.CENTER);

        // Ajout des composants au panneau de droite
        JPanel datePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        datePanel.add(dateSpinner);
        datePanel.add(btnValiderDate);

        rightPanel.add(titrePage, BorderLayout.NORTH);
        rightPanel.add(datePanel, BorderLayout.SOUTH);
        rightPanel.add(horairesPanel, BorderLayout.CENTER);

        // Ajout des panneaux principaux au panneau de sélection d'horaire
        add(affichePanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);
    }

    private JSpinner createDateSpinner() {
        Date today = new Date();
        JSpinner spinner = new JSpinner(new SpinnerDateModel(today, null, null, Calendar.DAY_OF_YEAR));
        spinner.setEditor(new JSpinner.DateEditor(spinner, "yyyy-MM-dd"));
        return spinner;
    }

    private JButton createValidateButton() {
        JButton validateButton = new JButton("Valider Date");
        validateButton.addActionListener(e -> updateHoraires(new java.sql.Date(((Date) dateSpinner.getValue()).getTime())));
        return validateButton;
    }

    private void updateHoraires(java.sql.Date date) {
        this.horaires = daoFactory.getProgrammationDAO().getHorairesParIdFilmEtDate(idFilm, date);
        horairesPanel.removeAll();
        horairesPanel.setLayout(new GridLayout((horaires.size() + 1) / 2, 2, 10, 10));

        for (Time horaire : horaires) {
            JButton horaireButton = new JButton(String.format("%tR", horaire));
            horaireButton.addActionListener(e -> {
                System.out.println("Horaire sélectionné: " + e.getActionCommand());
            });
            horairesPanel.add(horaireButton);
        }

        horairesPanel.revalidate();
        horairesPanel.repaint();
    }
}