package Controleur;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import javax.swing.SwingUtilities;

import Modele.DAO.DaoFactory;
import Modele.DAO.UtilisateurDAO;
import Vue.PageConnexion;
import Vue.PagePrincipale;
import Vue.Page_Creation_utilisateur;
import Vue.PagePrincipaleAdmin;
import Vue.PageCreationProgrammation;

public class ConnexionControleur {

    DaoFactory daoFactory = DaoFactory.getInstance();
    UtilisateurDAO utilisateurDAO = daoFactory.getUtilisateurDAO();

    private PageConnexion pageConnexion;
    private PagePrincipale mainFrame;

    public ConnexionControleur(PageConnexion pageConnexion,PagePrincipale mainFrame) {
        this.mainFrame = mainFrame;
        this.pageConnexion = pageConnexion;
        this.pageConnexion.setBoutonValiderListener(new BoutonValiderListener());
        this.pageConnexion.setBoutonCreationListener(new BoutonCreationListener());

    }


    // LISTENER ET AUTRE A VERIFIER 
    
    class BoutonCreationListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {;
            Page_Creation_utilisateur pageCreationUtilisateur = new Page_Creation_utilisateur();
            CreationControleur creationControleur = new CreationControleur(pageCreationUtilisateur);
            mainFrame.changePanel(pageCreationUtilisateur);
        }
    }
    
    // JUSQUE ICI


    class BoutonValiderListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Bouton Valider cliqué");
            String email = pageConnexion.getEmail();
            String motDePasse = pageConnexion.getMotDePasse();

            //vérification de mot de passe
            boolean motDePasseCorrect = verifierMotDePasse(email, motDePasse);
            
            
            if (motDePasseCorrect == true) {
                String verif=null;
                // si mdp correct
                utilisateurDAO.setConnection(email,true);
                System.out.println("Vous êtes connecté");
                mainFrame.setConnectedUserEmail(email);
                mainFrame.invalidate(); 
                mainFrame.validate();   
                mainFrame.repaint();    
                verif=utilisateurDAO.getTypeUtilisateurParEmail(email);
                System.out.println(verif);
                if(verif.equals("employe")){
                    PageCreationProgrammation pageCreationProgrammation = new PageCreationProgrammation();
                    EmployeControleur employeControleur = new EmployeControleur(pageCreationProgrammation);
                    PagePrincipaleAdmin pagePrincipaleAdmin = new PagePrincipaleAdmin(employeControleur);
                    mainFrame.dispose(); // Fermez la fenêtre de connexion / principale actuelle
                    pagePrincipaleAdmin.setVisible(true); // Affichez la page d'administration
                    System.out.println("Effectuer redirection vers Page Employe");
                    
                }
            } else {
                // Mot de passe incorrect, afficher un message d'erreur par exemple
                System.out.println("Mot de passe incorrect");
            }
        }

        
    }

    // méthode pour checker mdp
    private boolean verifierMotDePasse(String email, String motDePasse) {
        
        boolean u = utilisateurDAO.verifierMotDePasse(email, motDePasse);
        if (u==false){
            return false;
        }
        else{
            return true;
        }
    }


}