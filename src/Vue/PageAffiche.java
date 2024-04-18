package Vue;

import javax.swing.*;
import java.awt.*;

public class PageAffiche extends JPanel {
    private JPanel panneauPrincipal;
    private JScrollPane defilement;

    public PageAffiche() {
        setLayout(new BorderLayout());
        setBackground(Color.LIGHT_GRAY);

        // Panneau principal contenant toutes les lignes de film
        panneauPrincipal = new JPanel();
        panneauPrincipal.setLayout(new BoxLayout(panneauPrincipal, BoxLayout.Y_AXIS));

        // Ajout des films avec leur descriptions
        ajouterFilmAvecDescription("images/affiches_film/tourmontparnasse.png", "Tour Montparnasse Infernale: Une comédie culte française...");
        ajouterFilmAvecDescription("images/affiches_film/dune.png", "Dune: Adaptation du célèbre roman de science-fiction...");
        ajouterFilmAvecDescription("images/affiches_film/sosfantome.png", "SOS Fantômes: Le retour des chasseurs de fantômes...");
        
        // Défilement qui contient le panneau principal
        defilement = new JScrollPane(panneauPrincipal);
        defilement.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        defilement.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Ajout du défilement au panneau
        add(defilement, BorderLayout.CENTER);

        
    }

    private void ajouterFilmAvecDescription(String cheminImage, String description) {
        // Création du panneau pour une ligne de film
        JPanel ligneFilm = new JPanel();
        ligneFilm.setLayout(new BoxLayout(ligneFilm, BoxLayout.X_AXIS));
        ligneFilm.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Ajout de l'affiche du film
        ImageIcon icone = new ImageIcon(new ImageIcon(cheminImage).getImage().getScaledInstance(150, 225, Image.SCALE_SMOOTH));
        JLabel etiquetteFilm = new JLabel(new ImageIcon(icone.getImage()));
        ligneFilm.add(etiquetteFilm);

        // Ajout de la description du film
        JTextArea texteDescription = new JTextArea(description);
        texteDescription.setLineWrap(true);
        texteDescription.setWrapStyleWord(true);
        texteDescription.setEditable(false);
        texteDescription.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        texteDescription.setBackground(Color.LIGHT_GRAY);

        // Ajuster la taille de la zone de texte en fonction du contenu
        texteDescription.setPreferredSize(new Dimension(300, 225));
        ligneFilm.add(texteDescription);

        // Ajout de la ligne de film au panneau principal
        panneauPrincipal.add(ligneFilm);
    }
}
