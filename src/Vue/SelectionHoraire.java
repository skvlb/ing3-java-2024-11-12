package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class SelectionHoraire extends JPanel {
    private int idFilm;
    private List<String> horaires;

    public SelectionHoraire(int idFilm) {
        this.idFilm = idFilm;
        setLayout(new BorderLayout());
        // Récupérer les horaires à partir de la méthode DAO
        this.horaires = recupererHoraires(idFilm);

        // Panel pour afficher les horaires à droite
        JPanel horairesPanel = new JPanel();
        horairesPanel.setLayout(new BoxLayout(horairesPanel, BoxLayout.Y_AXIS));

        // Ajouter les boutons d'horaires
        for (String horaire : horaires) {
            JButton horaireBtn = new JButton(horaire);
            horaireBtn.addActionListener(e -> {
                System.out.println("Horaire " + horaire + " pour le film ID " + idFilm + " sélectionné");
                // Ajouter l'action à exécuter lorsque l'horaire est sélectionné
                // Par exemple, appeler une méthode avec l'heure de début
                // votreMethodePourObtenirHeureDebut(idFilm, horaire);
            });
            horairesPanel.add(horaireBtn);
        }
        add(horairesPanel, BorderLayout.EAST);
    }

    // Méthode factice pour récupérer les horaires à partir de la DAO
    private List<String> recupererHoraires(int idFilm) {
        // Ici, vous utiliserez votre DAO pour obtenir les horaires associés à l'ID du film
        // Par exemple, FilmDao filmDao = new FilmDao(); puis filmDao.getHoraires(idFilm);
        // Retournez la liste d'horaires simulée pour l'exemple
        return List.of("10:00", "13:00", "16:00", "19:00");
    }

    public void setHoraireButtonListener(ActionListener listener) {
        for (Component comp : getComponents()) {
            if (comp instanceof JButton) {
                ((JButton) comp).addActionListener(listener);
            }
        }
    }
}
