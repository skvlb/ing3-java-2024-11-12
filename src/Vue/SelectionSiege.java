package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectionSiege extends JPanel {
    private static final int NOMBRE_SIEGES = 150; // Nouveau nombre de sièges
    private static final int SIEGES_PAR_RANGE = 10;

    private ImageIcon iconeSiege;
    private ImageIcon iconeSiegeSelectionne;
    private JButton siegeActuellementSelectionne; // Référence au siège actuellement sélectionné

    public SelectionSiege() {
        setLayout(new BorderLayout());
        JPanel panelSieges = new JPanel(new GridLayout(NOMBRE_SIEGES / SIEGES_PAR_RANGE, SIEGES_PAR_RANGE, 2, 2)); // Espacement réduit
        panelSieges.setBackground(Color.LIGHT_GRAY);

        // Charger les icônes ici
        iconeSiege = new ImageIcon("images/logo/siege.png");
        iconeSiege = new ImageIcon(iconeSiege.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));

        // Charger l'icône en noir et blanc pour le siège sélectionné
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
                    if (siegeActuellementSelectionne != null) {
                        siegeActuellementSelectionne.setIcon(iconeSiege);
                    }
                    JButton source = (JButton) e.getSource();
                    source.setIcon(iconeSiegeSelectionne);
                    siegeActuellementSelectionne = source; // Mettre à jour le siège actuellement sélectionné
                    System.out.println("Siège sélectionné: " + e.getActionCommand());
                }
            });
            panelSieges.add(boutonSiege);
        }

        JLabel ecranLabel = new JLabel("Écran", SwingConstants.CENTER);
        ecranLabel.setFont(new Font(ecranLabel.getFont().getName(), Font.BOLD, 18));
        ecranLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        add(ecranLabel, BorderLayout.SOUTH);
        add(panelSieges, BorderLayout.CENTER);
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
