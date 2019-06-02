package part3.lesson15;

import java.sql.*;

public class Stmnt {
    /**
     *
     * @param connection - connection to db
     * @throws SQLException
     */

    public void execStmnt(Connection connection) throws SQLException {
        //Batch process
        Statement statement = connection.createStatement();
        statement.addBatch("truncate table stc16.stc16schema.users cascade");
        statement.addBatch("insert into stc16.stc16schema.users(name, birthday, login_id, city, email, description) " +
                "values ('batman',to_date('1993-03-30','yyyy-mm-dd'),1,'Archam','bat@mail.arc','black_knight')");
        statement.addBatch("insert into stc16.stc16schema.users(name, birthday, login_id, city, email, description) " +
                "values ('superman',to_date('1938-04-18','yyyy-mm-dd'),2,'Metropolis','super@mail.metrop','Kal-El')");
        statement.addBatch("insert into stc16.stc16schema.users(name, birthday, login_id, city, email, description) " +
                "values ('wonderwoman',to_date('1976-03-22','yyyy-mm-dd'),3,'Themyscira','ww@mail.tms','Diana Prince')");
        System.out.println(statement.executeBatch().length);
        statement.executeBatch();

        //PrepareStatement
        statement.execute("truncate table stc16.stc16schema.role cascade");
        String sql = "insert into stc16.stc16schema.role(name, description) values(?,?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,"Administration");
        pstmt.setString(2,"Administration role");
        pstmt.executeUpdate();
        pstmt.setString(1,"Clients");
        pstmt.setString(2,"Clients role");
        pstmt.executeUpdate();
        pstmt.setString(1,"Billing");
        pstmt.setString(2,"Billing role");
        pstmt.executeUpdate();
        pstmt.close();

        ResultSet rs = statement.executeQuery("select name,login_id from stc16.stc16schema.users");
        while (rs.next()){
            String row = rs.getString("name") + " " + rs.getString("login_id");
            System.out.println(row);
        }
        rs.close();
    }
}
