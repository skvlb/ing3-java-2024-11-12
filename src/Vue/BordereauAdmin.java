package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

class BordereauAdmin extends JPanel {
    private PagePrincipaleAdmin mainFrame;
    private JButton boutonCompte, logoBouton;
    private JLabel titre;
    private JLabel lblUserEmail; 

    public BordereauAdmin(PagePrincipaleAdmin mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(null);
        setPreferredSize(new Dimension(1920, 175));
        setBackground(new Color(0xFFEB62));

        // Logo
        logoBouton = creerBoutonIcone("images/logo/logo gaumont.png", 140, 160);
        logoBouton.setBounds(8, 7, 140, 160);
        add(logoBouton);

        // Titre
        titre = new JLabel("GAUMONT Pathé de campagne", SwingConstants.CENTER);
        titre.setFont(new Font(titre.getFont().getName(), Font.BOLD, 24));
        titre.setBounds(555, 10, 400, 30);
        add(titre);

        // Bouton Compte
        boutonCompte = creerBoutonIcone("images/logo/moncompte.png", 50, 40);
        boutonCompte.setBounds(1460, 75, 50, 40);
        add(boutonCompte);

        // Label Utilisateur
        lblUserEmail = new JLabel("User Email");
        lblUserEmail.setFont(new Font(lblUserEmail.getFont().getName(), Font.BOLD, 16));
        lblUserEmail.setForeground(Color.BLACK);
        lblUserEmail.setHorizontalAlignment(SwingConstants.RIGHT);
        lblUserEmail.setBounds(1370, 130, 150, 30);
        add(lblUserEmail);

        // Listeners
        addActionListeners();
    }

    private JButton creerBoutonIcone(String cheminIcone, int largeur, int hauteur) {
        ImageIcon icone = new ImageIcon(cheminIcone);
        Image image = icone.getImage().getScaledInstance(largeur, hauteur, Image.SCALE_SMOOTH);
        JButton bouton = new JButton(new ImageIcon(image));
        bouton.setBorderPainted(false);
        bouton.setContentAreaFilled(false);
        bouton.setFocusPainted(false);
        return bouton;
    }

    private void addActionListeners() {
        logoBouton.addActionListener(e -> {
            mainFrame.afficherPagePrincipale();
            System.out.println("Le logo/bouton a été cliqué");
            
        });
        
        boutonCompte.addActionListener(e -> {
            // code pour rediriger vers la page de compte de l'administrateur
            System.out.println("Le bouton 'Mon compte' a été cliqué");
        });
    }

    public JLabel getLblUserEmail() {
        return lblUserEmail;
    }
}
