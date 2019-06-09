package part5.lesson17.task01;

import org.junit.jupiter.api.*;
import part5.lesson17.datasource.MyDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


class MyStatementsTest {

    private static DataSource ds = MyDataSource.getPostgresDataSource();
    private static Connection connection = null;
    private MyStatements ms = new MyStatements();

    @BeforeEach
    void setUp() throws SQLException {
        connection = ds.getConnection();
    }

    @AfterEach
    void tearDown() throws SQLException {
        connection.close();
    }

    @BeforeAll
    static void init() throws SQLException {
        connection = ds.getConnection();
        Statement statement = connection.createStatement();
        statement.addBatch("truncate table stc16.stc16schema.users cascade");
        statement.addBatch("ALTER SEQUENCE stc16.stc16schema.users_id_seq RESTART WITH 1");
        statement.addBatch("insert into stc16.stc16schema.users(name, birthday, login_id, city, email, description) " +
                "values ('hulk',to_date('1993-03-30','yyyy-mm-dd'),1,'Archam','bat@mail.arc','black_knight')");
        statement.addBatch("insert into stc16.stc16schema.users(name, birthday, login_id, city, email, description) " +
                "values ('iron_man',to_date('1938-04-18','yyyy-mm-dd'),2,'Metropolis','super@mail.metrop','Kal-El')");
        statement.addBatch("insert into stc16.stc16schema.users(name, birthday, login_id, city, email, description) " +
                "values ('some',to_date('1976-03-22','yyyy-mm-dd'),3,'Themyscira','some@mail.some','Diana Prince')");
        statement.executeBatch();
        connection.close();
    }

    @Test
    void myCreateStatements() {
        int result = ms.myCreateStatements("swamp",4);
        Assertions.assertEquals(1,result);
    }

    @Test
    void myUpdateStatements() throws SQLException {
        int result = ms.myUpdateStatements(2, "swamp");
        Assertions.assertEquals(1,result);
    }

    @Test
    void myDeleteStatements() throws SQLException {
        ms.myDeleteStatements(3);
        Statement statement = connection.createStatement();
        boolean result = statement.execute("SELECT * from stc16.stc16schema.users where id = 3");
        Assertions.assertTrue(result);
    }
}