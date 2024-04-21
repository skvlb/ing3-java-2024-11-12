package Vue;

import Modele.Billet;

import javax.swing.*;
import java.awt.*;

public class PanierPage extends JDialog {

    public PanierPage(JFrame parent, Billet billet) {
        super(parent, "Panier", true); // true rend la fenêtre modale

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setPreferredSize(new Dimension(300, 200));
        add(contentPanel);

        // Label ID Client
        JLabel labelIdClient = new JLabel("ID Client: " + billet.getId_client());
        labelIdClient.setBounds(10, 10, 200, 20);
        contentPanel.add(labelIdClient);

        // Label ID Programmation
        JLabel labelIdProgrammation = new JLabel("ID Programmation: " + billet.getId_programmation());
        labelIdProgrammation.setBounds(10, 40, 200, 20);
        contentPanel.add(labelIdProgrammation);

        // Label Prix
        JLabel labelPrix = new JLabel("Prix: " + billet.getPrix() + " EUR");
        labelPrix.setBounds(10, 70, 200, 20);
        contentPanel.add(labelPrix);

        // Bouton pour valider l'achat
        JButton validerAchatButton = new JButton("Valider l'achat");
        validerAchatButton.setBounds(70, 120, 150, 30);
        contentPanel.add(validerAchatButton);

        pack(); // Ajuste automatiquement la taille de la fenêtre en fonction des composants
        setLocationRelativeTo(parent); // Centre la fenêtre par rapport à la fenêtre parente
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Billet billet = new Billet(123, 456, 20,12, false);
            JFrame parentFrame = new JFrame();
            parentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            parentFrame.setSize(400, 400);
            parentFrame.setLocationRelativeTo(null);
            parentFrame.setVisible(true);

            PanierPage popup = new PanierPage(parentFrame, billet);
            popup.setVisible(true);
        });
    }
}
