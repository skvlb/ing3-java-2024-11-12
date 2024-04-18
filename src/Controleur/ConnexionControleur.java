package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import Modele.DAO.DaoFactory;
import Modele.DAO.UtilisateurDAO;
import Vue.PageConnexion;
import Vue.Page_Creation_utilisateur;

public class ConnexionControleur {

    DaoFactory daoFactory = DaoFactory.getInstance();
    UtilisateurDAO utilisateurDAO = daoFactory.getUtilisateurDAO();

    private PageConnexion pageConnexion;

    public ConnexionControleur(PageConnexion pageConnexion) {
        this.pageConnexion = pageConnexion;
        this.pageConnexion.setBoutonValiderListener(new BoutonValiderListener());
        this.pageConnexion.setBoutonCreationListener(new BoutonCreationListener());

    }


    // LISTENER ET AUTRE A VERIFIER 
    
    class BoutonCreationListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(("BOUTON CREATION COMPTE CLIQUe"));
            Page_Creation_utilisateur pageCreationUtilisateur = new Page_Creation_utilisateur();
            pageCreationUtilisateur.setVisible(true); 
        }
    }
    
    // JUSQUE ICI


    class BoutonValiderListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Récupérer les valeurs des champs de texte
            String email = pageConnexion.getEmail();
            String motDePasse = pageConnexion.getMotDePasse();

            // Appeler votre méthode de vérification de mot de passe
            boolean motDePasseCorrect = verifierMotDePasse(email, motDePasse);
            
            // Faire quelque chose en fonction du résultat
            if (motDePasseCorrect == true) {
                // Mot de passe correct, peut-être ouvrir une nouvelle fenêtre
                System.out.println("Mot de passe correct");
            } else {
                // Mot de passe incorrect, afficher un message d'erreur par exemple
                System.out.println("Mot de passe incorrect");
            }
        }

        
    }

    // Méthode pour vérifier le mot de passe
    private boolean verifierMotDePasse(String email, String motDePasse) {
        
        boolean u = utilisateurDAO.verifierMotDePasse(email, motDePasse);
        if (u==false){
            return false;
        }
        else{
            return true;       
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                PageConnexion view = new PageConnexion();
                ConnexionControleur controller = new ConnexionControleur(view);
                view.setVisible(true);
            }
        });
    }
}