package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

import Controleur.TarifsControleur;



public class PageTarifsConnecte extends JPanel {
    private JLabel txtTarif, txtEtudiant, txtNormal, txtEnfant;
    //private JTextField champNom, champPrenom, champEmail, champTelephone;
    private JRadioButton radioEtudiant, radioNormal, radioEnfant;
    private JButton boutonPanier;

    public PageTarifsConnecte() {
        setLayout(null);
        int heightBouton = 50;
        Color couleurDeFond = new Color(0xFFEB62); 



        //setPreferredSize(new Dimension(800, 600)); 

        // Création panel pour le text (les champs à remplir)
        JPanel champsPanel = new JPanel(null);
        champsPanel.setPreferredSize(new Dimension(800, 450));

        // TXT TARIF
        txtTarif = new JLabel("Acheter un billet");
        txtTarif.setFont(new Font("Arial", Font.BOLD, 20)); 
        txtTarif.setBounds(660, 50, 250, heightBouton);
        add(txtTarif);
        

        // TXT ETUDIANT
        txtEtudiant = new JLabel(" Etudiant ");

        txtEtudiant.setOpaque(true);
        txtEtudiant.setBackground(couleurDeFond);
        txtEtudiant.setFont(new Font("Arial", Font.BOLD, 16)); 
        txtEtudiant.setBounds(640, 150, 140, heightBouton);
        add(txtEtudiant);

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

        // BOUTON Panier
        boutonPanier = new JButton("Ajouter au panier");
        personnaliserBouton(boutonPanier);
        boutonPanier.setBounds(1000, 500, 200, heightBouton);
        add(boutonPanier);

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
        
                // Appel de la méthode dans le contrôleur pour traiter la sélection
                TarifsControleur.traiterSelectionBoutonRadio(selection);
            }
        });
    }

    private void personnaliserBouton(JButton bouton) {
        bouton.setForeground(Color.WHITE);
        bouton.setBackground(Color.BLACK);
        bouton.setPreferredSize(new Dimension(120, 60));
        bouton.setFocusPainted(false);
    }
    

    
    
    public void setboutonPanierListener(ActionListener listener) {
        System.out.println("Panier PRESSE");
        boutonPanier.addActionListener(listener);
    }


    // A CHANGER AVEC LA METHODE DE VICOS
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Page de Tarifs Connecté");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1200, 600);
            frame.setLocationRelativeTo(null);

            PageTarifsConnecte pageTarifsConnecte = new PageTarifsConnecte();
            frame.add(pageTarifsConnecte);

            frame.setVisible(true);
        });
    }
    // TEST CHANGEMENT
    
}
