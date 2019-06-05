package part3.lesson15;

import org.apache.log4j.Logger;
import part4.lesson16.Task01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConDB {
    public Connection getConnection() throws SQLException {
        Logger logger = Logger.getLogger(Task01.class.getName());
        ResourceBundle rb = ResourceBundle.getBundle("database");
        String url = rb.getString("db.url");
        String user = rb.getString("db.user");
        String pass = rb.getString("db.password");
        logger.info(DriverManager.getDrivers());
        return DriverManager.getConnection(url,user,pass);
    }
}
