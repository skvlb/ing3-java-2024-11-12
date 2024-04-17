package Vue;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class BordereauConnexion extends JPanel {
    private JButton boutonRetourAccueil;
    private JLabel titrePage;

    public BordereauConnexion(){
        Color couleurDeFond = new Color(0xFFEB62); 
        //setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10)); 
        setLayout(null);
        setBackground(couleurDeFond); 
        //setPreferredSize(new Dimension(100, 150));

        titrePage = new JLabel("GAUMONT Pathé de campagne"); 
        titrePage.setFont(new Font("Arial", Font.BOLD, 30)); 
        titrePage.setBounds(640, 30, 500, 50); // Position et dimension du label

        // A remplacer par une photo maison 
        boutonRetourAccueil = new JButton("Accueil"); 
        boutonRetourAccueil.setBounds(50, 30, 150, 30);

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
