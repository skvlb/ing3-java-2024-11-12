package Vue;

import javax.swing.*;
import java.awt.*;


public class BordereauConnexion extends JPanel {
    private JButton boutonRetourAccueil;
    private JLabel titrePage;

    public BordereauConnexion(){
        Color couleurDeFond = new Color(0xFFEB62); 
        //setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10)); 
        setLayout(null);
        setBackground(couleurDeFond); 
        setPreferredSize(new Dimension(1920, 100));

        titrePage = new JLabel("GAUMONT Pathé de campagne"); 
        titrePage.setFont(new Font("Arial", Font.BOLD, 30)); 
        titrePage.setBounds(735, 30, 450, 50); // Position et dimension du label

        // A remplacer par une photo maison 
        boutonRetourAccueil = new JButton("Accueil"); 
        boutonRetourAccueil.setBounds(50, 30, 100, 30);

        parametreBouton(boutonRetourAccueil);

        add(boutonRetourAccueil);

        add(titrePage);
    }

    private void parametreBouton(JButton bouton) {
        bouton.setForeground(Color.WHITE);
        bouton.setFocusPainted(false);
        bouton.setFont(new Font("Arial", Font.BOLD, 18));
        bouton.setBorderPainted(false);
        bouton.setContentAreaFilled(false);
        bouton.setOpaque(false);

    }
}
