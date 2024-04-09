package modele.DAO;
import java.sql.SQLException;
import modele.Billet;

public interface BilletDAO {
    void ajouterBillet(Billet billet) throws SQLException;
}
