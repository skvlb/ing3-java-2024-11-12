package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingUtilities;

import Modele.Film;
import Modele.Programmation;
import Modele.DAO.DaoFactory;

    public class SelectionHoraire extends JPanel {
        private int idFilm;
        private JLabel afficheLabel;
        private JPanel horairesPanel;
        private DaoFactory daoFactory;
        private JSpinner dateSpinner;
        private JButton btnValiderDate;
        private JButton btnValiderHoraire;
        private Programmation selectedProgrammation;
        private JToggleButton selectedButton;

        public SelectionHoraire(int idFilm, DaoFactory daoFactory) {
            
            this.idFilm = idFilm;
            this.daoFactory = daoFactory;
            setLayout(null);


            // Panneau pour le titre et les horaires
            JPanel rightPanel = new JPanel(); 
            rightPanel.setLayout(null);
            rightPanel.setBackground(new Color(0xC0C0C0));  //FFEB62
            rightPanel.setBounds(10,10,1510,625);
            

            // Panneau pour l'affiche du film
            JPanel affichePanel = new JPanel();
            affichePanel.setLayout(null);
            affichePanel.setBounds(20,20, 400, 575);
            affichePanel.setBackground(new Color(0xFFEB62));



            // Bouton valider les horaires
            
            
            btnValiderHoraire = new JButton("Valider la séance");
            personnaliserBouton(btnValiderHoraire);
            btnValiderHoraire.addActionListener(e -> validerSelection());

            btnValiderHoraire.setBounds(1180, 525, 120, 60);             // CODE A CHANGER ICI

            

            // Panneau pour les horaires
            horairesPanel = new JPanel();
            horairesPanel.setBackground(new Color(0xFFEB62));   //FFEB62
            horairesPanel.setBounds(500,100,800,400);
            horairesPanel.setLayout(new GridLayout(0, 4, 10, 10)); // Layout pour les horaires



            // Titre "Séances"
            JLabel titrePage = new JLabel("Séances");
            titrePage.setFont(new Font(titrePage.getFont().getName(), Font.BOLD, 24));
            titrePage.setBounds(730,30,200,50);

            // Configuration du spinner de date
            dateSpinner = createDateSpinner();
            btnValiderDate = createValidateButton();




            // Panneau pour le spinner de date et le bouton valider
            JPanel datePanel = new JPanel();
            datePanel.setLayout(null);  

            datePanel.setBackground(new Color(0xFFEB62));
            datePanel.setBounds(850,30,350,50);
            
            dateSpinner.setBounds(10,5, 200, 40);
            btnValiderDate.setBounds(220,5,100,40);

            datePanel.add(dateSpinner);
            datePanel.add(btnValiderDate);

            rightPanel.add(datePanel);

            rightPanel.add(btnValiderHoraire);
            
            // Ajout des composants au panneau de droite
            
            rightPanel.add(titrePage);
            
            rightPanel.add(datePanel);
            
            rightPanel.add(horairesPanel);
            

            // Ajout de l'affiche
            Film film = daoFactory.getFilmDAO().getFilmById(idFilm);
            ImageIcon imageIcon = new ImageIcon(film.getImagePath());
            Image image = imageIcon.getImage().getScaledInstance(350, 550, Image.SCALE_SMOOTH);
            afficheLabel = new JLabel(new ImageIcon(image));
            afficheLabel.setBounds((affichePanel.getWidth() - image.getWidth(null)) / 2, 
                        (affichePanel.getHeight() - image.getHeight(null)) / 2, 
                        image.getWidth(null), image.getHeight(null));

            affichePanel.add(afficheLabel);


            add(affichePanel);
            add(rightPanel);

            updateHoraires(new java.sql.Date(System.currentTimeMillis())); 

        }


        private void personnaliserBouton(JButton bouton) {
            bouton.setForeground(Color.WHITE);
            bouton.setBackground(Color.BLACK);
            bouton.setPreferredSize(new Dimension(120, 60));
            bouton.setFocusPainted(false);
        }

        private JSpinner createDateSpinner() {
            Date today = new Date();
            SpinnerDateModel spinnerModel = new SpinnerDateModel(today, null, null, Calendar.DAY_OF_YEAR);
            JSpinner spinner = new JSpinner(spinnerModel);
            JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "dd/MM/yyyy");
            spinner.setEditor(editor);
            Dimension spinnerSize = editor.getPreferredSize();
            spinnerSize.height = 30; 
            editor.setPreferredSize(spinnerSize); 
            return spinner;
        }



        private JButton createValidateButton() {
            JButton bouton = new JButton("Valider Date");

            bouton.setForeground(Color.WHITE);
            bouton.setBackground(Color.BLACK);
            bouton.setPreferredSize(new Dimension(120, 60));
            bouton.setFocusPainted(false);
            
            bouton.addActionListener(e -> {
                java.sql.Date selectedDate = new java.sql.Date(((Date) dateSpinner.getValue()).getTime());
                updateHoraires(selectedDate);
            });
            return bouton;
        }



        private void updateHoraires(java.sql.Date date) {
            List<Programmation> programmations = daoFactory.getProgrammationDAO().getHorairesParIdFilmEtDate(idFilm, date);
            horairesPanel.removeAll();
            ButtonGroup buttonGroup = new ButtonGroup();

            for (Programmation programmation : programmations) {
                JToggleButton horaireButton = new JToggleButton(String.format("%tR", programmation.getHeureDebut()));
                horaireButton.setActionCommand(String.valueOf(programmation.getId())); //stockage id programmation

                horaireButton.setBackground(Color.BLACK);
                horaireButton.setForeground(Color.WHITE);
                horaireButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
                horaireButton.setFocusPainted(false);
                horaireButton.setFont(new Font("Arial", Font.BOLD, 16));

                horairesPanel.add(horaireButton);
                buttonGroup.add(horaireButton);
                horaireButton.addActionListener(e -> {
                    selectedButton = horaireButton;
                    selectedProgrammation = programmation; // mise a jour programmation
                    selectedButton.setSelected(true);
                });
            }

            horairesPanel.revalidate();
            horairesPanel.repaint();
        }

        private void validerSelection() {
            if (selectedProgrammation != null) {
                java.sql.Date selectedDate = new java.sql.Date(((Date) dateSpinner.getValue()).getTime());
                Film film = daoFactory.getFilmDAO().getFilmById(idFilm);
                System.out.println("Film sélectionné : " + film.getTitre());
                System.out.println("ID du film : " + idFilm);
                System.out.println("Date sélectionnée : " + selectedDate);
                System.out.println("Horaire sélectionné : " + selectedProgrammation.getHeureDebut());
                System.out.println("ID de la programmation : " + selectedProgrammation.getId());
                PagePrincipale pagePrincipale = (PagePrincipale) SwingUtilities.getWindowAncestor(this);
                pagePrincipale.changePanel(new SelectionSiege(selectedProgrammation.getId(), daoFactory,pagePrincipale));

            } else {
                System.out.println("Aucun horaire sélectionné.");
            }
        }
    }