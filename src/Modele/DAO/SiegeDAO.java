package Modele.DAO;
import java.util.List;

public interface SiegeDAO {
    public void ajouterSiege(String emailUtilisateur, int placePrise, int idSalle);
    public void decrementerPlaces(int idSalle);
    public List<Integer> listerPlacesPrises(int idSalle);
}