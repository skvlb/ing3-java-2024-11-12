package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Controleur.ConnexionControleur;
import Modele.DAO.DaoFactory;

class Bordereau extends JPanel {
    private PagePrincipale mainFrame;
    private JButton boutonAffiche, boutonPanier, boutonRecherche, boutonCompte, logoBouton;
    private JTextField champRecherche;
    private JLabel titre;
    private JLabel lblUserEmail; // Ajout du label pour afficher l'email de l'utilisateur

    public Bordereau(PagePrincipale mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(null); // Utilisation de null layout pour un positionnement libre
        setPreferredSize(new Dimension(1920, 175));
        setBackground(new Color(0xFFEB62)); // Couleur de fond

        // Création et positionnement du logo
        logoBouton = creerBoutonIcone("images/logo/logo gaumont.png", 140, 160);
        logoBouton.setBounds(8, 7, 140, 160); // Position et taille
        add(logoBouton);

        // Création et positionnement du titre
        titre = new JLabel("GAUMONT Pathé de campagne", SwingConstants.CENTER);
        titre.setFont(new Font(titre.getFont().getName(), Font.BOLD, 24));
        titre.setBounds(555, 10, 400, 30); // Position et taille
        add(titre);

        // Création et positionnement des boutons et du champ de recherche
        boutonAffiche = new JButton("À l'affiche");
        personnaliserBouton(boutonAffiche);
        boutonAffiche.setBounds(500, 75, 120, 40); // Position et taille
        
        boutonPanier = creerBoutonIcone("images/logo/panier.png", 70, 40);
        boutonPanier.setBounds(935, 75, 70, 40); // Position et taille
        
        boutonRecherche = creerBoutonIcone("images/logo/loupe.png", 70, 40);
        boutonRecherche.setBounds(845, 75, 70, 40); // Position et taille
        
        boutonCompte = creerBoutonIcone("images/logo/moncompte.png", 50, 40);
        boutonCompte.setBounds(1460, 75, 50, 40); // Position et taille
        
        champRecherche = new JTextField("Saisir votre recherche", 20);
        personnaliserChampRecherche(champRecherche);
        champRecherche.setBounds(640, 75, 200, 40); // Position et taille

        // Ajout du label lblUserEmail
        lblUserEmail = new JLabel("User Email");
        lblUserEmail.setFont(new Font(lblUserEmail.getFont().getName(), Font.BOLD, 16));
        lblUserEmail.setForeground(Color.BLACK);
        lblUserEmail.setHorizontalAlignment(SwingConstants.RIGHT);
        lblUserEmail.setBounds(1460, 140, 150, 30); // Position et taille
        add(lblUserEmail);

        add(boutonAffiche);
        add(boutonPanier);
        add(boutonRecherche);
        add(boutonCompte);
        add(champRecherche);

        // Ajout des écouteurs d'événements après que tous les boutons ont été initialisés et ajoutés au panneau
        addActionListeners();
    }

    private JButton creerBoutonIcone(String cheminIcone, int largeur, int hauteur) {
        ImageIcon icone = new ImageIcon(cheminIcone);
        Image image = icone.getImage().getScaledInstance(largeur, hauteur, Image.SCALE_SMOOTH);
        JButton bouton = new JButton(new ImageIcon(image));
        bouton.setBorderPainted(false);
        bouton.setContentAreaFilled(false);
        bouton.setFocusPainted(false);
        return bouton;
    }

    private void personnaliserBouton(JButton bouton) {
        bouton.setForeground(Color.WHITE);
        bouton.setBackground(Color.BLACK);
        bouton.setPreferredSize(new Dimension(120, 40));
        bouton.setFocusPainted(false);
    }

    private void personnaliserChampRecherche(JTextField champ) {
        champ.setForeground(Color.BLACK);
        champ.setBackground(Color.WHITE);
        champ.setPreferredSize(new Dimension(200, 40));
    }

    private void addActionListeners() { // A DEPLACER 
        // Ici, on crée une seule instance d'ActionListener à réutiliser pour tous les boutons.
        ActionListener actionListener = e -> {
            JButton source = (JButton) e.getSource();
            if (source == boutonAffiche) {
                System.out.println("Le bouton 'À l'affiche' a été cliqué");
                DaoFactory daoFactory = DaoFactory.getInstance();
                PageAffiche pageAffiche = new PageAffiche(daoFactory);
                mainFrame.changePanel(pageAffiche);
            } else if (source == boutonPanier) {
                System.out.println("Le bouton 'Mon panier' a été cliqué");
            } else if (source == boutonRecherche) {
                System.out.println("Recherche pour : " + champRecherche.getText());
            } else if (source == boutonCompte) {
                PageConnexion pageConnexion = new PageConnexion();
                ConnexionControleur controleur = new ConnexionControleur(pageConnexion, mainFrame);
                mainFrame.changePanel(pageConnexion);
                System.out.println("Le bouton 'Mon compte' a été cliqué");
            } else if (source == logoBouton) {
                mainFrame.initializeCenterPanel();
                System.out.println("Le logo/bouton a été cliqué");
            }
        };

        // Associe l'actionListener à chaque bouton.
        boutonAffiche.addActionListener(actionListener);
        boutonPanier.addActionListener(actionListener);
        boutonRecherche.addActionListener(actionListener);
        boutonCompte.addActionListener(actionListener);
        logoBouton.addActionListener(actionListener);
    }
    public JLabel getLblUserEmail() {
        return lblUserEmail;
    }
}
