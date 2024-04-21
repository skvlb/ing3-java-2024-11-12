package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

import Modele.Billet;
import Modele.DAO.DaoFactory;
import Modele.DAO.UtilisateurDaoImpl;

public class PageTarifsConnecte extends JPanel {
    private JLabel txtTarif;
    private JRadioButton radioEtudiant, radioNormal, radioEnfant;
    private JButton boutonPanier;
    private int idProgrammation;
    private int siegeNumero;
    private String userEmail;
    private PagePrincipale mainFrame; 

    public PageTarifsConnecte(int idProgrammation, int siegeNumero, String userEmail) {
        this.idProgrammation = idProgrammation;
        this.siegeNumero = siegeNumero;
        this.userEmail = userEmail;
        this.mainFrame = mainFrame;
        setLayout(null);
        initializeUI();
    }

    private void initializeUI() {
        setBackground(new Color(0xD7D9DF));
        setPreferredSize(new Dimension(800, 600));



        JPanel paneltarif = new JPanel(); 
        paneltarif.setLayout(null);
        paneltarif.setBackground(new Color(0xFF0000));  //FFEB62
        paneltarif.setBounds(500,20,500,625);




        txtTarif = new JLabel("Acheter un billet");
        txtTarif.setFont(new Font("Arial", Font.BOLD, 24));
        txtTarif.setBounds(150, 20, 200, 30);
        paneltarif.add(txtTarif);

        boutonPanier = new JButton("Ajouter au panier");
        personnaliserBouton(boutonPanier, 150, 450, 200, 50);
        paneltarif.add(boutonPanier);

        setupTarifOptions(paneltarif);

        ButtonGroup tarifGroup = new ButtonGroup();
        tarifGroup.add(radioEtudiant);
        tarifGroup.add(radioNormal);
        tarifGroup.add(radioEnfant);

        boutonPanier.addActionListener(this::actionBoutonPanier);

        add(paneltarif);
    }

    private void setupTarifOptions(JPanel paneltarif) {
        int baseY = 100;
        int stepY = 75;
        radioEtudiant = createRadioOption(paneltarif,"Etudiant", baseY);
        radioNormal = createRadioOption(paneltarif, "Normal", baseY + stepY);
        radioEnfant = createRadioOption(paneltarif, "Enfant", baseY + 2 * stepY);
    }

    private JRadioButton createRadioOption(JPanel paneltarif, String label, int yPos) {
        JLabel labelOption = new JLabel(label);
        labelOption.setFont(new Font("Arial", Font.BOLD, 16));
        labelOption.setBounds(125, yPos, 120, 30);
        paneltarif.add(labelOption);

        JRadioButton radioButton = new JRadioButton();
        radioButton.setBackground(new Color(0xFFEB62));
        radioButton.setBounds(400, yPos, 30, 30);
        paneltarif.add(radioButton);

        return radioButton;
    }
    
    private void actionBoutonPanier(ActionEvent e) {
        String selectedTarif = getSelectedTarif();
        if (!selectedTarif.isEmpty()) {
            double prix = calculatePrice(selectedTarif);
            PagePrincipale pagePrincipale = (PagePrincipale) SwingUtilities.getWindowAncestor(this);
            UtilisateurDaoImpl utilisateurDao = new UtilisateurDaoImpl(pagePrincipale.getDaoFactory());
            int userId = utilisateurDao.getIdUtilisateurParEmail(userEmail);
            Billet billet = new Billet(0, userId, idProgrammation, prix, false);
            DaoFactory daoFactory = pagePrincipale.getDaoFactory();
            pagePrincipale.changePanel(new PanierPage(billet,daoFactory,siegeNumero)); 
        } else {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner un tarif.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String getSelectedTarif() {
        if (radioEtudiant.isSelected()) return "Etudiant";
        if (radioNormal.isSelected()) return "Normal";
        if (radioEnfant.isSelected()) return "Enfant";
        return "";
    }

    private void personnaliserBouton(JButton bouton, int x, int y, int width, int height) {
        bouton.setBounds(x, y, width, height);
        bouton.setForeground(Color.WHITE);
        bouton.setBackground(Color.BLACK);
        bouton.setFocusPainted(false);
    }

    private double calculatePrice(String tarif) {
        switch (tarif) {
            case "Etudiant": return 8.50;
            case "Normal": return 12.00;
            case "Enfant": return 6.50;
            default: return 15.00;
        }
    }
}
