package Vue;

import javax.swing.*;
import java.awt.event.*;

public class PageConnexion extends JPanel {
    private PagePrincipale pagePrincipale;

    public PageConnexion(PagePrincipale pagePrincipale) {
        this.pagePrincipale = pagePrincipale;
        JButton boutonConnexion = new JButton("Connexion");
        boutonConnexion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pagePrincipale.afficherPageAccueil();
            }
        });

        add(boutonConnexion);
    }
}
