package Vue;

import javax.swing.*;

import Modele.DAO.FilmDAO;

import java.awt.Font;
import java.awt.event.ActionListener;
import Modele.DAO.*;
import java.util.List;
import java.util.ArrayList;

public class PageCreationProgrammation extends JPanel {
    private JLabel lblCreation, lblHeureDebut, lblHeureFin, lblDate, lblSalle;
    private JTextField txtDate, txtHeureDebut, txtHeureFin;
    private JButton btnValider;
    private JComboBox<String> cbxSalles, cbxFilms;

    public PageCreationProgrammation() {
        // Utilisation de null layout pour un positionnement manuel
        setLayout(null);
        
        // Initialisation des composants
        lblCreation = new JLabel("Création d'une programmation");
        lblCreation.setFont(new Font("Arial", Font.BOLD, 20));
        lblCreation.setBounds(600, 50, 300, 30);
        add(lblCreation);

        lblDate = new JLabel("Date:");
        lblDate.setBounds(500, 150, 80, 25);
        add(lblDate);

        txtDate = new JTextField();
        txtDate.setBounds(600, 150, 120, 25);
        add(txtDate);

        lblHeureDebut = new JLabel("Heure de début:");
        lblHeureDebut.setBounds(470, 250, 120, 25);
        add(lblHeureDebut);

        txtHeureDebut = new JTextField();
        txtHeureDebut.setBounds(600, 250, 120, 25);
        add(txtHeureDebut);

        lblHeureFin = new JLabel("Heure de fin:");
        lblHeureFin.setBounds(470, 350, 120, 25);
        add(lblHeureFin);

        txtHeureFin = new JTextField();
        txtHeureFin.setBounds(600, 350, 120, 25);
        add(txtHeureFin);

        lblSalle = new JLabel("Numéro de salle:");
        lblSalle.setBounds(450, 450, 150, 25);
        add(lblSalle);

        String[] salles = {"1", "2", "3", "4", "5"};
        cbxSalles = new JComboBox<>(salles);
        cbxSalles.setBounds(600, 450, 120, 25);
        add(cbxSalles);

        FilmDAO filmDAO = DaoFactory.getInstance().getFilmDAO();
        List<String> titres = new ArrayList<>();
        titres=filmDAO.obtenirTitresDesFilms();
        String[] tableau = new String[titres.size()];
    
    // Copier les éléments de la liste dans le tableau
        titres.toArray(tableau);
        String[] films = tableau;
        cbxFilms = new JComboBox<>(films);
        cbxFilms.setBounds(1000, 150, 200, 25);
        add(cbxFilms);

        btnValider = new JButton("Valider");
        btnValider.setBounds(850, 450, 100, 30);
        add(btnValider);
    }

    // Méthode pour attacher un ActionListener au bouton de validation
    public void setValiderListener(ActionListener listener) {
        btnValider.addActionListener(listener);
    }

    // Méthodes pour récupérer les données saisies
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
