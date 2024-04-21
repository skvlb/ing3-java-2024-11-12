package Vue;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Modele.DAO.DaoFactory;
import Modele.DAO.FilmDAO;


public class PageCreationProgrammation extends JPanel {
    private JLabel lblCreation, lblHeureDebut, lblHeureFin, lblDate, lblSalle;
    private JTextField txtDate, txtHeureDebut, txtHeureFin;
    private JButton btnValider;
    private JComboBox<String> cbxSalles, cbxFilms;

    public PageCreationProgrammation() {
        setLayout(null);
                
        JPanel panelAffichage = new JPanel();
        panelAffichage.setLayout(null);
        //panelAffichage.setBackground(new Color(0x123456));  //FFEB62
        panelAffichage.setBounds(0,0,1600,700);

        try {
            Image img = ImageIO.read(new File("images/logo/engrenage.png"));
            System.out.println("Image chargée");
            Image resizedImg = img.getScaledInstance(1600, 700, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(resizedImg);
            JLabel background = new JLabel(icon);
            background.setBounds(0, 0, 1600, 700);
            panelAffichage.add(background);
        } catch (IOException e) {
            e.printStackTrace();
        }


        JPanel creationProg = new JPanel();
        creationProg.setLayout(null);
        creationProg.setBackground(new Color(0xFFEB62));
        creationProg.setBounds(600,20,320,50);

        lblCreation = new JLabel("Création d'une programmation");
        lblCreation.setFont(new Font("Arial", Font.BOLD, 20));
        lblCreation.setBounds(5, 5, 300, 40);
        creationProg.add(lblCreation);

        add(creationProg);

        
        // PANEL DATE
        JPanel date = new JPanel();
        date.setLayout(null);
        date.setBackground(new Color(0xFFEB62));
        date.setBounds(425,150,250,40);

        //LABEL DATE
        lblDate = new JLabel("Date:");
        lblDate.setBounds(5, 5, 100, 30);
        date.add(lblDate);

        // TEXTE DATE
        txtDate = new JTextField();
        txtDate.setBounds(110, 5, 120, 30);
        date.add(txtDate);

        add(date);



        // PANEL HEURE DEBUT
        JPanel heureDebut = new JPanel();
        heureDebut.setLayout(null);
        heureDebut.setBackground(new Color(0xFFEB62));
        heureDebut.setBounds(425,250,250,40);

        // LABEL HEURE DEBUT
        lblHeureDebut = new JLabel("Heure de début:");
        lblHeureDebut.setBounds(5, 5, 100, 30);
        heureDebut.add(lblHeureDebut);

        // TEXTE DEBUT
        txtHeureDebut = new JTextField();
        txtHeureDebut.setBounds(110, 5, 120, 30);
        heureDebut.add(txtHeureDebut);

        add(heureDebut);


        // PANEL HEURE FIN
        JPanel heureFin = new JPanel();
        heureFin.setLayout(null);
        heureFin.setBackground(new Color(0xFFEB62));
        heureFin.setBounds(425,350,250,40);


        // LABEL FIN
        lblHeureFin = new JLabel("Heure de fin:");
        lblHeureFin.setBounds(5, 5, 100, 30);
        heureFin.add(lblHeureFin);

        // TEXTE FIN
        txtHeureFin = new JTextField();
        txtHeureFin.setBounds(110, 5, 120, 30);
        heureFin.add(txtHeureFin);

        add(heureFin);


        // PANEL SALLE
        JPanel selectionSalle = new JPanel();
        selectionSalle.setLayout(null);
        selectionSalle.setBackground(new Color(0xFFEB62));
        selectionSalle.setBounds(800,200,250,40);

        // LABEL SALLE
        lblSalle = new JLabel("Numéro de salle:");
        lblSalle.setBounds(5, 5, 100, 30);
        selectionSalle.add(lblSalle);

        // TEXTE SALLE
        String[] salles = {"1", "2", "3", "4", "5"};
        cbxSalles = new JComboBox<>(salles);
        cbxSalles.setBounds(110, 5, 120, 30);
        selectionSalle.add(cbxSalles);

        add(selectionSalle);


        // PANEL FILM
        JPanel selectionFilm = new JPanel();
        selectionFilm.setLayout(null);
        selectionFilm.setBackground(new Color(0xFFEB62));
        selectionFilm.setBounds(800,300,250,40);

        // LABEL FILM
        FilmDAO filmDAO = DaoFactory.getInstance().getFilmDAO();
        List<String> titres = new ArrayList<>();
        titres=filmDAO.obtenirTitresDesFilms();
        String[] tableau = new String[titres.size()];
    
        titres.toArray(tableau);
        String[] films = tableau;
        cbxFilms = new JComboBox<>(films);
        cbxFilms.setBounds(5, 5, 220, 30);
        selectionFilm.add(cbxFilms);

        add(selectionFilm);


        // BOUTON VALIDER
        btnValider = new JButton("Valider");
        personnaliserBouton(btnValider);
        btnValider.setBounds(675, 450, 125, 60);

        

        add(btnValider);
        add(panelAffichage);


    }
    
    
    
    private void personnaliserBouton(JButton bouton) {
        bouton.setForeground(Color.WHITE);
        bouton.setBackground(Color.BLACK);
        bouton.setPreferredSize(new Dimension(120, 60));
        bouton.setFocusPainted(false);
    }
    public void setValiderListener(ActionListener listener) {
        btnValider.addActionListener(listener);
    }

    // méthodes pour récupérer les données saisies
    public String getDate() {
        return txtDate.getText();
    }

    public String getHeureDebut() {
        return txtHeureDebut.getText();
    }

    public String getHeureFin() {
        return txtHeureFin.getText();
    }

    public String getNomFilm() {
        return (String) cbxFilms.getSelectedItem();
    }

    public String getNumeroSalle() {
        return (String) cbxSalles.getSelectedItem();
    }
}