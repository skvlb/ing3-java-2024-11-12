package Controleur;

import Vue.PagePrincipale;

public class Main {

    public static void main(String[] args) {
        PagePrincipale pagePrincipale = new PagePrincipale();

        // Afficher la page de connexion au démarrage
        pagePrincipale.afficherPageConnexion();

        // Rendre la page principale visible
        pagePrincipale.setVisible(true);
        
    }
    
}
