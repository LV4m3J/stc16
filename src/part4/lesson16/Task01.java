package part4.lesson16;

import org.apache.log4j.Logger;
import part3.lesson15.ConDB;
import part3.lesson15.SavePoint;
import part3.lesson15.Stmnt;

import java.sql.Connection;
import java.sql.SQLException;

public class Task01 {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Task01.class.getName());
        ConDB condb = new ConDB();
        Connection connection = null;
        Stmnt st = new Stmnt();
        try {
            connection = condb.getConnection();
            logger.info(connection);
            if(!connection.getSchema().equals("stc16schema")) {
                connection.setSchema("stc16schema");
                logger.info(connection.getSchema());
                System.out.println(connection.getSchema());
                st.execStmnt(connection);
                SavePoint sp = new SavePoint();
                sp.savePoint(connection);
            }
        } catch (SQLException e) {
            logger.error(e);
            e.printStackTrace();
        } finally {
            System.out.println("closing connection");
            try {
                if (connection != null) {
                    connection.commit();
                    connection.close();
                    logger.trace(connection.isClosed());
                }
            } catch (SQLException e) {
                logger.error("didn't make it",e);
                System.out.println("didn't make it");
                e.printStackTrace();
            }
        }
    }
}

//TODO Взять за основу ДЗ_13,
//покрыть код логированием
//в основных блоках try покрыть уровнем INFO
//с исключениях catch покрыть уровнем ERROR
//настроить конфигурацию логера, что бы все логи записывались в БД, таблица LOGS,
//колонки ID, DATE, LOG_LEVEL, MESSAGE, EXCEPTION