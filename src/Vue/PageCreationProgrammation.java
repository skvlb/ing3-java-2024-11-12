package Vue;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PageCreationProgrammation extends JPanel {
    private JLabel txtCreation, txtHeureDebut, txtHeureFin, labelDate, labelSalle;
    private JTextField champDate, champHeureDebut, champHeureFin;
    private JButton boutonValider;
    private JComboBox<String> comboBoxSalles,comboBoxFilms;

    public PageCreationProgrammation() {
        setLayout(null);
        int heightBouton = 50;
        Color couleurDeFond = new Color(0xFFEB62);

        // Label "Date"
        labelDate = new JLabel("Date:");
        labelDate.setOpaque(true);
        labelDate.setBackground(couleurDeFond);
        labelDate.setFont(new Font("Arial", Font.BOLD, 16));
        labelDate.setBounds(500, 150, 100, heightBouton);
        add(labelDate);

        // Champ "Date"
        champDate = new JTextField();
        champDate.setBounds(600, 150, 150, heightBouton);
        add(champDate);

        // Texte "Création d'une programmation"
        txtCreation = new JLabel("Création d'une programmation");
        txtCreation.setFont(new Font("Arial", Font.BOLD, 20));
        txtCreation.setBounds(600, 50, 300, heightBouton);
        add(txtCreation);

        // Texte "Heure de début"
        txtHeureDebut = new JLabel("Heure de début:");
        txtHeureDebut.setOpaque(true);
        txtHeureDebut.setBackground(couleurDeFond);
        txtHeureDebut.setFont(new Font("Arial", Font.BOLD, 16));
        txtHeureDebut.setBounds(470, 250, 150, heightBouton);
        add(txtHeureDebut);

        // Champ "Heure de début"
        champHeureDebut = new JTextField();
        champHeureDebut.setOpaque(true);
        champHeureDebut.setBackground(couleurDeFond);
        champHeureDebut.setBounds(600, 250, 150, heightBouton);
        add(champHeureDebut);

        // Texte "Heure de fin"
        txtHeureFin = new JLabel("Heure de fin:");
        txtHeureFin.setOpaque(true);
        txtHeureFin.setBackground(couleurDeFond);
        txtHeureFin.setFont(new Font("Arial", Font.BOLD, 16));
        txtHeureFin.setBounds(470, 350, 150, heightBouton);
        add(txtHeureFin);

        // Champ "Heure de fin"
        champHeureFin = new JTextField();
        champHeureFin.setOpaque(true);
        champHeureFin.setBackground(couleurDeFond);
        champHeureFin.setBounds(600, 350, 150, heightBouton);
        add(champHeureFin);

        // Label "Numéro de salle"
        labelSalle = new JLabel("Numéro de salle:");
        labelSalle.setOpaque(true);
        labelSalle.setBackground(couleurDeFond);
        labelSalle.setFont(new Font("Arial", Font.BOLD, 16));
        labelSalle.setBounds(450, 450, 150, heightBouton);
        add(labelSalle);

        // Menu déroulant pour le numéro de salle
        String[] numerosSalles = {"1", "2", "3", "4", "5"}; // Les numéros de salle disponibles
        comboBoxSalles = new JComboBox<>(numerosSalles);
        comboBoxSalles.setBounds(600, 450, 150, heightBouton);
        add(comboBoxSalles);

        // Liste des noms des films
        String[] nomsFilms = {"Avatar 2", "Dune 2", "Godzilla", "James Bond", "Le Mans 66", "OSS 117", "Rush", "SOS Fantômes", "Le Tour Montparnasse Infernal"};
        comboBoxFilms = new JComboBox<>(nomsFilms);
        // Position et taille du menu déroulant
        comboBoxFilms.setBounds(1000, 50, 200, 30);
        add(comboBoxFilms);

        // Bouton "Valider"
        boutonValider = new JButton("Valider");
        personnaliserBouton(boutonValider);
        boutonValider.setBounds(850, 450, 120, heightBouton);
        add(boutonValider);

    }

    private void personnaliserBouton(JButton bouton) {
        bouton.setForeground(Color.WHITE);
        bouton.setBackground(Color.BLACK);
        bouton.setPreferredSize(new Dimension(120, 60));
        bouton.setFocusPainted(false);
    }

    public String getHeureDebut() {
        return champHeureDebut.getText();
    }

    public String getHeureFin() {
        return champHeureFin.getText();
    }

    public String getDate() {
        return champDate.getText();
    }

    public String getNumeroSalle() {
        return (String) comboBoxSalles.getSelectedItem();
    }
    public String getNomFilm() {
        return (String) comboBoxFilms.getSelectedItem();
    }

    public void setValiderListener(ActionListener listener) {
        boutonValider.addActionListener(listener);
    }
}