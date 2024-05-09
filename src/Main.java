import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = getConnection();
        InsertDB.insertToAcountCode(connection);
        InsertDB.insertToItem(connection);
        InsertDB.insertDocument(connection);
        //----------------------------
        //check for unique document id
        Document doc = new Document();
        doc.setId(5);
        boolean b = doc.isUnique(connection);
        System.out.println(b);
    }

    public static Connection getConnection() {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "1234";
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
