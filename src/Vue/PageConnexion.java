package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PageConnexion extends JPanel {

    private JLabel champConnexion;
    private JTextField champEmail;
    private JPasswordField champPassword;
    private JButton boutonCreation;
    private JButton boutonValider;

    public PageConnexion() {
        setLayout(null);
        setBackground(Color.LIGHT_GRAY); 

        champConnexion = new JLabel("Connectez-vous");
        champConnexion.setBounds(740, 300, 200, 30);
        add(champConnexion);

        JLabel labelEmail = new JLabel("Adresse mail:");
        labelEmail.setBounds(640, 400, 100, 30);
        add(labelEmail);

        champEmail = new JTextField();
        champEmail.setBounds(740, 400, 150, 30);
        add(champEmail);

        JLabel labelPassword = new JLabel("Mot de Passe:");
        labelPassword.setBounds(640, 500, 100, 30);
        add(labelPassword);

        champPassword = new JPasswordField();
        champPassword.setBounds(740, 500, 150, 30);
        add(champPassword);

        boutonCreation = new JButton("Créer un compte");
        boutonCreation.setBounds(640, 600, 200, 30);
        add(boutonCreation);

        boutonValider = new JButton("Valider");
        boutonValider.setBounds(1000, 800, 200, 30);
        add(boutonValider);
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
