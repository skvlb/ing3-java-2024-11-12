package Vue;

import javax.swing.*;
import java.awt.*;

public class PageConnexion extends JFrame {
    private BordereauConnexion bordereauConnexion;
    private JPanel mainPanel;


    // TEST BOUTONS ET ZONES DE TEXTE 

    private JTextField textField;
    private JButton bouton1;
    private JButton bouton2;

    public PageConnexion() {
        setTitle("Page Connexion");
        setSize(1920, 1080); // Set the window size as per the wireframe requirement
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLayout(null);
        mainPanel = new JPanel();

        mainPanel.setLayout(null);

        
        bordereauConnexion = new BordereauConnexion();

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.LIGHT_GRAY); 

        bordereauConnexion.setBounds(0, 0, 1920, 100);  // Huateur a changer en fonction des valeurs de Victor 
        add(bordereauConnexion);
        mainPanel.setBounds(0, 100, 1920, 980);     // A Changer en fonction des valeurs de Victor 
        add(mainPanel);




        // Ajouter une zone de texte
        textField = new JTextField();
        textField.setBounds(250, 50, 200, 30); // Position et dimension de la zone de texte
        mainPanel.add(textField);

        // Ajouter le premier bouton
        bouton1 = new JButton("Bouton 1");
        bouton1.setBounds(470, 50, 150, 30); // Position et dimension du premier bouton
        mainPanel.add(bouton1);

        // Ajouter le deuxième bouton
        bouton2 = new JButton("Bouton 2");
        bouton2.setBounds(630, 50, 150, 30); // Position et dimension du deuxième bouton
        mainPanel.add(bouton2);

    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PageConnexion().setVisible(true);
            }
        });
    }
}
