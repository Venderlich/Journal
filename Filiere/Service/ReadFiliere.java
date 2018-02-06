package journal.Filiere.Service;

import journal.DI.SQLiteConnectionProvider;
import journal.Matiere.Service.Matiere;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReadFiliere {

    SQLiteConnectionProvider conn = new SQLiteConnectionProvider();

    private Filiere rsToFiliere(ResultSet rs) throws SQLException {
        Filiere fil = new Filiere();
        fil.setId(rs.getInt("Filiere.ID"));
        fil.setLabel(rs.getString("Filiere.Label"));
        fil.setMatiere(rs.getString("Matiere.Label"));
        return fil;
    }

    public ArrayList<Matiere> listMatiere() throws SQLException {
        ArrayList<Matiere> listMatiere = new ArrayList<>();
        String query = "select Filiere.ID, Filiere.Label, Matiere.Label from Filiere join Matiere ON Filiere.IDMatiere = Matiere.ID";
        PreparedStatement preparedStatement = null;
        ResultSet result = null;

        try {
            preparedStatement = conn.get().prepareStatement(query);
            result = preparedStatement.executeQuery();
            while ( result.next() ) {
                listMatiere.add(rsToFiliere(result));
            }
        } catch (SQLException e) {

        } finally {
            assert preparedStatement != null;
            assert result != null;
            preparedStatement.close();
            result.close();
        }
        return  listMatiere;
    }
}
