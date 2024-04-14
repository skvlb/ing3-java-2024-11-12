package Vue;

import javax.swing.*;


public class BordereauSite extends JPanel {


    public BordereauSite() {
        JLabel logoLabel = new JLabel("Logo");
        JButton accueilButton = new JButton("Accueil");
        JButton reservationButton = new JButton("Réservation");
        JButton profilButton = new JButton("Profil");

        add(logoLabel);
        add(accueilButton);
        add(reservationButton);
        add(profilButton);
    }

}
