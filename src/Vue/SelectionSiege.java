package Vue;

import javax.swing.*;

import Modele.DAO.DaoFactory;
import Modele.DAO.SiegeDAO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SelectionSiege extends JPanel {
    private static final int NOMBRE_SIEGES = 150;
    private static final int SIEGES_PAR_RANGE = 10;

    private ImageIcon iconeSiege;
    private ImageIcon iconeSiegeSelectionne;
    private List<JButton> siegesSelectionnes = new ArrayList<>();

    public SelectionSiege() {
        setLayout(new BorderLayout());
        JPanel panelSieges = new JPanel(new GridLayout(NOMBRE_SIEGES / SIEGES_PAR_RANGE, SIEGES_PAR_RANGE, 2, 2));
        panelSieges.setBackground(Color.LIGHT_GRAY);

        iconeSiege = new ImageIcon("images/logo/siege.png");
        iconeSiege = new ImageIcon(iconeSiege.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));

        iconeSiegeSelectionne = new ImageIcon("images/logo/siege2.png");
        iconeSiegeSelectionne = new ImageIcon(iconeSiegeSelectionne.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));

        for (int i = 0; i < NOMBRE_SIEGES; i++) {
            JButton boutonSiege = new JButton(iconeSiege);
            boutonSiege.setContentAreaFilled(false);
            boutonSiege.setBorderPainted(false);
            boutonSiege.setFocusPainted(false);
            boutonSiege.setActionCommand(String.valueOf(i + 1));
            boutonSiege.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton source = (JButton) e.getSource();
                    if (!siegesSelectionnes.contains(source)) {
                        source.setIcon(iconeSiegeSelectionne);
                        source.setEnabled(false);
                        siegesSelectionnes.add(source);
                        System.out.println("Siège sélectionné: " + e.getActionCommand());
                        // Ajouter le siège à la base de données ici
                        DaoFactory daoFactory= DaoFactory.getInstance();
                        SiegeDAO siegeDAO = daoFactory.getSiegeDAO();
                        String emailUtilisateur = "email@example.com";
                        int idSalle = 1; // Exemple de l'identifiant de la salle
                        int siegeId = Integer.parseInt(e.getActionCommand());
                        siegeDAO.ajouterSiege(emailUtilisateur, siegeId, idSalle);
                    }
                }
            });
            panelSieges.add(boutonSiege);
        }

        JLabel ecranLabel = new JLabel("Écran", SwingConstants.CENTER);
        ecranLabel.setFont(new Font(ecranLabel.getFont().getName(), Font.BOLD, 18));
        ecranLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        add(ecranLabel, BorderLayout.NORTH);
        add(panelSieges, BorderLayout.CENTER);

        // Ajouter le bouton pour accéder à la page des tarifs
        JButton boutonPageTarif = new JButton("Voir les tarifs");
        boutonPageTarif.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(SelectionSiege.this);
                PageTarifsConnecte pageTarifsConnecte = new PageTarifsConnecte();
                frame.setContentPane(pageTarifsConnecte);
                frame.revalidate();
            }
        });
        add(boutonPageTarif, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Sélection des sièges");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(new SelectionSiege());
                frame.setSize(600, 600);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
