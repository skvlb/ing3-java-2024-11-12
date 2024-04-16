package Vue;

import javax.swing.*;
import java.awt.*;

public class PageAccueil extends JFrame {
    private Bordereau bordereau;
    private JPanel mainPanel, carouselPanel;
    private JLabel lblCarousel;

    public PageAccueil() {
        setTitle("Page d'accueil");
        setSize(800, 600); // Set the window size as per the wireframe requirement
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the reusable header (Bordereau)
        bordereau = new Bordereau();

        // Main panel which includes everything else
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.LIGHT_GRAY); // Set the background color as seen in the wireframe

        // Carousel panel
        carouselPanel = new JPanel();
        carouselPanel.setLayout(new FlowLayout());
        carouselPanel.setBackground(Color.lightGray); // Set the background to indicate the carousel area

        lblCarousel = new JLabel("CARROUSSEL D'IMAGE / FILM À LA UNE");
        carouselPanel.add(lblCarousel);

        // Add panels to the main panel
        mainPanel.add(carouselPanel, BorderLayout.CENTER);

        // Add components to the frame
        add(bordereau, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PageAccueil().setVisible(true);
            }
        });
    }
}
