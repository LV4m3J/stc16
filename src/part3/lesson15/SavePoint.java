package part3.lesson15;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class SavePoint {
    public void savePoint(Connection connection) {
        Statement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            statement.executeUpdate("insert into stc16.stc16schema.users_role values (1,1,1)");
            Savepoint sp = connection.setSavepoint();
            statement.executeUpdate("insert into stc16.stc16schema.users_role values (2,2,2)");

            statement.executeUpdate("insert into stc16.stc16schema.users_role values (3,3,3)");
            Savepoint spA = connection.setSavepoint();
            //psql exception
            statement.executeUpdate("insert into stc16.stc16schema.users_role values (4,4,4)");
        } catch (SQLException e) {
            try {
                System.out.println("Transaction is being rolled back.");
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                connection.commit();
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }



    }
}
