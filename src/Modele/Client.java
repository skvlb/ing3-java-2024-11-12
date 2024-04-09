package Modele;

public class Client extends Utilisateur{
    TypeClient type_client;//savoir + ou moins de 18 ans, étudiant etc...
    public Client(int id, String nom, String prenom, String email, String motDePasse, String telephone,TypeClient type_client) {
        super(id, nom, prenom, email, motDePasse, telephone);
        this.type_client=type_client;
    }
}
