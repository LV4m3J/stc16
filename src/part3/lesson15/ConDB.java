package part3.lesson15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConDB {
    public Connection getConnection() throws SQLException {
        ResourceBundle rb = ResourceBundle.getBundle("database");
        String url = rb.getString("db.url");
        String user = rb.getString("db.user");
        String pass = rb.getString("db.password");
        return DriverManager.getConnection(url,user,pass);
    }
}
