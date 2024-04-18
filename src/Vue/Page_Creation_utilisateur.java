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

public class Page_Creation_utilisateur extends JPanel {
    private JLabel txtcreation, txtNom, txtPrenom, txtEmail, txtTelephone, txtMdp;
    private JTextField champNom, champPrenom, champEmail, champTelephone;
    private JPasswordField champMdp;
    private JButton boutonValider;

    public Page_Creation_utilisateur() {
        setLayout(null);
        int heightBouton = 50;
        Color couleurDeFond = new Color(0xFFEB62); 



        //setPreferredSize(new Dimension(800, 600)); 

        // Création panel pour le text (les champs à remplir)
        JPanel champsPanel = new JPanel(null);
        champsPanel.setPreferredSize(new Dimension(800, 450));

        // TXT CREATION
        txtcreation = new JLabel("Création d'un compte");
        txtcreation.setFont(new Font("Arial", Font.BOLD, 20)); 
        txtcreation.setBounds(660, 50, 250, heightBouton);
        add(txtcreation);
        

        // TXT NOM
        txtNom = new JLabel(" Nom:");

        txtNom.setOpaque(true);
        txtNom.setBackground(couleurDeFond);
        txtNom.setFont(new Font("Arial", Font.BOLD, 16)); 
        txtNom.setBounds(640, 150, 125, heightBouton);
        add(txtNom);

        // CHAMP NOM

        champNom = new JTextField();
        champNom.setOpaque(true);
        champNom.setBackground(couleurDeFond);
        champNom.setBounds(760, 150, 150, heightBouton);
        add(champNom);
        
        // TXT PRENOM
        txtPrenom = new JLabel(" Prenom:");

        txtPrenom.setOpaque(true);
        txtPrenom.setBackground(couleurDeFond);
        txtPrenom.setFont(new Font("Arial", Font.BOLD, 16)); 
        txtPrenom.setBounds(640, 225, 125, heightBouton);
        add(txtPrenom);

        // CHAMP PRENOM

        champPrenom = new JTextField();
        champPrenom.setOpaque(true);
        champPrenom.setBackground(couleurDeFond);
        champPrenom.setBounds(760, 225, 150, heightBouton);
        add(champPrenom);

        // TXT EMAIL
        txtEmail = new JLabel(" Adresse mail:");

        txtEmail.setOpaque(true);
        txtEmail.setBackground(couleurDeFond);
        txtEmail.setFont(new Font("Arial", Font.BOLD, 16)); 
        txtEmail.setBounds(640, 300, 125, heightBouton);
        add(txtEmail);

        // CHAMP EMAIL

        champEmail = new JTextField();
        champEmail.setOpaque(true);
        champEmail.setBackground(couleurDeFond);
        champEmail.setBounds(760, 300, 150, heightBouton);
        add(champEmail);

        // TXT TELEPHONE
        txtTelephone = new JLabel(" Telephone:");

        txtTelephone.setOpaque(true);
        txtTelephone.setBackground(couleurDeFond);
        txtTelephone.setFont(new Font("Arial", Font.BOLD, 16)); 
        txtTelephone.setBounds(640, 375, 125, heightBouton);
        add(txtTelephone);

        // CHAMP TELEPHONE

        champTelephone = new JTextField();
        champTelephone.setOpaque(true);
        champTelephone.setBackground(couleurDeFond);
        champTelephone.setBounds(760, 375, 150, heightBouton);
        add(champTelephone);

        // TXT MOTDEPASSE
        txtMdp = new JLabel(" Mot de Passe:");

        txtMdp.setOpaque(true);
        txtMdp.setBackground(couleurDeFond);
        txtMdp.setFont(new Font("Arial", Font.BOLD, 16)); 
        txtMdp.setBounds(640, 450, 125, heightBouton);
        add(txtMdp);

        // CHAMP INSCRIPTION
        champMdp = new JPasswordField();
        champMdp.setOpaque(true);
        champMdp.setBackground(couleurDeFond);
        champMdp.setBounds(760, 450, 150, heightBouton);
        add(champMdp);

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



    /*
    public String getNom() { return nomField.getText(); }
    public String getPrenom() { return prenomField.getText(); }
    public String getEmail() { return emailField.getText(); }
    public String getTelephone() { return telephoneField.getText(); }
    public String getMotDePasse() { return mdpField.getText(); }
    */
    
    public void setBoutonValiderListener(ActionListener listener) {
        boutonValider.addActionListener(listener);
    }
}
