package Vue;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class Bordereau extends JPanel {
    private JButton boutonAffiche, boutonPanier, boutonRecherche;
    private JTextField champRecherche;
    private JLabel etiquetteLogo;

    public Bordereau() {
        Color couleurDeFond = new Color(0xFFEB62); // Couleur de fond pour le panel
        setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10)); // Ajoute un espacement
        setBackground(couleurDeFond); // Définit la couleur de fond du panel

        // Initialisation des composants
        etiquetteLogo = new JLabel("GAUMONT Pathé de campagne"); // Espace pour le logo

        boutonAffiche = new JButton("À l'affiche");
        personnaliserBouton(boutonAffiche);

        boutonPanier = new JButton("Mon panier");
        personnaliserBouton(boutonPanier);

        champRecherche = new JTextField("Saisir votre recherche", 20); // Taille présumée du champ de recherche
        personnaliserChampRecherche(champRecherche);

        boutonRecherche = new JButton("Rechercher");
        personnaliserBouton(boutonRecherche);

        // Ajout des composants au panel
        add(etiquetteLogo);
        add(boutonAffiche);
        add(boutonPanier);
        add(champRecherche);
        add(boutonRecherche);
    }

    private void personnaliserBouton(JButton bouton) {
        bouton.setForeground(Color.WHITE);
        bouton.setFocusPainted(false);
        bouton.setFont(new Font("Arial", Font.BOLD, 18));
        bouton.setBorderPainted(false);
        bouton.setContentAreaFilled(false);
        bouton.setOpaque(false);
        
        // Applique un rendu personnalisé pour le bouton
        bouton.setUI(new BoutonArrondiUI());
    }

    private void personnaliserChampRecherche(JTextField champ) {
        champ.setForeground(Color.BLACK);
        champ.setFont(new Font("Arial", Font.PLAIN, 18));
        champ.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        champ.setPreferredSize(new Dimension(250, 40)); // Définit la taille préférée du champ de recherche
    }

    // UI personnalisé pour les boutons avec des bords arrondis
    private static class BoutonArrondiUI extends javax.swing.plaf.basic.BasicButtonUI {
        @Override
        public void paint(Graphics g, JComponent c) {
            JButton b = (JButton) c;
            if (b.isContentAreaFilled()) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(b.getBackground());
                g2.fill(new RoundRectangle2D.Float(0, 0, b.getWidth(), b.getHeight(), 20, 20));
                g2.dispose();
            }
            super.paint(g, c);
        }
    }

    // Classe pour peindre une bordure arrondie sur un bouton
    private static class BordureArrondie extends AbstractBorder {
        private int rayon;

        BordureArrondie(int rayon) {
            this.rayon = rayon;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.WHITE);
            g2.draw(new RoundRectangle2D.Float(x, y, width - 1, height - 1, rayon, rayon));
        }
    }
}
