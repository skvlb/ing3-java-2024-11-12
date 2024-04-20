package Controleur;
import Modele.*;
import java.util.List;
import java.util.ArrayList;
import Modele.DAO.DaoFactory;
import Modele.DAO.TypeClientDAO;
public class TarifsControleur {
    public static void traiterSelectionBoutonRadio(String selection) {
        DaoFactory daoFactory = DaoFactory.getInstance();
        TypeClientDAO typeClientDao = daoFactory.getTypeClientDAO();
        double prix = 10;
        List <TypeClient> liste_types = new ArrayList();
        liste_types=typeClientDao.listerTypesClients();//on liste tout les types disponibles de notre BDD
        for(int i=0;i<liste_types.size();i++){
            if(liste_types.get(i).getDescription().equals(selection)){//on regarde si un des types de la liste correspond à celui sélectionné
                
            }
        }
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




            // CHANGER DE PAGE (Page paiement)

        }
        else{
            // Rien Faire
        }
    }
}
