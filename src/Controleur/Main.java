package Controleur;

import Modele.*;
import Modele.DAO.BilletDAO;
import Modele.DAO.DaoFactory;
import Vue.PagePrincipale;

public class Main {

    public static void main(String[] args) {

        DaoFactory daoFactory = DaoFactory.getInstance();
        Billet billet = new Billet(12, 1, 1, 1, 12.0, false);
        BilletDAO billetDAO = daoFactory.getBilletDAO();
        billetDAO.ajouterBillet(billet);
        //PagePrincipale pagePrincipale = new PagePrincipale();

        // Afficher la page de connexion au démarrage
        //pagePrincipale.afficherPageConnexion();

        // Rendre la page principale visible
        //pagePrincipale.setVisible(true);
        
    }
    
}
