/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package journal.Login;

import com.google.inject.Inject;
import java.sql.Connection;
import java.sql.SQLException;

public class LoginModel {
    @Inject
    private Connection connection;

    public boolean isDbConnected() {
        try {
            return !connection.isClosed();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }
}
