package Vue;

import javax.swing.*;
import java.awt.*;

public class PageAccueil extends JPanel {
    private Bordereau bordereau;
    private JPanel contentPane;
    private JLabel titrePage;
    private JButton film1Button, film2Button, film3Button;

    public PageAccueil() {
        setLayout(new BorderLayout());

        bordereau = new Bordereau();
        add(bordereau, BorderLayout.NORTH);

        contentPane = new JPanel();
        contentPane.setLayout(null); // Enlève le BorderLayout pour un layout null
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setPreferredSize(new Dimension(1920, 720)); // Ajuste ceci à la taille de ta fenêtre

        // Titre de la sélection du mois
        titrePage = new JLabel("La sélection du mois", SwingConstants.CENTER);
        titrePage.setFont(new Font(titrePage.getFont().getName(), Font.BOLD, 24));
        titrePage.setBounds(640, 20, titrePage.getPreferredSize().width, titrePage.getPreferredSize().height);
        contentPane.add(titrePage);

        // Boutons pour les films avec les affiches
        film1Button = createFilmButton("images/affiches_film/tourmontparnasse.png");
        film2Button = createFilmButton("images/affiches_film/dune.png");
        film3Button = createFilmButton("images/affiches_film/sosfantome.png");

        // Ajuste les valeurs x, y, width et height selon les besoins
        film1Button.setBounds(300, 100, 300, 450);
        film2Button.setBounds(615, 100, 300, 450);
        film3Button.setBounds(930, 100, 300, 450);

        contentPane.add(film1Button);
        contentPane.add(film2Button);
        contentPane.add(film3Button);

        add(contentPane, BorderLayout.CENTER);
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
