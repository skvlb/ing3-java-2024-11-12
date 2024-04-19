package Controleur;

public class TarifsControleur {
    public static void traiterSelectionBoutonRadio(String selection) {
        double prix = 10;
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
