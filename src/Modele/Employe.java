package Modele;

public class Employe extends Utilisateur{
    String role;
    public Employe(int id, String nom, String prenom, String email, String motDePasse, String telephone,String role) {
        super(id, nom, prenom, email, motDePasse, telephone,2);
        this.role=role;
    }
}