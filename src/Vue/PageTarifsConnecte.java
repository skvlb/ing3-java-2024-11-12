package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
<<<<<<< HEAD
=======

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

>>>>>>> f31b830d87ffb4cbf2729627d57b4d5239dfc890
import Controleur.TarifsControleur;

public class PageTarifsConnecte extends JPanel {
    private JLabel txtTarif, txtEtudiant, txtNormal, txtEnfant;
    private JRadioButton radioEtudiant, radioNormal, radioEnfant;
    private JButton boutonPanier;
<<<<<<< HEAD
    private int idProgrammation;
    private int siegeNumero;
    private String userEmail;
=======
>>>>>>> f31b830d87ffb4cbf2729627d57b4d5239dfc890

    public PageTarifsConnecte(int idProgrammation, int siegeNumero, String userEmail) {
        this.idProgrammation = idProgrammation;
        this.siegeNumero = siegeNumero;
        this.userEmail = userEmail;
        setLayout(null);
        initializeUI();
    }

<<<<<<< HEAD
    private void initializeUI() {
        setBackground(new Color(0xFFEB62));
        setPreferredSize(new Dimension(800, 600));
=======
>>>>>>> f31b830d87ffb4cbf2729627d57b4d5239dfc890

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

<<<<<<< HEAD
        boutonPanier.addActionListener(this::actionBoutonPanier);
=======
        // BOUTON RADIO ETUDIANT
        radioEtudiant = new JRadioButton();
        radioEtudiant.setBackground(couleurDeFond);
        radioEtudiant.setBounds(780, 150, 50, heightBouton);
        add(radioEtudiant);

 
        // TXT NORMAL
        txtNormal = new JLabel(" Normal ");

        txtNormal.setOpaque(true);
        txtNormal.setBackground(couleurDeFond);
        txtNormal.setFont(new Font("Arial", Font.BOLD, 16)); 
        txtNormal.setBounds(640, 225, 140, heightBouton);
        add(txtNormal);

        // BOUTON RADIO NORMAL
        radioNormal = new JRadioButton();
        radioNormal.setBackground(couleurDeFond);
        radioNormal.setBounds(780, 225, 50, heightBouton);
        add(radioNormal);



        // TXT ENFANT
        txtEnfant = new JLabel(" Enfant ");

        txtEnfant.setOpaque(true);
        txtEnfant.setBackground(couleurDeFond);
        txtEnfant.setFont(new Font("Arial", Font.BOLD, 16)); 
        txtEnfant.setBounds(640, 300, 140, heightBouton);
        add(txtEnfant);

        // BOUTON RADIO ENFANT
        radioEnfant = new JRadioButton();
        radioEnfant.setBackground(couleurDeFond);
        radioEnfant.setBounds(780, 300, 50, heightBouton);
        add(radioEnfant);


        ButtonGroup group = new ButtonGroup();
        group.add(radioEtudiant);
        group.add(radioNormal);
        group.add(radioEnfant);


        // A PARTIR D'ICI
        boutonPanier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ton code pour gérer l'événement ici
                String selection = "";
                if (radioEtudiant.isSelected()) {
                    selection = "Etudiant";
                } else if (radioNormal.isSelected()) {
                    selection = "Normal";
                } else if (radioEnfant.isSelected()) {
                    selection = "Enfant";
                }
                ///RECUPERER ID_PROGRAMMATION ET LE MAIL ET LES METTRES EN PARAMETRES DE LA METHODE CI DESSOUS
                //CORRIGER LA METHODE ET ENLEVER LE Id_programmation d'exemple et le mail d'exemple
                // Appel de la méthode dans le contrôleur pour traiter la sélection
                
                TarifsControleur.traiterSelectionBoutonRadio(selection);
            }
        });
>>>>>>> f31b830d87ffb4cbf2729627d57b4d5239dfc890
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
        String selectedTarif = getSelectedTarif();
        if (!selectedTarif.isEmpty()) {
            TarifsControleur.traiterSelectionTarif(selectedTarif, idProgrammation, siegeNumero, userEmail);
            JOptionPane.showMessageDialog(this, "Tarif " + selectedTarif + " ajouté pour le siège " + siegeNumero);
        } else {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner un tarif.", "Erreur", JOptionPane.ERROR_MESSAGE);
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
