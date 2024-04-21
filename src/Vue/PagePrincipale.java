package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Modele.Film;
import Modele.DAO.DaoFactory;
import Modele.DAO.FilmDaoImpl;

public class PagePrincipale extends JFrame {
    private JPanel centerPanel;
    private DaoFactory daoFactory;
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
        add(centerPanel, BorderLayout.CENTER);

        daoFactory = DaoFactory.getInstance(); // Assurez-vous que DaoFactory est correctement configuré
        initializeCenterPanel();

        setVisible(true);
    }

    public void initializeCenterPanel() {
        FilmDaoImpl filmDao = new FilmDaoImpl(daoFactory);
        List<Film> films = filmDao.getAllFilms();
    
        centerPanel.removeAll(); // Nettoie le panel avant d'ajouter quoi que ce soit
    
        // Ajout du titre "La sélection du mois"
        JLabel titrePage = new JLabel("La sélection du mois", SwingConstants.CENTER);
        titrePage.setFont(new Font(titrePage.getFont().getName(), Font.BOLD, 24));
        centerPanel.add(titrePage, BorderLayout.NORTH);
    
        // Création du panel pour les films avec un layout approprié
        JPanel filmsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 20));
        filmsPanel.setOpaque(false);
    
        // Ajout des films
        int compteur = 0;
        for (Film film : films) {
            if (compteur < 3) { // Limite le nombre de boutons à trois
                JButton filmButton = createFilmButton(film.getImagePath(), film.getId(), film.getTitre());
                filmsPanel.add(filmButton);
                compteur++; // Incrémente le compteur
            } else {
                break; // Sort de la boucle après avoir ajouté trois boutons
            }
        }
    
    
        // Ajoute le panel des films au centre du centerPanel
        centerPanel.add(filmsPanel, BorderLayout.CENTER);
    
        // Rafraîchissement du panel pour afficher les modifications
        centerPanel.revalidate();
        centerPanel.repaint();
    }

    private JButton createFilmButton(String imagePath, int filmId, String filmTitle) {
        ImageIcon icon = new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(300, 450, Image.SCALE_SMOOTH));
        JButton button = new JButton(icon);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setToolTipText(filmTitle);  // Afficher le titre du film lorsque la souris survole le bouton
        button.addActionListener(e -> System.out.println("Film ID: " + filmId + " cliqué - " + filmTitle));
        return button;
    }

    // Si nécessaire, une méthode pour changer le panel affiché au centre
    public void changePanel(JPanel newPanel) {
        centerPanel.removeAll();
        centerPanel.add(newPanel, BorderLayout.CENTER);
        centerPanel.revalidate();
        centerPanel.repaint();
    }
    public void setConnectedUserEmail(String email) {
        Bordereau bordereau = (Bordereau) getContentPane().getComponent(0);
        JLabel lblUserEmail = bordereau.getLblUserEmail();
        lblUserEmail.setText(email);
    }

    public String getConnectedUserEmail() {
        Bordereau bordereau = (Bordereau) getContentPane().getComponent(0);
        return bordereau.getLblUserEmail().getText();
    }
    
}  
 