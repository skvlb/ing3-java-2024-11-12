package Vue;

import Modele.Billet;
import Modele.Programmation;
import Modele.DAO.BilletDaoImpl;
import Modele.DAO.DaoFactory;
import Modele.DAO.ProgrammationDaoImpl;
import Modele.DAO.UtilisateurDaoImpl;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class PanierPage extends JPanel {
    private DaoFactory daoFactory;
    private int siegeNumero;
    public PanierPage(Billet billet, DaoFactory daoFactory,int siegeNumero) {
        this.daoFactory = daoFactory;
        this.siegeNumero = siegeNumero;
        setupUI(billet);
    }

    private void setupUI(Billet billet) {
        setLayout(new GridLayout(7, 1, 10, 10)); 
        setBackground(Color.WHITE);
        
        //  UtilisateurDao pour récupérer l'email de l'utilisateur via son ID
        UtilisateurDaoImpl utilisateurDao = new UtilisateurDaoImpl(daoFactory);
        String email = utilisateurDao.getEmailUtilisateurParId(billet.getId_client());
        
        //ProgrammationDao pour récupérer les détails de la programmation
        ProgrammationDaoImpl programmationDao = new ProgrammationDaoImpl(daoFactory);
        Programmation programmation = programmationDao.getProgrammationParId(billet.getId_programmation());
        
        add(new JLabel("Email Client: " + email));
        add(new JLabel("Film: " + programmation.getFilmId())); 
        add(new JLabel("Date: " + programmation.getDate().toString()));
        add(new JLabel("Heure de début: " + programmation.getHeureDebut().toString()));
        add(new JLabel("Salle: " + programmation.getSalleId()));
        add(new JLabel("Siège N°: " + siegeNumero)); 
        add(new JLabel("Prix: " + billet.getPrix() + " EUR"));

        JButton validerAchatButton = new JButton("Valider l'achat");
        validerAchatButton.addActionListener(e -> validerAchat(billet));
        add(validerAchatButton);
    }

    private void validerAchat(Billet billet) {
        int randomBilletId = genererIdBilletAleatoire();
        billet.setId_billet(randomBilletId);
        BilletDaoImpl billetDao = new BilletDaoImpl(daoFactory);
        billetDao.ajouterBillet(billet);
        JOptionPane.showMessageDialog(this, "Achat validé ");
    }

    private int genererIdBilletAleatoire() {
        Random rand = new Random();
        int randomId = rand.nextInt(Integer.MAX_VALUE);
        return randomId;
    }
}
