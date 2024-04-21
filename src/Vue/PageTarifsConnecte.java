package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        setBackground(new Color(0xFFEB62));
        setPreferredSize(new Dimension(800, 600));

        // Acheter un billet - label
        txtTarif = new JLabel("Acheter un billet");
        txtTarif.setFont(new Font("Arial", Font.BOLD, 24));
        txtTarif.setBounds(300, 20, 200, 30);
        add(txtTarif);

        // Bouton Panier
        boutonPanier = new JButton("Ajouter au panier");
        personnaliserBouton(boutonPanier, 300, 400, 200, 50);
        add(boutonPanier);

        setupTarifOptions();

        // Grouping radio buttons to allow only one selection
        ButtonGroup tarifGroup = new ButtonGroup();
        tarifGroup.add(radioEtudiant);
        tarifGroup.add(radioNormal);
        tarifGroup.add(radioEnfant);

        boutonPanier.addActionListener(this::actionBoutonPanier);
    }

    private void setupTarifOptions() {
        int baseY = 100;
        int stepY = 75;
        radioEtudiant = createRadioOption("Etudiant", baseY);
        radioNormal = createRadioOption("Normal", baseY + stepY);
        radioEnfant = createRadioOption("Enfant", baseY + 2 * stepY);
    }

    private JRadioButton createRadioOption(String label, int yPos) {
        JLabel labelOption = new JLabel(label);
        labelOption.setFont(new Font("Arial", Font.BOLD, 16));
        labelOption.setBounds(280, yPos, 120, 30);
        add(labelOption);

        JRadioButton radioButton = new JRadioButton();
        radioButton.setBackground(new Color(0xFFEB62));
        radioButton.setBounds(400, yPos, 30, 30);
        add(radioButton);

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
