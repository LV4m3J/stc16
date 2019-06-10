package part5.lesson17.task02;

import part5.lesson17.datasource.MyDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Task02 {

    Connection dbConnection;

    public void dbConnection() throws SQLException {
        DataSource ds = MyDataSource.getPostgresDataSource();
        dbConnection = ds.getConnection();
    }
    public int executeQuery(String query) throws SQLException {
        return dbConnection.createStatement().executeUpdate(query);
    }
}

//TODO Использую Spy и Mockito создать заглушки для интерфейса JDBC


