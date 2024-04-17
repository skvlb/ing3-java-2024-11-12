package modele.DAO;

import modele.Utilisateur;

import java.util.List;

public interface UtilisateurDAO {
    public void ajouterUtilisateur(Utilisateur utilisateur);
    public boolean verifierMotDePasse(String email, String motDePasse);
    public void supprimerUtilisateur(int idUtilisateur);
    public List<Utilisateur> listerUtilisateurs();
}
