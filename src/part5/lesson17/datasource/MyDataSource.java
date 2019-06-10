package part5.lesson17.datasource;

import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class MyDataSource {
    /**
     *
     * @return datasource connection
     */
    public static DataSource getPostgresDataSource() {
        PGSimpleDataSource pgsds = null;
        Properties props = new Properties();
        try(FileInputStream fis = new FileInputStream("./resources/database.properties")) {
            props.load(fis);
            pgsds = new PGSimpleDataSource();
            pgsds.setUrl(props.getProperty("db.url"));
            pgsds.setUser(props.getProperty("db.user"));
            pgsds.setPassword(props.getProperty("db.password"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pgsds;
    }
}
