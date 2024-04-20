package Modele.DAO;
import java.util.List;
import Modele.TypeClient;

public interface TypeClientDAO {
    public void ajouterTypeClient(TypeClient typeClient);
    public List<TypeClient> listerTypesClients();
}
