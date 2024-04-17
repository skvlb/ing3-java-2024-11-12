package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PageAccueil extends JPanel {
    private Bordereau bordereau;
    private JPanel contentPane;
    private JLabel titleLabel;
    private JButton film1Button, film2Button, film3Button;

    public PageAccueil() {
        setLayout(new BorderLayout()); // Utilise BorderLayout pour disposer les composants

        bordereau = new Bordereau();
        contentPane = new JPanel(new BorderLayout()); // BorderLayout pour contenir header et films

        contentPane.setBackground(Color.LIGHT_GRAY);

        // Titre de la sélection du mois
        titleLabel = new JLabel("La sélection du mois", JLabel.CENTER);
        titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.BOLD, 24));
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Centrer le titre
        headerPanel.add(titleLabel);
        
        // Panel pour les affiches de films
        JPanel filmsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Centrer et espacer les boutons
        filmsPanel.setBackground(Color.LIGHT_GRAY);

        // Boutons pour les films
        film1Button = createFilmButton("images/affiches_film/godzilla.png");
        film2Button = createFilmButton("images/affiches_film/sosfantomes.png");
        film3Button = createFilmButton("images/affiches_film/dune.png");
        
        // Ajout des boutons d'affiches au panel des films
        filmsPanel.add(film1Button);
        filmsPanel.add(film2Button);
        filmsPanel.add(film3Button);

        // Ajout du header et du panel des films au contentPane
        contentPane.add(headerPanel, BorderLayout.NORTH);
        contentPane.add(filmsPanel, BorderLayout.CENTER);

        // Ajout du bordereau et du contentPane à PageAccueil
        add(bordereau, BorderLayout.NORTH);
        add(contentPane, BorderLayout.CENTER);
    }

    // Méthode pour créer un bouton d'affiche de film
    private JButton createFilmButton(String imagePath) {
        ImageIcon icon = new ImageIcon(imagePath); 
        JButton button = new JButton(icon);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Affiche de film cliquée!");
            }
        });
        return button;
    }
}
