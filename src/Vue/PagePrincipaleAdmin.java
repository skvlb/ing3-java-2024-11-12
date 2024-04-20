package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controleur.EmployeControleur;

public class PagePrincipaleAdmin extends JFrame {
    private BordereauAdmin bordereauAdmin;
    private JPanel panelCentral;
    private EmployeControleur employeControleur;

    public PagePrincipaleAdmin(EmployeControleur employeControleur) {
        this.employeControleur = employeControleur;
        setTitle("Administration - GAUMONT Pathé");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(0x123456));

        // Bordereau pour l'administrateur
        bordereauAdmin = new BordereauAdmin(this);
        bordereauAdmin.setBounds(0, 0, 1920, 175);
        add(bordereauAdmin);

        // Panneau central où les autres panneaux seront affichés
        panelCentral = new JPanel();
        panelCentral.setBounds(0, 175, 1920, 905);
        panelCentral.setBackground(new Color(0x123456));
        panelCentral.setLayout(null);
        add(panelCentral);

        initializeCenterPanel(); // Appel initial pour configurer le panel central
    }

    private void afficherAjouterProgrammation() {
        System.out.println("Affichage de la page pour ajouter une programmation");
    PageCreationProgrammation pageCreation = new PageCreationProgrammation();
    EmployeControleur employeControleur = new EmployeControleur(pageCreation);
    changePanel(pageCreation);
    }

    private void afficherSupprimerProgrammation() {
        System.out.println("Affichage de la page pour supprimer une programmation");
        // Ici, vous pourriez créer et afficher une page pour supprimer une programmation
    }

    public void afficherPagePrincipale() {
        JPanel pagePrincipale = new JPanel();
        pagePrincipale.setLayout(null);
        pagePrincipale.setBackground(new Color(0x123456));
        pagePrincipale.setBounds(0, 175, 1920, 905);

        JLabel txtAction = new JLabel("Que voulez-vous faire? ");
        txtAction.setFont(new Font("Arial", Font.BOLD, 20));
        txtAction.setBounds(700, 150, 250, 60);
        pagePrincipale.add(txtAction);

        JButton boutonAjouterProg = new JButton("Ajouter une programmation");
        personnaliserBouton(boutonAjouterProg);
        boutonAjouterProg.setBounds(675, 250, 250, 60);
        pagePrincipale.add(boutonAjouterProg);

        JButton boutonSupprimerProg = new JButton("Supprimer une programmation");
        personnaliserBouton(boutonSupprimerProg);
        boutonSupprimerProg.setBounds(675, 350, 250, 60);
        pagePrincipale.add(boutonSupprimerProg);


        JButton boutonRetourAccueil = new JButton("Retour à l'accueil");
        personnaliserBouton(boutonRetourAccueil);
        boutonRetourAccueil.setBounds(675, 450, 250, 60);
        pagePrincipale.add(boutonRetourAccueil);

        boutonAjouterProg.addActionListener(e -> afficherAjouterProgrammation());
        boutonSupprimerProg.addActionListener(e -> afficherSupprimerProgrammation());
        boutonRetourAccueil.addActionListener(e -> retourAccueil());

        changePanel(pagePrincipale);
    }

    private void personnaliserBouton(JButton bouton) {
        bouton.setForeground(Color.WHITE);
        bouton.setBackground(Color.BLACK);
        bouton.setPreferredSize(new Dimension(120, 60));
        bouton.setFocusPainted(false);
    }

    private void initializeCenterPanel() {
        panelCentral.removeAll(); // Nettoyer le panel pour éviter des doublons
        afficherPagePrincipale(); // Utilisez cette méthode pour réinitialiser le contenu central
    }

    public void changePanel(JPanel newPanel) {
        getContentPane().remove(panelCentral);
        panelCentral = newPanel;
        panelCentral.setBounds(0, 175, 1920, 905);
        getContentPane().add(panelCentral);
        getContentPane().revalidate();
        getContentPane().repaint();
    }
    private void retourAccueil() {

        PagePrincipale pagePrincipale = new PagePrincipale();
        // Fermer la page Admin
        dispose();
    }
}