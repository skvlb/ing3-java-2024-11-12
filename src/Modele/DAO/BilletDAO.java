package modele.DAO;
import java.sql.SQLException;
import java.util.List;

import modele.Billet;

public interface BilletDAO {
    void ajouterBillet(Billet billet);
    void supprimerBillet(int billetId);
    List<Billet> listerBillets();

}
