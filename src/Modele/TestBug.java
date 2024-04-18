package Modele;

import Modele.DAO.DaoFactory;
import Modele.DAO.UtilisateurDAO;

public class TestBug {
    public static void main(String[] args) {
        DaoFactory daoFactory = DaoFactory.getInstance();
        TypeClient type_client = new TypeClient(4, "il aime les fleurs", 0.004);
        Client mon_client = new Client(67, "loulou", "Daniel", "gerard@gmail.com", "swiduheu", "34555", type_client);
        UtilisateurDAO utilisateurDAO = daoFactory.getUtilisateurDAO();
        utilisateurDAO.ajouterUtilisateur(mon_client);
    }
}
