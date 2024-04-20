package Vue;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Controleur.EmployeControleur;
import Vue.PageCreationProgrammation;

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

        JButton boutonAjouterProg = new JButton("Ajouter une programmation");
        boutonAjouterProg.setBounds(710, 300, 250, 50);
        pagePrincipale.add(boutonAjouterProg);

        JButton boutonSupprimerProg = new JButton("Supprimer une programmation");
        boutonSupprimerProg.setBounds(710, 400, 250, 50);
        pagePrincipale.add(boutonSupprimerProg);

        boutonAjouterProg.addActionListener(e -> afficherAjouterProgrammation());
        boutonSupprimerProg.addActionListener(e -> afficherSupprimerProgrammation());

        changePanel(pagePrincipale);
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
}
