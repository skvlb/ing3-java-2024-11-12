package Controleur;
import Modele.*;
import java.util.List;
import java.util.ArrayList;
import Modele.DAO.DaoFactory;
import Modele.DAO.UtilisateurDAO;
import Modele.Billet;
import java.util.Random;
public class TarifsControleur{
    public static void traiterSelectionBoutonRadio(String selection) {
        DaoFactory daoFactory = DaoFactory.getInstance();
        UtilisateurDAO utilisateurDAO = daoFactory.getUtilisateurDAO();
        double prix = 20;
        String email="a";
        int id = utilisateurDAO.getIdUtilisateurParEmail(email);
        System.out.println("id utilisateur:"+id);
        if(!selection.equals("")){
            System.out.println("Sélection du bouton radio : " + selection);
            
            // Enfant, Etudiant et Normal

            if(selection.equals("Etudiant")){
                prix = prix * 0.75;
            }
            else if(selection.equals("Enfant")){
                prix = prix * 0.5;
            }
            System.out.println(selection + "    :   " + prix);
            // Création des billets
            List<Billet> billets = new ArrayList<>();
            int idProgrammation=4;//exemple mais on devra le récupérer des pages précèdente
            // Exemple de création d'un billet avec la sélection comme type
            Random random = new Random();
            int id_billet = random.nextInt(10000) + 1;
            Billet billet = new Billet(id_billet, id, idProgrammation, prix, false);
            billets.add(billet);
            // Ajout des billets à la base de données
            for (Billet b : billets) {
                daoFactory.getBilletDAO().ajouterBillet(b);
            }
            
        }
        else{
            // Rien Faire
        }
    }
}
