package part5.lesson17.task01;

import part5.lesson17.datasource.MyDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MyStatements {

    private DataSource ds = MyDataSource.getPostgresDataSource();
    private Connection connection;

    public int myCreateStatements(String name, int id) {
        int result = 0;
        PreparedStatement ps = null;
        try {
            connection = ds.getConnection();
            ps = connection.prepareStatement("insert into stc16.stc16schema.users(name, birthday, login_id, city, email, description) " +
                    "values (?,to_date('1993-03-30','yyyy-mm-dd'),?,'Archam','bat@mail.arc','black_knight')");
            ps.setString(1, name);
            ps.setInt(2, id);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int myUpdateStatements(int id, String name) {
        int result = 0;
        PreparedStatement ps = null;
        try {
            connection = ds.getConnection();
            ps = connection.prepareStatement("UPDATE stc16.stc16schema.users set name = ? where id = ?");
            ps.setString(1, name);
            ps.setInt(2, id);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public void myDeleteStatements(int id) {
        try {
            connection = ds.getConnection();
            PreparedStatement ps = connection.prepareStatement("DELETE from stc16.stc16schema.users where id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
