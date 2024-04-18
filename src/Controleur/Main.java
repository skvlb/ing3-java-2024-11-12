package Controleur;

import javax.swing.JFrame;
import javax.swing.UIManager;
import Vue.PagePrincipale;

public class Main {

    public static void main(String[] args) {
        // Set the Nimbus Look and Feel for a better UI appearance
        setNimbusLookAndFeel();

        // Create the main window of the application
        PagePrincipale mainFrame = new PagePrincipale();  // PagePrincipale is a JFrame
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1920, 1080);  // Set the size of the window
        mainFrame.setLocationRelativeTo(null);  // Center the window on the screen
        mainFrame.setVisible(true);  // Make the window visible
    }

    // A helper method to set the Nimbus Look and Feel
    private static void setNimbusLookAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // Handle exception
            System.err.println("Unable to set Nimbus Look and Feel");
            e.printStackTrace();
        }
    }
}
