package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class Bordereau extends JPanel {
    private JButton boutonAffiche, boutonPanier, boutonRecherche, logoBouton, boutonCompte;
    private JTextField champRecherche;
    private JLabel titre;

    public Bordereau() {
        setLayout(null); 
        setPreferredSize(new Dimension(100, 150)); // Largeur, hauteur
        setBackground(new Color(0xFFEB62)); // Couleur de fond personnalisée


        // Initialisation et personnalisation des boutons et champ de recherche
        boutonAffiche = new JButton("À l'affiche");

        ImageIcon panier = new ImageIcon("images/logo/panier.png");
        Image image2 = panier.getImage().getScaledInstance(70, 40, Image.SCALE_SMOOTH);
        boutonPanier = new JButton(new ImageIcon(image2));
        boutonPanier.setBorderPainted(false); 
        boutonPanier.setContentAreaFilled(false); 
;
        ImageIcon recherche = new ImageIcon("images/logo/loupe.png");
        Image image3 = recherche.getImage().getScaledInstance(70, 40, Image.SCALE_SMOOTH);
        boutonRecherche = new JButton(new ImageIcon(image3));
        boutonRecherche.setBorderPainted(false); 
        boutonRecherche.setContentAreaFilled(false); 

        champRecherche = new JTextField("Saisir votre recherche", 20);

        ImageIcon compte = new ImageIcon("images/logo/moncompte.png");
        Image image4 = compte.getImage().getScaledInstance(50, 40, Image.SCALE_SMOOTH);
        boutonCompte= new JButton(new ImageIcon(image4));
        boutonCompte.setBorderPainted(false); 
        boutonCompte.setContentAreaFilled(false); 

        personnaliserBouton(boutonAffiche);
        personnaliserBouton(boutonPanier);
        personnaliserBouton(boutonRecherche);
        personnaliserChampRecherche(champRecherche);
        personnaliserBouton(boutonCompte);

        // Création et positionnement du logo
        ImageIcon icon = new ImageIcon("images/logo/logo gaumont.png");
        Image image = icon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        logoBouton = new JButton(new ImageIcon(image));
        logoBouton.setBounds(10, 13, 120, 120); // x, y, largeur, hauteur
        logoBouton.setBorderPainted(false); 
        logoBouton.setContentAreaFilled(false); 

        // Création et positionnement du titre
        titre = new JLabel("GAUMONT Pathé de campagne");
        titre.setFont(new Font(titre.getFont().getName(), Font.BOLD, 24));
        Dimension sizeTitre = titre.getPreferredSize();
        titre.setBounds(575, 5, sizeTitre.width, sizeTitre.height); // x, y, largeur, hauteur

        // Création et positionnement du panel des boutons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(null); // Pas de gestionnaire de disposition pour un positionnement manuel
        buttonPanel.setOpaque(false);
        buttonPanel.setBounds(430,58, 1200, 100); // x, y, largeur, hauteur
        boutonAffiche.setBounds(80, 0, 120, 40); // x, y, largeur, hauteur
        boutonPanier.setBounds(470, 0, 120, 40); // x, y, largeur, hauteur
        champRecherche.setBounds(220, 0, 200, 40); // x, y, largeur, hauteur
        boutonRecherche.setBounds(400, 0, 120, 40); // x, y, largeur, hauteur
        boutonCompte.setBounds(950,0, 100, 40); // x, y, largeur, hauteur

        // Ajout des composants au panel des boutons
        buttonPanel.add(boutonAffiche);
        buttonPanel.add(boutonPanier);
        buttonPanel.add(champRecherche);
        buttonPanel.add(boutonRecherche);
        buttonPanel.add(boutonCompte);

        // Ajout des composants au Bordereau
        add(logoBouton);
        add(titre);
        add(buttonPanel);

        boutonAffiche.addActionListener(e -> {
            System.out.println("Le bouton 'À l'affiche' a été cliqué");
            // a faire 
        });
    
        boutonPanier.addActionListener(e -> {
            System.out.println("Le bouton 'Mon panier' a été cliqué");
            // a faire 
        });
    
        boutonRecherche.addActionListener(e -> {
            String rechercheTexte = champRecherche.getText(); // Récupère le texte du champ de recherche
            System.out.println("Recherche pour : " + rechercheTexte); 
            // a faire 
        });
    
        boutonCompte.addActionListener(e -> {
            System.out.println("Le bouton 'Mon compte' a été cliqué");
            //  a faire
        });
    
        logoBouton.addActionListener(e -> {
            System.out.println("Le logo/bouton a été cliqué");
            //  a faire
        });
    
       
    }
    
    

    private void personnaliserBouton(JButton bouton) {
        bouton.setForeground(Color.WHITE);
        bouton.setBackground(Color.BLACK);
        bouton.setPreferredSize(new Dimension(120, 40));
        bouton.setFocusPainted(false);
        bouton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                bouton.setBackground(Color.DARK_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                bouton.setBackground(Color.BLACK);
            }
        });
    }

    private void personnaliserChampRecherche(JTextField champ) {
        champ.setForeground(Color.BLACK);
        champ.setBackground(Color.WHITE);
        champ.setPreferredSize(new Dimension(200, 40));
    }
}