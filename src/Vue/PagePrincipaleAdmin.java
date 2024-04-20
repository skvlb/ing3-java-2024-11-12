package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PagePrincipaleAdmin extends JFrame {
    private BordereauAdmin bordereauAdmin;
    private JButton boutonAjouterProg, boutonSupprimerProg;
    private JPanel panelCentral;

    public PagePrincipaleAdmin() {
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
    
        initializeCenterPanel(); // Appel initiale pour configurer le panel central
    }

    private void afficherAjouterProgrammation() {
        // Code pour afficher la page AjouterProgrammation
        System.out.println("Affichage de la page pour ajouter une programmation");
        PageCreationProgrammation pageCreation = new PageCreationProgrammation();
        changePanel(pageCreation);
    }

    private void afficherSupprimerProgrammation() {
        // Code pour afficher la page SupprimerProgrammation
        System.out.println("Affichage de la page pour supprimer une programmation");
    }

    public void afficherPagePrincipale() {
        // Réinitialisation de panelCentral avec les boutons et autres éléments initiaux
        JPanel pagePrincipale = new JPanel();
        pagePrincipale.setLayout(null);
        pagePrincipale.setBackground(new Color(0x123456));
        pagePrincipale.setBounds(0, 175, 1920, 905);
    
        // Boutons pour les actions d'administration
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

    public void initializeCenterPanel() {
        panelCentral.removeAll(); // Nettoie le panel pour éviter des doublons
    
        // Boutons pour les actions d'administration
        JButton boutonAjouterProg = new JButton("Ajouter une programmation");
        boutonAjouterProg.setBounds(710, 300, 250, 50); // Position arbitraire
        panelCentral.add(boutonAjouterProg);
    
        JButton boutonSupprimerProg = new JButton("Supprimer une programmation");
        boutonSupprimerProg.setBounds(710, 400, 250, 50); // Position arbitraire
        panelCentral.add(boutonSupprimerProg);
    
        // Ajout des action listeners aux boutons
        boutonAjouterProg.addActionListener(e -> afficherAjouterProgrammation());
        boutonSupprimerProg.addActionListener(e -> afficherSupprimerProgrammation());
    
        panelCentral.revalidate();
        panelCentral.repaint();
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