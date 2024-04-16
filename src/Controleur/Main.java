package Controleur;

import Modele.*;
import Modele.DAO.BilletDAO;
import Modele.DAO.DaoFactory;
import Vue.*;

public class Main {

    public static void main(String[] args) {

        //DaoFactory daoFactory = DaoFactory.getInstance();
        //Billet billet = new Billet(12, 1, 1, 1, 12.0, false);
        //BilletDAO billetDAO = daoFactory.getBilletDAO();
        //billetDAO.ajouterBillet(billet);
        PageAccueil pageaccueil = new PageAccueil();
        
        // Rendre la page principale visible
        pageaccueil.setVisible(true);
        
    }
    
}
