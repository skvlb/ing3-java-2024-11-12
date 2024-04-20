package Modele.DAO;

import Modele.Utilisateur;

import java.util.List;

public interface UtilisateurDAO {
    public void ajouterUtilisateur(Utilisateur utilisateur);
    public boolean verifierMotDePasse(String email, String motDePasse);
    public void supprimerUtilisateur(int idUtilisateur);
    public List<Utilisateur> listerUtilisateurs();
    public void setConnection(String email, boolean isConnected);
    public String getTypeUtilisateurParEmail(String email);
    public int getIdUtilisateurParEmail(String email);
}
