package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Page_Creation_utilisateur extends JFrame {
    private BordereauConnexion bordereauConnexion;
    private JTextField nomField;
    private JTextField prenomField;
    private JTextField emailField;
    private JTextField telephoneField;
    private JTextField mdpField;
    private JButton BoutonValider; // Utilisation du champ de classe

    public Page_Creation_utilisateur() {
        // Définir le titre de la fenêtre
        setTitle("Page avec bandeau et champs de texte");

        // Définir la taille de la fenêtre
        setSize(800, 600);

        // Créer le bordereau de connexion
        bordereauConnexion = new BordereauConnexion();
        bordereauConnexion.setBounds(0, 0, 800, 150);
        add(bordereauConnexion);

        // Créer un panneau pour les champs de texte
        JPanel champsPanel = new JPanel(null);

        // Ajouter le titre "Créer un compte"
        JLabel titreCompte = new JLabel("Créer un compte");
        titreCompte.setFont(new Font("Arial", Font.BOLD, 14));
        titreCompte.setBounds(300, 180, 200, 30);
        champsPanel.add(titreCompte);

        // Ajouter les champs de texte alignés en colonne
        JLabel nomLabel = new JLabel("Nom:");
        nomLabel.setBounds(200, 230, 100, 30);
        champsPanel.add(nomLabel);
        nomField = new JTextField(20);
        nomField.setBounds(300, 230, 200, 30);
        champsPanel.add(nomField);

        JLabel prenomLabel = new JLabel("Prénom:");
        prenomLabel.setBounds(200, 280, 100, 30);
        champsPanel.add(prenomLabel);
        prenomField = new JTextField(20);
        prenomField.setBounds(300, 280, 200, 30);
        champsPanel.add(prenomField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(200, 330, 100, 30);
        champsPanel.add(emailLabel);
        emailField = new JTextField(20);
        emailField.setBounds(300, 330, 200, 30);
        champsPanel.add(emailField);

        JLabel telephoneLabel = new JLabel("Téléphone:");
        telephoneLabel.setBounds(200, 380, 100, 30);
        champsPanel.add(telephoneLabel);
        telephoneField = new JTextField(20);
        telephoneField.setBounds(300, 380, 200, 30);
        champsPanel.add(telephoneField);

        JLabel mdpLabel = new JLabel("Mot de passe:");
        mdpLabel.setBounds(200, 430, 100, 30);
        champsPanel.add(mdpLabel);
        mdpField = new JTextField(20);
        mdpField.setBounds(300, 430, 200, 30);
        champsPanel.add(mdpField);

        // Ajouter le panneau des champs de texte au centre de la fenêtre
        add(champsPanel, BorderLayout.CENTER);

        // Créer un bouton "Valider" en bas à droite
        BoutonValider = new JButton("Valider"); // Utilisation du champ de classe
        BoutonValider.setFont(new Font("Arial", Font.BOLD, 14));
        JPanel boutonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        boutonPanel.add(BoutonValider);

        // Ajouter le panneau du bouton "Valider" en bas de la fenêtre
        add(boutonPanel, BorderLayout.SOUTH);

        // Rendre la fenêtre visible
        setVisible(true);
    }

    public String getNom() {
        return nomField.getText();
    }

    public String getPrenom() {
        return prenomField.getText();
    }

    public String getEmail() {
        return emailField.getText();
    }

    public String getTelephone() {
        return telephoneField.getText();
    }

    public String getMotDePasse() {
        return mdpField.getText();
    }

    public void setBoutonValiderListener(ActionListener listener) {
        BoutonValider.addActionListener(listener);
    }
}
