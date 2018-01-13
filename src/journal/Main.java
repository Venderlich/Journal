/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package journal;

import journal.DI.AppModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Tristan
 */
public class Main extends Application {

    /**
     *
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Injector injector = Guice.createInjector(new AppModule());
        injector.injectMembers(new DummyAuthService());
        FXMLLoader fxmlLoader = new FXMLLoader();
        //The new part. Give fxmlLoader a callback. Controllers will now be instatiated via the container, not FXMLLoader itself.
        fxmlLoader.setControllerFactory(instantiatedClass -> {
            return injector.getInstance(instantiatedClass);
        });

        try {
            Parent parent = FXMLLoader.load(getClass().getResource("RootComponent/RootComponent.fxml"));
            stage.setScene(new Scene(parent));
            stage.setTitle("Journalizer - Miccolet Sans Connexion");
            stage.show();
        } catch (IOException ex) {
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
