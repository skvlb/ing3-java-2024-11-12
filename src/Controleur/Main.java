package Controleur;

import Vue.*;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        // Set the Nimbus Look and Feel
        setNimbusLookAndFeel();

        // Create and set up the window.
        JFrame frame = new JFrame("Gaumont Pathé de campagne");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add main panel to the frame
        frame.add(new PageAccueil());

        // Set frame size
        frame.setSize(1920, 1080);
        
        // Center the window on the screen
        frame.setLocationRelativeTo(null);
        
        // Display the window
        frame.setVisible(true);
    }

    private static void setNimbusLookAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
