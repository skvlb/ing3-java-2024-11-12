package Vue;

import javax.swing.*;

public class PageAccueil extends JPanel {
    private PagePrincipale pagePrincipale;

    public PageAccueil(PagePrincipale pagePrincipale) {
        this.pagePrincipale = pagePrincipale;
        add(new JLabel("Bienvenue sur le site de Gaumont Pathé de campagne !"));
    }
}
