package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Modele.Billet;
import Modele.Programmation;
import Modele.DAO.BilletDaoImpl;
import Modele.DAO.DaoFactory;
import Modele.DAO.ProgrammationDaoImpl;
import Modele.DAO.UtilisateurDaoImpl;

public class PanierPage extends JPanel {
    private DaoFactory daoFactory;
    private int siegeNumero;
    public PanierPage(Billet billet, DaoFactory daoFactory,int siegeNumero) {
        this.daoFactory = daoFactory;
        this.siegeNumero = siegeNumero;
        setupUI(billet);
    }

    private void setupUI(Billet billet) {
        
        setLayout(null); 
        
        //  UtilisateurDao pour récupérer l'email de l'utilisateur via son ID
        UtilisateurDaoImpl utilisateurDao = new UtilisateurDaoImpl(daoFactory);
        String email = utilisateurDao.getEmailUtilisateurParId(billet.getId_client());
        
        //ProgrammationDao pour récupérer les détails de la programmation
        ProgrammationDaoImpl programmationDao = new ProgrammationDaoImpl(daoFactory);
        Programmation programmation = programmationDao.getProgrammationParId(billet.getId_programmation());
        
        // ##########################################################################

        JPanel panelAffichage = new JPanel();
        panelAffichage.setLayout(null);
        panelAffichage.setBackground(new Color(0x00FF00));  //FFEB62
        panelAffichage.setBounds(10,10,1500,625);

        JLabel labelTitre = new JLabel("Récapitulatif du payement");
        labelTitre.setFont(new Font("Arial", Font.BOLD, 20));
        labelTitre.setBounds(600, 5, 300, 50);
        panelAffichage.add(labelTitre);



        JLabel labelEmail = new JLabel("Email Client: " + email);
        labelEmail.setBounds(530,100,200,50);
        panelAffichage.add(labelEmail);

        JLabel labelFilm = new JLabel("Film: " + programmation.getFilmId());
        labelFilm.setBounds(530,200,200,50);
        panelAffichage.add(labelFilm);

        JLabel labelDate = new JLabel("Date: " + programmation.getDate().toString());
        labelDate.setBounds(530,300,200,50);
        panelAffichage.add(labelDate);

        JLabel labelHeure = new JLabel("Heure de début: " + programmation.getHeureDebut().toString());
        labelHeure.setBounds(530,400,200,50);
        panelAffichage.add(labelHeure);

        JLabel labelSalle = new JLabel("Salle: " + programmation.getSalleId());
        labelSalle.setBounds(830,150,200,50);
        panelAffichage.add(labelSalle);

        JLabel labelSiege = new JLabel("Siège N°: " + siegeNumero);
        labelSiege.setBounds(830,250,200,50);
        panelAffichage.add(labelSiege);

        JLabel labelPrix = new JLabel("Prix: " + billet.getPrix() + " EUR");
        labelPrix.setBounds(830,350,200,50);
        panelAffichage.add(labelPrix);

        JButton boutonValiderAchat = new JButton("Valider l'achat");
        personnaliserBouton(boutonValiderAchat);
        boutonValiderAchat.addActionListener(e -> validerAchat(billet));
        boutonValiderAchat.setBounds(700,500,120,50);
        panelAffichage.add(boutonValiderAchat);

        add(panelAffichage);


    }

    private void personnaliserBouton(JButton bouton) {
        bouton.setForeground(Color.WHITE);
        bouton.setBackground(Color.BLACK);
        bouton.setPreferredSize(new Dimension(120, 60));
        bouton.setFocusPainted(false);
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
