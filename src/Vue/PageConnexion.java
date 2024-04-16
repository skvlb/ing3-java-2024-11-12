package Vue;

import javax.swing.*;

public class PageConnexion extends JPanel {
    private PageAccueil pagePrincipale;

    public PageConnexion(PageAccueil pagePrincipale) {
        this.pagePrincipale = pagePrincipale;
        // Configurer le layout et ajouter des composants pour la connexion ici

        JButton boutonConnexion = new JButton("Connexion");
        boutonConnexion.addActionListener(e -> pagePrincipale.afficherPageAccueil()); // Après connexion, revenir à la page principale
        add(boutonConnexion);
    }
}
