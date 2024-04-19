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
    private DaoFactory daoFactory = DaoFactory.getInstance();
    private UtilisateurDAO utilisateurDAO = daoFactory.getUtilisateurDAO();
    private Page_Creation_utilisateur pageCreation;

    public CreationControleur(Page_Creation_utilisateur pageCreation) {
        this.pageCreation = pageCreation;
        addActionListeners();
    }

    private void addActionListeners() {
        pageCreation.setBoutonValiderListener(new ActionListener() { // Correction ici
            @Override
            public void actionPerformed(ActionEvent e) {
               if(pageCreation.areAllFieldsFilled())
               { System.out.println("Bouton Valider cliqué");
                String email = pageCreation.getEmail();
                String nom = pageCreation.getNom();
                String prenom = pageCreation.getPrenom();
                String telephone = pageCreation.getTelephone();
                String mdp = pageCreation.getMotDePasse();

                System.out.println("Données récupérées: " + email + ", " + nom + ", " + prenom);
                try {
                    CreerClient(nom, prenom, mdp, email, telephone, null);
                    System.out.println("Utilisateur ajouté avec succès.");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.out.println("Erreur lors de l'ajout de l'utilisateur.");
                }
            }else { System.out.println("Veuillez remplir tous les champs");}
            }
        });
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
            view.setVisible(true);
        });
    }
}
