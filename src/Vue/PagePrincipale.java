package Vue;

import javax.swing.*;
import java.awt.*;

public class PagePrincipale extends JFrame {
    public PagePrincipale() {
        setTitle("Gaumont Pathé de campagne");
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximiser la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrer la fenêtre
        initUI(); // Initialiser l'interface utilisateur
    }

    private void initUI() {
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BorderLayout(10, 10));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Ajouter de l'espace autour du panel

        // Logo sur le côté gauche du header
        JButton logoButton = new JButton(new ImageIcon("chemin logo")); // 
        logoButton.setBorderPainted(false);
        logoButton.setContentAreaFilled(false);
        logoButton.addActionListener(e -> afficherPageAccueil());
        headerPanel.add(logoButton, BorderLayout.WEST);

        // Panneau central pour les boutons de la barre de titre
        JPanel centerPanel = new JPanel();
        FlowLayout centerLayout = new FlowLayout(FlowLayout.CENTER, 30, 5); // Espacement entre les composants
        centerPanel.setLayout(centerLayout);

        JButton filmsAfficheButton = new JButton("Films à l'affiche");
        centerPanel.add(filmsAfficheButton);
        
        JTextField searchField = new JTextField(20);
        centerPanel.add(searchField);
        
        JButton panierButton = new JButton(new ImageIcon("chemin icone panier")); 

        headerPanel.add(centerPanel, BorderLayout.CENTER);

        // Bouton de compte sur le côté droit du header
        JButton compteButton = new JButton(new ImageIcon("chemin icone compte")); 
        compteButton.setBorderPainted(false);
        compteButton.setContentAreaFilled(false);
        compteButton.addActionListener(e -> afficherPageConnexion());
        headerPanel.add(compteButton, BorderLayout.EAST);

        getContentPane().add(headerPanel, BorderLayout.NORTH);

        // Carousel de films dans la partie centrale
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Ajouter de l'espace autour du panel

        JLabel carouselLabel = new JLabel("Carousel de films qui défilent", SwingConstants.CENTER);
        mainPanel.add(carouselLabel, BorderLayout.CENTER);

        getContentPane().add(mainPanel, BorderLayout.CENTER);
    }

    public void afficherPageConnexion() {
        setContentPane(new PageConnexion(this));
        revalidate();
        repaint();
    }

    public void afficherPageAccueil() {
        getContentPane().removeAll();
        initUI();
        revalidate();
        repaint();
    }
}