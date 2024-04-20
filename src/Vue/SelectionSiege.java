package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modele.DAO.DaoFactory;

public class SelectionSiege extends JPanel {
    private static final int NOMBRE_SIEGES = 120;
    private static final int SIEGES_PAR_RANGE = 12;
    private JButton siegeActuellementSelectionne = null;
    private ImageIcon iconeSiege;
    private ImageIcon iconeSiegeSelectionne;
    private int idProgrammation;
    private DaoFactory daoFactory;

    public SelectionSiege(int idProgrammation, DaoFactory daoFactory) {
        this.idProgrammation = idProgrammation;
        this.daoFactory = daoFactory;
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(900, 600)); // Ajustez la taille du panel global si nécessaire
        initializeUI();
    }

    private void initializeUI() {
        // Réduisez l'espacement entre les sièges ici
        JPanel panelSieges = new JPanel(new GridLayout(NOMBRE_SIEGES / SIEGES_PAR_RANGE, SIEGES_PAR_RANGE, 4, 4)); // Espacement horizontal, Espacement vertical
        panelSieges.setBackground(Color.LIGHT_GRAY);
        panelSieges.setPreferredSize(new Dimension(800, 300)); // Ajustez la largeur pour le panel des sièges

        iconeSiege = createIcon("images/logo/siege.png");
        iconeSiegeSelectionne = createIcon("images/logo/siege2.png");

        for (int i = 0; i < NOMBRE_SIEGES; i++) {
            JButton boutonSiege = new JButton(iconeSiege);
            customizeButton(boutonSiege, i);
            panelSieges.add(boutonSiege);
        }

        JLabel ecranLabel = new JLabel("Écran", SwingConstants.CENTER);
        ecranLabel.setFont(new Font(ecranLabel.getFont().getName(), Font.BOLD, 18));
        ecranLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        ecranLabel.setPreferredSize(new Dimension(900, 50)); // Ajustez cette taille pour le label écran

        // Bouton de validation des sièges
        JButton btnValider = new JButton("Valider");
        btnValider.addActionListener(e -> validerSiege());
        JPanel panelValidation = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelValidation.add(btnValider);

        // Ajout des composants au panel principal
        add(ecranLabel, BorderLayout.SOUTH);
        add(panelSieges, BorderLayout.CENTER);
        add(panelValidation, BorderLayout.NORTH);
    }

    private ImageIcon createIcon(String path) {
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

    private void customizeButton(JButton button, int index) {
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(50, 50)); 
        button.setActionCommand(String.valueOf(index + 1)); 
        button.addActionListener(e -> handleSeatSelection(button, index + 1));
    }

    private void handleSeatSelection(JButton button, int seatNumber) {
        if (siegeActuellementSelectionne != null) {
            siegeActuellementSelectionne.setIcon(iconeSiege);
        }
        button.setIcon(iconeSiegeSelectionne);
        siegeActuellementSelectionne = button;
        System.out.println("Siège sélectionné: " + seatNumber + " pour la programmation ID: " + idProgrammation);
    }

    private void validerSiege() {
        if (siegeActuellementSelectionne != null) {
            int siegeNumero = Integer.parseInt(siegeActuellementSelectionne.getActionCommand());
            System.out.println("Validation du siège numéro: " + siegeNumero + " pour la programmation ID: " + idProgrammation);
            // Ici, ajoutez le siège au panier et effectuez la transition vers la page du panier
            // Exemple: pagePrincipale.changePanel(new PanierPanel(idProgrammation, siegeNumero));
        } else {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner un siège avant de valider.", "Aucun siège sélectionné", JOptionPane.WARNING_MESSAGE);
        }
    }
}
