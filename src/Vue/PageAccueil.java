package Vue;

import javax.swing.*;
import java.awt.*;

public class PageAccueil extends JPanel {
    private Bordereau bordereau;
    private JPanel contentPane;

    public PageAccueil() {
        setLayout(new BorderLayout()); // Utilise BorderLayout pour disposer les composants

        bordereau = new Bordereau();
        contentPane = new JPanel(); 

        contentPane.setBackground(Color.WHITE); 
        
        // Ajout du bordereau en haut et du contentPane au centre
        add(bordereau, BorderLayout.NORTH);
        add(contentPane, BorderLayout.CENTER);
    }
}
