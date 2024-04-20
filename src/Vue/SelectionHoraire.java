package Vue;

import Modele.Film;
import Modele.DAO.DaoFactory;
import Modele.Programmation;
import java.awt.*;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.*;

public class SelectionHoraire extends JPanel {
    private int idFilm;
    private JLabel afficheLabel;
    private JPanel horairesPanel;
    private DaoFactory daoFactory;
    private JSpinner dateSpinner;
    private JButton btnValiderDate;
    private JButton btnValiderHoraire;
    private Programmation selectedProgrammation; // Nous allons stocker l'objet Programmation sélectionné
    private JToggleButton selectedButton;

    public SelectionHoraire(int idFilm, DaoFactory daoFactory) {
        this.idFilm = idFilm;
        this.daoFactory = daoFactory;
        setLayout(new BorderLayout(10, 10));

        // Panneau d'affichage du film
        JPanel affichePanel = new JPanel(new BorderLayout());
        affichePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Panneau pour le titre et les horaires
        JPanel rightPanel = new JPanel(new BorderLayout(10, 10));
        rightPanel.setBackground(new Color(0xFFEB62));

        // Panneau pour les horaires
        horairesPanel = new JPanel();
        horairesPanel.setBackground(new Color(0xFFEB62));
        horairesPanel.setLayout(new GridLayout(0, 4, 10, 10)); // Layout pour les horaires

        // Titre "Séances"
        JLabel titrePage = new JLabel("Séances", SwingConstants.CENTER);
        titrePage.setFont(new Font(titrePage.getFont().getName(), Font.BOLD, 24));

        // Configuration du spinner de date
        dateSpinner = createDateSpinner();
        btnValiderDate = createValidateButton();

        // Panneau pour le spinner de date et le bouton valider
        JPanel datePanel = new JPanel();
        datePanel.setLayout(new BoxLayout(datePanel, BoxLayout.LINE_AXIS));
        datePanel.add(Box.createHorizontalGlue());
        datePanel.add(dateSpinner);
        datePanel.add(Box.createRigidArea(new Dimension(10, 0))); // Espace entre spinner et bouton
        datePanel.add(btnValiderDate);
        datePanel.add(Box.createHorizontalGlue());

        // Bouton valider les horaires
        btnValiderHoraire = new JButton("Valider la séance");
        btnValiderHoraire.addActionListener(e -> validerSelection());

        // Ajout des composants au panneau de droite
        rightPanel.add(titrePage, BorderLayout.NORTH);
        rightPanel.add(datePanel, BorderLayout.NORTH);
        rightPanel.add(horairesPanel, BorderLayout.CENTER);
        rightPanel.add(btnValiderHoraire, BorderLayout.SOUTH);

        // Ajout de l'affiche
        Film film = daoFactory.getFilmDAO().getFilmById(idFilm);
        ImageIcon imageIcon = new ImageIcon(film.getImagePath());
        Image image = imageIcon.getImage().getScaledInstance(350, 550, Image.SCALE_SMOOTH);
        afficheLabel = new JLabel(new ImageIcon(image));
        affichePanel.add(afficheLabel, BorderLayout.CENTER);

        // Ajout des panneaux principaux au panneau de sélection d'horaire
        add(affichePanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);

        // Initialiser avec les horaires par défaut (peut-être la date d'aujourd'hui)
        updateHoraires(new java.sql.Date(System.currentTimeMillis()));
    }

    private JSpinner createDateSpinner() {
        Date today = new Date();
        SpinnerDateModel spinnerModel = new SpinnerDateModel(today, null, null, Calendar.DAY_OF_YEAR);
        JSpinner spinner = new JSpinner(spinnerModel);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "dd/MM/yyyy");
        spinner.setEditor(editor);
        Dimension spinnerSize = editor.getPreferredSize();
        spinnerSize.height = 20; // Limite la hauteur du spinner
        editor.setPreferredSize(spinnerSize); // Applique la taille
        return spinner;
    }

    private JButton createValidateButton() {
        JButton button = new JButton("Valider Date");
        button.addActionListener(e -> {
            java.sql.Date selectedDate = new java.sql.Date(((Date) dateSpinner.getValue()).getTime());
            updateHoraires(selectedDate);
        });
        return button;
    }

    private void updateHoraires(java.sql.Date date) {
        List<Programmation> programmations = daoFactory.getProgrammationDAO().getHorairesParIdFilmEtDate(idFilm, date);
        horairesPanel.removeAll();
        ButtonGroup buttonGroup = new ButtonGroup();

        for (Programmation programmation : programmations) {
            JToggleButton horaireButton = new JToggleButton(String.format("%tR", programmation.getHeureDebut()));
            horaireButton.setActionCommand(String.valueOf(programmation.getId())); // Stocke l'ID de programmation

            horaireButton.setBackground(Color.BLACK);
            horaireButton.setForeground(Color.WHITE);
            horaireButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            horaireButton.setFocusPainted(false);
            horaireButton.setFont(new Font("Arial", Font.BOLD, 16));

            horairesPanel.add(horaireButton);
            buttonGroup.add(horaireButton);
            horaireButton.addActionListener(e -> {
                selectedButton = horaireButton;
                selectedProgrammation = programmation; // Mettre à jour la programmation sélectionnée
                selectedButton.setSelected(true);
            });
        }

        horairesPanel.revalidate();
        horairesPanel.repaint();
    }

    private void validerSelection() {
        if (selectedProgrammation != null) {
            java.sql.Date selectedDate = new java.sql.Date(((Date) dateSpinner.getValue()).getTime());
            Film film = daoFactory.getFilmDAO().getFilmById(idFilm);

            System.out.println("Film sélectionné : " + film.getTitre());
            System.out.println("ID du film : " + idFilm);
            System.out.println("Date sélectionnée : " + selectedDate);
            System.out.println("Horaire sélectionné : " + selectedProgrammation.getHeureDebut());
            System.out.println("ID de la programmation : " + selectedProgrammation.getId());
        } else {
            System.out.println("Aucun horaire sélectionné.");
        }
    }
}
