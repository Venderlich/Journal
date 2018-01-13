/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package journal.Login;

import com.google.inject.Inject;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import journal.AuthService;

/**
 * FXML Controller class
 *
 * @author Tristan
 */
public class LoginController implements Initializable {

    @FXML
    private Label isConnected;
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;

    @Inject
    private AuthService authService;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void login(ActionEvent event) {
        if (userIsLoggedIn()) {
            isConnected.setText("Le nom d'utilisateur et le Mot de passe est valide");
        } else {
            isConnected.setText("Le nom d'utilisateur et le Mot de passe est incorrect");
        }
    }

    private boolean userIsLoggedIn() {
        try {
            return authService.login(txtUsername.getText(), txtPassword.getText());
        } catch (SQLException e) {
            isConnected.setText("OMG TA PAS DE BDD");
            return false;
        }
    }

}
