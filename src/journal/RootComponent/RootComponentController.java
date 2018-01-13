/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package journal.RootComponent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Tristan
 */
public class RootComponentController implements Initializable {
    @FXML
    private Label userLbl;
    
    @FXML
    private BorderPane mainBorderPane;
    /**
     * Initializes the controller class.
     */



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void GetUser(String user){
        userLbl.setText(user);
    }
    
    public void signOut(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader();
            Pane root = loader.load(getClass().getResource("Login/Login.fxml").openStream());
            mainBorderPane.setCenter(root);
        } catch (IOException ex) {
            Logger.getLogger(RootComponentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
