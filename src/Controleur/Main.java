package Controleur;

import javax.swing.JFrame;
import javax.swing.UIManager;
import Vue.PagePrincipale;

public class Main {

    public static void main(String[] args) {
        
        setNimbusLookAndFeel();
 
        PagePrincipale mainFrame = new PagePrincipale();  
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1920, 1080);  
        mainFrame.setLocationRelativeTo(null);  
        mainFrame.setVisible(true);  
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
            System.err.println("Nimbus non disponible, utilisation du look par défaut.");
            e.printStackTrace();
        }
    }
}
