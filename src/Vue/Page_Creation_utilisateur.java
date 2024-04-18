package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Page_Creation_utilisateur extends JPanel {
    private BordereauConnexion bordereauConnexion; 
    private JTextField nomField;
    private JTextField prenomField;
    private JTextField emailField;
    private JTextField telephoneField;
    private JTextField mdpField;
    private JButton boutonValider;

    public Page_Creation_utilisateur() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(800, 600)); 

        // Création bordereau en haut 
        bordereauConnexion = new BordereauConnexion();
        add(bordereauConnexion, BorderLayout.NORTH);

        // Création panel pour le text (les champs à remplir)
        JPanel champsPanel = new JPanel(null);
        champsPanel.setPreferredSize(new Dimension(800, 450));

        // Configuration des champs et des labels
        configureTextField(champsPanel, "Nom:", 200, 230);
        configureTextField(champsPanel, "Prénom:", 200, 280);
        configureTextField(champsPanel, "Email:", 200, 330);
        configureTextField(champsPanel, "Téléphone:", 200, 380);
        configureTextField(champsPanel, "Mot de passe:", 200, 430);

        // Ajouter le panneau des champs de texte au centre
        add(champsPanel, BorderLayout.CENTER);

        // Créer un bouton "Valider" en bas à droite
        boutonValider = new JButton("Valider");
        boutonValider.setFont(new Font("Arial", Font.BOLD, 14));
        JPanel boutonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        boutonPanel.add(boutonValider);
        add(boutonPanel, BorderLayout.SOUTH);
    }

    private void configureTextField(JPanel panel, String label, int x, int y) {
        JLabel lbl = new JLabel(label);
        lbl.setBounds(x, y, 100, 30);
        JTextField txt = new JTextField(20);
        txt.setBounds(x + 100, y, 200, 30);
        panel.add(lbl);
        panel.add(txt);
    }

    
    public String getNom() { return nomField.getText(); }
    public String getPrenom() { return prenomField.getText(); }
    public String getEmail() { return emailField.getText(); }
    public String getTelephone() { return telephoneField.getText(); }
    public String getMotDePasse() { return mdpField.getText(); }

    
    public void setBoutonValiderListener(ActionListener listener) {
        boutonValider.addActionListener(listener);
    }
}
