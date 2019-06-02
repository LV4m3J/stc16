package part3.lesson15;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class SavePoint {
    public void savePoint(Connection connection) {
        try (Statement statement = connection.createStatement()){
            connection.setAutoCommit(false);
            statement.execute("truncate table stc16.stc16schema.users_role");
            statement.executeUpdate("insert into stc16.stc16schema.users_role(user_id, role_id) values (1,1)");
            Savepoint sp = connection.setSavepoint();
            statement.executeUpdate("insert into stc16.stc16schema.users_role(user_id, role_id) values (2,2)");

            statement.executeUpdate("insert into stc16.stc16schema.users_role(user_id, role_id) values (3,3)");
            Savepoint spA = connection.setSavepoint();
            //psql exception
            statement.executeUpdate("insert into stc16.stc16schema.users_role(user_id, role_id) values (4,4)");
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
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }



    }
}
