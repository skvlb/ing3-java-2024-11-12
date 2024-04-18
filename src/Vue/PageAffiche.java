package Vue;

import Modele.Film;
import Modele.DAO.FilmDaoImpl;
import Modele.DAO.DaoFactory;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PageAffiche extends JPanel {
    private JPanel panneauPrincipal;
    private JScrollPane defilement;
    private DaoFactory daoFactory;
    private FilmDaoImpl filmDao;

    public PageAffiche(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
        this.filmDao = new FilmDaoImpl(daoFactory);
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new BorderLayout());
        setBackground(Color.LIGHT_GRAY);

        // Création du panneau principal pour l'affichage des films
        panneauPrincipal = new JPanel();
        panneauPrincipal.setLayout(new BoxLayout(panneauPrincipal, BoxLayout.Y_AXIS));
        List<Film> films = filmDao.getAllFilms();

        for (Film film : films) {
            panneauPrincipal.add(createFilmPanel(film));
        }

        // Création d'un JScrollPane pour gérer les défilements
        defilement = new JScrollPane(panneauPrincipal);
        defilement.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        defilement.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(defilement, BorderLayout.CENTER);
    }

    private JPanel createFilmPanel(Film film) {
        JPanel filmPanel = new JPanel();
        filmPanel.setLayout(new BoxLayout(filmPanel, BoxLayout.X_AXIS));
        filmPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Création et redimensionnement de l'icône de l'affiche du film
        ImageIcon icon = new ImageIcon(new ImageIcon(film.getImagePath()).getImage().getScaledInstance(150, 225, Image.SCALE_SMOOTH));
        JButton filmButton = new JButton(icon);
        filmButton.setBorderPainted(false);
        filmButton.setContentAreaFilled(false);
        filmButton.setFocusPainted(false);
        filmButton.setToolTipText(film.getTitre() + ": " + film.getAuteur());  // Affiche les détails lors du survol
        
        // Ajout de l'actionListener pour gérer le clic sur le bouton du film
        filmButton.addActionListener(e -> {
            // Récupérer l'ID du film sélectionné
            int idFilm = film.getId();
            // Passer à la page de sélection d'horaire avec l'ID du film en paramètre
            PagePrincipale pagePrincipale = (PagePrincipale) SwingUtilities.getWindowAncestor(this);
            pagePrincipale.changePanel(new SelectionHoraire(idFilm));
        });
        
        filmPanel.add(filmButton);

        // Création et configuration de la zone de texte pour la description
        JTextArea descriptionText = new JTextArea(film.getTitre() + ": " + film.getAuteur());
        descriptionText.setLineWrap(true);
        descriptionText.setWrapStyleWord(true);
        descriptionText.setEditable(false);
        descriptionText.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        descriptionText.setBackground(Color.LIGHT_GRAY);
        descriptionText.setPreferredSize(new Dimension(300, 225));
        filmPanel.add(descriptionText);

        return filmPanel;
    }
}
