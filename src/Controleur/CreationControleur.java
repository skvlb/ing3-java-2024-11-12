package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.SwingUtilities;

import Modele.Client;
import Modele.TypeClient;
import Modele.DAO.DaoFactory;
import Modele.DAO.UtilisateurDAO;
import Vue.Page_Creation_utilisateur;

public class CreationControleur {
    DaoFactory daoFactory = DaoFactory.getInstance();
    UtilisateurDAO utilisateurDAO = daoFactory.getUtilisateurDAO();
    private Page_Creation_utilisateur pageCreation;

    public CreationControleur(Page_Creation_utilisateur pageCreation) {
        this.pageCreation = pageCreation;
        this.pageCreation.setboutonValiderTestListener(new BoutonCreationListener());
    }
    

    class BoutonCreationListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("ActionListener activé"); // Log pour debug
            
            String nom = pageCreation.getNom();
            String prenom = pageCreation.getPrenom();
            String email = pageCreation.getEmail();
            String telephone = pageCreation.getTelephone();
            String mdp = pageCreation.getMotDePasse();
            System.out.println("Données récupérées: " + email + ", " + nom + ", " + prenom); // Autre log pour debug
            
            try {
                CreerClient(nom, prenom, mdp, email, telephone, null);
                System.out.println("Utilisateur ajouté avec succès.");
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("Erreur lors de l'ajout de l'utilisateur.");
            }
        }
    }
        
        private void CreerClient(String nom, String prenom, String mdp, String email, String telephone, TypeClient typeClient) {
            Random random = new Random();
            int id = random.nextInt(10000) + 1;
            Client client = new Client(id, nom, prenom, email, mdp, telephone, typeClient);
            utilisateurDAO.ajouterUtilisateur(client);
        }
    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Page_Creation_utilisateur view = new Page_Creation_utilisateur();
            CreationControleur controller = new CreationControleur(view);
            //view.setboutonValiderTestListener(controller.new BoutonCreationListener());

            view.setVisible(true);
        });
    }
    
    
    
}
