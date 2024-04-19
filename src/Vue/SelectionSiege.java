package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectionSiege extends JPanel {
    private static final int NOMBRE_SIEGES = 80;
    private static final int SIEGES_PAR_RANGE = 10;

    private ImageIcon iconeSiege;
    private ImageIcon iconeSiegeSelectionne;

    public SelectionSiege() {
        setLayout(new BorderLayout());
        JPanel panelSieges = new JPanel(new GridLayout(NOMBRE_SIEGES / SIEGES_PAR_RANGE, SIEGES_PAR_RANGE, 5, 5));
        panelSieges.setBackground(Color.LIGHT_GRAY);
        
        // Charger les icônes ici
        iconeSiege = new ImageIcon("images/logo/siege.png");
        iconeSiege = new ImageIcon(iconeSiege.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        // Vous devrez créer une version grise de l'icône
        iconeSiegeSelectionne = new ImageIcon("images/logo/siege_gris.png");
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
                    if (source.getIcon().equals(iconeSiege)) {
                        source.setIcon(iconeSiegeSelectionne);
                    } else {
                        source.setIcon(iconeSiege);
                    }
                    System.out.println("Siège sélectionné: " + e.getActionCommand());
                }
            });
            panelSieges.add(boutonSiege);
        }

        JLabel ecranLabel = new JLabel("Écran", SwingConstants.CENTER);
        ecranLabel.setFont(new Font(ecranLabel.getFont().getName(), Font.BOLD, 18));
        ecranLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        add(ecranLabel, BorderLayout.NORTH);
        add(panelSieges, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Sélection des sièges");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(new SelectionSiege());
                frame.setSize(600, 600); // Vous pouvez ajuster la taille selon vos besoins
                frame.setLocationRelativeTo(null); // Centrer la fenêtre sur l'écran
                frame.setVisible(true);
            }
        });
    }
}
