package Vue;

import javax.swing.*;
import java.awt.*;

public class PagePrincipale extends JFrame {
    private JPanel centerPanel; // Panel central pour le contenu

    public PagePrincipale() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920, 1080);
        setLocationRelativeTo(null);

        // Créer et ajouter le Bordereau
        Bordereau bordereau = new Bordereau(this); 
        add(bordereau, BorderLayout.NORTH);

        // Initialiser le panel central pour le contenu
        centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.setBackground(Color.LIGHT_GRAY);
        initializeCenterPanel();

        // Ajouter centerPanel au JFrame
        add(centerPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public void initializeCenterPanel() {
        centerPanel.removeAll();

        // Titre de la sélection du mois
        JLabel titrePage = new JLabel("La sélection du mois", SwingConstants.CENTER);
        titrePage.setFont(new Font(titrePage.getFont().getName(), Font.BOLD, 24));
        centerPanel.add(titrePage, BorderLayout.NORTH);

        // Panel pour les affiches des films
        JPanel filmsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 20));
        filmsPanel.setOpaque(false);

        // Ajoutez vos boutons de film à filmsPanel
        filmsPanel.add(createFilmButton("images/affiches_film/tourmontparnasse.png"));
        filmsPanel.add(createFilmButton("images/affiches_film/dune.png"));
        filmsPanel.add(createFilmButton("images/affiches_film/sosfantome.png"));

        centerPanel.add(filmsPanel, BorderLayout.CENTER);
        centerPanel.revalidate();
        centerPanel.repaint();
    }

    public void changePanel(JPanel newPanel) {
        centerPanel.removeAll();
        centerPanel.add(newPanel, BorderLayout.CENTER);
        centerPanel.revalidate();
        centerPanel.repaint();
    }

    private JButton createFilmButton(String imagePath) {
        ImageIcon icon = new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(300, 450, Image.SCALE_SMOOTH));
        JButton button = new JButton(icon);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.addActionListener(e -> ouvrirDetailFilm(imagePath));
        return button;
    }

    private void ouvrirDetailFilm(String imagePath) {
        System.out.println("Affiche du film " + imagePath + " cliquée.");
    }
    

}