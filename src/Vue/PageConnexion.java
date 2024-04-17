package Vue;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class PageConnexion extends JFrame {
    private BordereauConnexion bordereauConnexion;
    private JPanel mainPanel;


    // TEST BOUTONS ET ZONES DE TEXTE 

    private JLabel champConnexion, txtChamp1, txtChamp2;
    private JTextField champ1, champ2;
    private JButton boutonCreation, boutonValider;

    public PageConnexion() {
        setTitle("Page Connexion");
        setSize(1920, 1080); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel = new JPanel();

        mainPanel.setLayout(null);

        
        bordereauConnexion = new BordereauConnexion();
        bordereauConnexion.setBounds(0, 0, 1920, 150);  // Hauteur a changer en fonction des valeurs de Victor 
        add(bordereauConnexion);
        
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.LIGHT_GRAY); 

        
        mainPanel.setBounds(0, 100, 1920, 980);     // A Changer en fonction des valeurs de Victor 
        add(mainPanel);



        champConnexion = new JLabel("Connecter vous");
        champConnexion.setBounds(740, 300, 200, 30); // Position et dimension de la zone de texte
        mainPanel.add(champConnexion);


        txtChamp1 = new JLabel("Adresse mail");
        txtChamp1.setBounds(640, 400, 100,30);
        mainPanel.add(txtChamp1);

        champ1 = new JTextField("");
        champ1.setBounds(740, 400, 150, 30); // Position et dimension du premier bouton
        mainPanel.add(champ1);


        txtChamp2 = new JLabel("Mot de Passe");
        txtChamp2.setBounds(640, 500, 100,30);
        mainPanel.add(txtChamp2);

        champ2 = new JTextField("");
        champ2.setBounds(740, 500, 150, 30); // Position et dimension du deuxième bouton
        mainPanel.add(champ2);

        boutonCreation = new JButton("Créer un compte");
        boutonCreation.setBounds(640, 600, 200, 30);
        mainPanel.add(boutonCreation);

        boutonValider = new JButton("Valider");
        boutonValider.setBounds(1000, 800, 200, 30);
        mainPanel.add(boutonValider);
    }

    public String getEmail() {
        return champ1.getText();
    }
    
    public String getMotDePasse() {
        return champ2.getText();
    }
    
    public void setBoutonValiderListener(ActionListener listener) {
        boutonValider.addActionListener(listener);
    }
    

/* 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PageConnexion().setVisible(true);
            }
        });
    }
*/

}
