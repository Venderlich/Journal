/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package journal.DI;

import com.google.inject.AbstractModule;
import java.sql.Connection;
import javafx.fxml.FXMLLoader;
import journal.AuthService;
import journal.DummyAuthService;
import journal.SqliteConnection;

/**
 *
 * @author tc820073
 */
public class AppModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(FXMLLoader.class).toProvider(FXMLLoaderProvider.class);
        bind(AuthService.class).to(DummyAuthService.class); 
        bind(Connection.class).to(SqliteConnection.class);
    }
}
