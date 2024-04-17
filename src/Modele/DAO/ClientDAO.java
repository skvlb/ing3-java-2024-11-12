package Modele.DAO;
import Modele.Client;
public interface ClientDAO {
    public void ajouterClient(Client mon_client);
    public void supprimerClient(int client_id);
}
