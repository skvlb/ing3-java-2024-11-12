package Modele.DAO;
public interface ClientDAO {
    public void ajouterTypeClientParEmail(String email, int typeClient);
    public void creerClientParEmail(String email);
}
