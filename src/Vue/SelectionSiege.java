package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Modele.DAO.DaoFactory;
import Modele.DAO.SiegeDaoImpl;

public class SelectionSiege extends JPanel {
    private static final int NOMBRE_SIEGES = 120;
    private static final int SIEGES_PAR_RANGE = 12;
    private JButton siegeActuellementSelectionne = null;
    private ImageIcon iconeSiege;
    private ImageIcon iconeSiegeSelectionne;
    private int idProgrammation;
    private DaoFactory daoFactory;
    private PagePrincipale mainFrame;
    private String userEmail;

    public SelectionSiege(int idProgrammation, DaoFactory daoFactory, PagePrincipale mainFrame) {
        this.idProgrammation = idProgrammation;
        this.daoFactory = daoFactory;
        this.mainFrame = mainFrame;
        this.userEmail = mainFrame.getConnectedUserEmail(); // récupération de l'email de l'utilisateur connecté
        setLayout(new BorderLayout());
        initializeUI();
    }

    private void initializeUI() {
        JPanel panelSieges = new JPanel(new GridLayout(NOMBRE_SIEGES / SIEGES_PAR_RANGE, SIEGES_PAR_RANGE, 10, 10));
        panelSieges.setBackground(Color.LIGHT_GRAY);

        iconeSiege = createIcon("images/logo/siege.png");
        iconeSiegeSelectionne = createIcon("images/logo/siege2.png");

        SiegeDaoImpl siegeDao = new SiegeDaoImpl(daoFactory);
        List<Integer> siegesOccupes = siegeDao.listerPlacesPrises(idProgrammation);

        for (int i = 0; i < NOMBRE_SIEGES; i++) {
            JButton boutonSiege = new JButton();
            boutonSiege.setPreferredSize(new Dimension(30, 30));
            boutonSiege.setContentAreaFilled(false);
            boutonSiege.setBorderPainted(false);
            boutonSiege.setFocusPainted(false);
            customizeButton(boutonSiege, i); 

            if (siegesOccupes.contains(i + 1)) {
                boutonSiege.setIcon(iconeSiegeSelectionne);
                boutonSiege.setEnabled(false);
            } else {
                boutonSiege.setIcon(iconeSiege);
            }
            panelSieges.add(boutonSiege);
        }

        JLabel ecranLabel = new JLabel("Écran", SwingConstants.CENTER);
        ecranLabel.setFont(new Font(ecranLabel.getFont().getName(), Font.BOLD, 18));
        add(ecranLabel, BorderLayout.SOUTH);
        add(panelSieges, BorderLayout.CENTER);

        JButton btnValider = new JButton("Valider");
        personnaliserBouton(btnValider);
        btnValider.addActionListener(this::validerSiege);
        add(btnValider, BorderLayout.NORTH);
    }

    
    private void personnaliserBouton(JButton bouton) {
        bouton.setForeground(Color.WHITE);
        bouton.setBackground(Color.BLACK);
        bouton.setPreferredSize(new Dimension(120, 60));
        bouton.setFocusPainted(false);
    }

    private ImageIcon createIcon(String path) {
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

    private void customizeButton(JButton button, int index) {
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

    private void validerSiege(ActionEvent e) {
        if (siegeActuellementSelectionne != null) {
            int siegeNumero = Integer.parseInt(siegeActuellementSelectionne.getActionCommand());
            SiegeDaoImpl siegeDAO = new SiegeDaoImpl(daoFactory);
            siegeDAO.ajouterSiege(userEmail, siegeNumero, idProgrammation);
            JOptionPane.showMessageDialog(this, "Siège " + siegeNumero + " validé pour la programmation " + idProgrammation);
            // transfere vers la page des tarifs
            mainFrame.changePanel(new PageTarifsConnecte(idProgrammation, siegeNumero, userEmail));
        } else {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner un siège avant de valider.", "Aucun siège sélectionné", JOptionPane.WARNING_MESSAGE);
        }
    }
}
