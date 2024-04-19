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
    private List<Time> horaires;

    public SelectionHoraire(int idFilm, DaoFactory daoFactory) {
        this.idFilm = idFilm;
        this.daoFactory = daoFactory;
        setLayout(new BorderLayout(10, 10)); // Espacement horizontal et vertical entre les composants

        // Panel du haut pour le titre "Séances"
        JPanel titrePanel = new JPanel();
        JLabel titrePage = new JLabel("Séances", SwingConstants.CENTER);
        titrePage.setFont(new Font(titrePage.getFont().getName(), Font.BOLD, 24));
        titrePanel.add(titrePage);
        
        // Panel de gauche pour l'affiche
        JPanel affichePanel = new JPanel();
        affichePanel.setLayout(new BorderLayout());
        Film film = daoFactory.getFilmDAO().getFilmById(idFilm);
        String imagePath = film.getImagePath();
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage().getScaledInstance(350, 550, Image.SCALE_SMOOTH);
        afficheLabel = new JLabel(new ImageIcon(image));
        affichePanel.add(afficheLabel, BorderLayout.CENTER);
        affichePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Panel de droite pour la sélection de la date et les horaires
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        dateSpinner = createDateSpinner();
        rightPanel.add(dateSpinner);

        // Panel pour les horaires
        horairesPanel = new JPanel();
        horairesPanel.setLayout(new BoxLayout(horairesPanel, BoxLayout.Y_AXIS));
        rightPanel.add(horairesPanel);

        // Ajouter les panels au panel principal
        add(titrePanel, BorderLayout.NORTH);
        add(affichePanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);
    }

    private JSpinner createDateSpinner() {
        Date today = new Date();
        JSpinner spinner = new JSpinner(new SpinnerDateModel(today, today, null, Calendar.DAY_OF_YEAR));
        spinner.setEditor(new JSpinner.DateEditor(spinner, "yyyy-MM-dd"));
        spinner.setMaximumSize(new Dimension(200, 30)); // Taille du spinner
        spinner.addChangeListener(e -> {
            Date selectedDate = (Date) spinner.getValue();
            updateHoraires(new java.sql.Date(selectedDate.getTime()));
        });
        return spinner;
    }

    private void updateHoraires(java.sql.Date date) {
        horairesPanel.removeAll();
        this.horaires = daoFactory.getProgrammationDAO().getHorairesParIdFilmEtDate(idFilm, date);
        for (Time horaire : horaires) {
            JButton horaireButton = new JButton(String.format("%tR", horaire));
            horaireButton.addActionListener(e -> {
                // Action pour chaque bouton d'horaire
            });
            horairesPanel.add(horaireButton);
        }
        horairesPanel.revalidate();
        horairesPanel.repaint();
    }
}
