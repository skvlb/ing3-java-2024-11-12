package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class PageConnexion extends JPanel {

    private JLabel champConnexion;
    private JLabel champInscription;
    private JTextField champEmail;
    private JPasswordField champPassword;
    private JButton boutonCreation;
    private JButton boutonValider;
    

    public PageConnexion() {
        setLayout(null);
        setBackground(Color.LIGHT_GRAY); 
        Color couleurDeFond = new Color(0xFFEB62); 

        int heightBouton = 50;

        // CHAMP CONNEXION
        champConnexion = new JLabel("Connectez-vous");

        champConnexion.setFont(new Font("Arial", Font.BOLD, 20)); 

        champConnexion.setBounds(690, 50, 250, heightBouton);
        add(champConnexion);

        // LABEL EMAIL
        JLabel labelEmail = new JLabel(" Adresse mail:");

        labelEmail.setOpaque(true);
        labelEmail.setBackground(couleurDeFond);

        labelEmail.setFont(new Font("Arial", Font.BOLD, 16)); 

        labelEmail.setBounds(640, 150, 125, heightBouton);
        add(labelEmail);

        // CHAMP EMAIL
        champEmail = new JTextField();

        champEmail.setOpaque(true);
        champEmail.setBackground(couleurDeFond);

        champEmail.setBounds(760, 150, 150, heightBouton);
        add(champEmail);

        // LABEL PASSWORD
        JLabel labelPassword = new JLabel(" Mot de Passe:");

        labelPassword.setOpaque(true);
        labelPassword.setBackground(couleurDeFond);

        labelPassword.setFont(new Font("Arial", Font.BOLD, 16)); 

        labelPassword.setBounds(640, 225, 125, heightBouton);
        add(labelPassword);

        // CHAMP PASSWORD
        champPassword = new JPasswordField();
        
        champPassword.setOpaque(true);
        champPassword.setBackground(couleurDeFond);

        champPassword.setBounds(760, 225, 150, heightBouton);
        add(champPassword);

        // CHAMP INSCRIPTION
        champInscription = new JLabel("Vous avez pas de compte, créer en un ");
        champInscription.setFont(new Font("Arial", Font.BOLD, 20)); 

        champInscription.setBounds(590, 300, 400, heightBouton);
        add(champInscription);

        // BOUTON CREATION
        boutonCreation = new JButton("Créer un compte");
        personnaliserBouton(boutonCreation);
        boutonCreation.setBounds(640, 350, 200, heightBouton);
        add(boutonCreation);

        // BOUTON VALIDER
        boutonValider = new JButton("Valider");
        personnaliserBouton(boutonValider);
        boutonValider.setBounds(1000, 500, 200, heightBouton);
        add(boutonValider);

        

        
    }

    private void personnaliserBouton(JButton bouton) {
        bouton.setForeground(Color.WHITE);
        bouton.setBackground(Color.BLACK);
        bouton.setPreferredSize(new Dimension(120, 60));
        bouton.setFocusPainted(false);
    }

    public String getEmail() {
        return champEmail.getText();
    }

    public String getMotDePasse() {
        return new String(champPassword.getPassword());
    }

    public void setBoutonCreationListener(ActionListener listener) {
        boutonCreation.addActionListener(listener);
    }
    
    public void setBoutonValiderListener(ActionListener listener) {
        boutonValider.addActionListener(listener); 
    }


}
