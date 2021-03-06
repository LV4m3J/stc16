package part3.lesson15;

import org.apache.log4j.Logger;
import part4.lesson16.Task01;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class SavePoint {
    public void savePoint(Connection connection) {
        Logger logger = Logger.getLogger(Task01.class.getName());
        Savepoint spA = null;
        boolean commit = false;
        try (Statement statement = connection.createStatement()){
            connection.setAutoCommit(false);
            statement.execute("truncate table stc16.stc16schema.users_role");
            statement.executeUpdate("insert into stc16.stc16schema.users_role(user_id, role_id) values (1,1)");
            Savepoint sp = connection.setSavepoint();
            connection.commit();
            statement.executeUpdate("insert into stc16.stc16schema.users_role(user_id, role_id) values (2,2)");

            statement.executeUpdate("insert into stc16.stc16schema.users_role(user_id, role_id) values (3,3)");
            spA = connection.setSavepoint("SavepointA");
            //psql exception
            statement.executeUpdate("insert into stc16.stc16schema.users_role(user_id, role_id) values (4,4)");
            commit = true;
            logger.info("Commit is " + commit);
        } catch (SQLException e) {
            logger.error(e);
            e.printStackTrace();
        } finally {
            if(connection != null) {
                try {
                    if(!commit) {
                        connection.rollback(spA);
                        logger.trace("rollback " + spA);
                    }
                    connection.commit();
                } catch (SQLException e) {
                    logger.error(e);
                    e.printStackTrace();
                }
            }
        }
    }
}
