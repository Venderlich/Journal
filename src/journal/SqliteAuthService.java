/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package journal;

import com.google.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author tc820073
 */
public class SqliteAuthService implements AuthService {

    private Connection db;
    
    @Inject
    SqliteAuthService(Connection connection) {
        db = connection;
    }
            
    @Override
    public boolean login(String login, String password) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String query = "select * from User where login = ? and mdp = ?";

        try {
            preparedStatement = db.prepareStatement(query);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            
            return resultSet.next();

        } catch (SQLException e) {
            return false;
        } finally {
            preparedStatement.close();
            resultSet.close();
        }
    }
}
