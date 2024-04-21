package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import Controleur.TarifsControleur;

public class PageTarifsConnecte extends JPanel {
    private JLabel txtTarif, txtEtudiant, txtNormal, txtEnfant;
    private JRadioButton radioEtudiant, radioNormal, radioEnfant;
    private JButton boutonPanier;
    private int idProgrammation;
    private int siegeNumero;
    private String userEmail;

    public PageTarifsConnecte(int idProgrammation, int siegeNumero, String userEmail) {
        this.idProgrammation = idProgrammation;
        this.siegeNumero = siegeNumero;
        this.userEmail = userEmail;
        setLayout(null);
        initializeUI();
    }

    private void initializeUI() {
        setBackground(new Color(0xD6D9DF));
        setPreferredSize(new Dimension(800, 600));
        setLayout(null);

        // Panneau pour l'affiche du film
        JPanel panelTarifs = new JPanel();
        panelTarifs.setLayout(null);
        panelTarifs.setBounds(500,20, 500, 600);
        panelTarifs.setBackground(new Color(0xFF00FF));


        // Acheter un billet - label
        txtTarif = new JLabel("Acheter un billet");
        txtTarif.setFont(new Font("Arial", Font.BOLD, 24));
        txtTarif.setBounds(150, 10, 200, 30);
        panelTarifs.add(txtTarif);

        // Bouton Panier
        boutonPanier = new JButton("Ajouter au panier");
        personnaliserBouton(boutonPanier, 150, 400, 200, 50);
        panelTarifs.add(boutonPanier);

        setupTarifOptions(panelTarifs);

        // Grouping radio buttons to allow only one selection
        ButtonGroup tarifGroup = new ButtonGroup();
        tarifGroup.add(radioEtudiant);
        tarifGroup.add(radioNormal);
        tarifGroup.add(radioEnfant);

        add(panelTarifs);


        boutonPanier.addActionListener(this::actionBoutonPanier);
    }

    private void setupTarifOptions(JPanel panelTarifs) {
        int baseY = 100;
        int stepY = 75;
        radioEtudiant = createRadioOption(panelTarifs, "Etudiant", baseY);
        radioNormal = createRadioOption(panelTarifs, "Normal", baseY + stepY);
        radioEnfant = createRadioOption(panelTarifs, "Enfant", baseY + 2 * stepY);
    }

    private JRadioButton createRadioOption(JPanel panelTarifs, String label, int yPos) {
        JLabel labelOption = new JLabel(label);
        labelOption.setFont(new Font("Arial", Font.BOLD, 16));
        labelOption.setBounds(125, yPos, 120, 30);
        panelTarifs.add(labelOption);

        JRadioButton radioButton = new JRadioButton();
        radioButton.setBackground(new Color(0xFFEB62));
        radioButton.setBounds(400, yPos, 30, 30);
        panelTarifs.add(radioButton);

        return radioButton;
    }



    private void actionBoutonPanier(ActionEvent e) {
        try {
            String selectedTarif = getSelectedTarif();  // Assurez-vous que cette méthode renvoie une chaîne non vide correctement
            if (!selectedTarif.isEmpty()) {
                System.out.println("Tarif sélectionné: " + selectedTarif + ", ID Programmation: " + idProgrammation + ", Siège N°: " + siegeNumero + ", Utilisateur: " + userEmail);
                TarifsControleur.traiterSelectionTarif(selectedTarif, idProgrammation, siegeNumero, userEmail);
                JOptionPane.showMessageDialog(this, "Tarif " + selectedTarif + " ajouté pour le siège " + siegeNumero);
            } else {
                JOptionPane.showMessageDialog(this, "Veuillez sélectionner un tarif.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erreur lors de l'ajout du tarif: " + ex.getMessage(), "Erreur Système", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String getSelectedTarif() {
        if (radioEtudiant.isSelected()) return "Etudiant";
        if (radioNormal.isSelected()) return "Normal";
        if (radioEnfant.isSelected()) return "Enfant";
        return "";
    }

    private void personnaliserBouton(JButton bouton, int x, int y, int width, int height) {
        bouton.setBounds(x, y, width, height);
        bouton.setForeground(Color.WHITE);
        bouton.setBackground(Color.BLACK);
        bouton.setFocusPainted(false);
    }


}
