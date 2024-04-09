package Vue;

import javax.swing.*;

public class PagePrincipale extends JFrame {
    public PagePrincipale() {
        setTitle("Pathé de campagne");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrer la fenêtre
    }

    public void afficherPageConnexion() {
        setContentPane(new PageConnexion(this));
        revalidate();
    }

    public void afficherPageAccueil() {
        setContentPane(new PageAccueil(this));
        revalidate();
    }
}