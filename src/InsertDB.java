import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class InsertDB {
    public static void insertToAcountCode(Connection connection) throws SQLException {
        for(int i=1; i<=10;i++)
        {
            String sql = "INSERT INTO account_code (id, name, account_type) VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, i);
            ps.setString(2, "code"+i);
            ps.setString(3, AccountType.DEBIT.toString());
            ps.executeUpdate();
        }
        System.out.println("account_code Records inserted successfully!");
    }
    public static void insertToItem(Connection connection) throws SQLException {
        Random rnd=new Random();
        for(int i=1; i<=10;i++)
        {
            String sql = "INSERT INTO item (id, account_code, account_type) VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, i);
            ps.setInt(2, rnd.nextInt(11));
            ps.setString(3, AccountType.DEBIT.toString());
            ps.executeUpdate();
        }
        System.out.println("item Records inserted successfully!");
    }
    public static void insertDocument(Connection connection) throws SQLException {
        Random rnd=new Random();
        java.util.Date utilDate=new java.util.Date();
        for(int i=1; i<=10;i++)
        {
            String sql = "INSERT INTO document (id, date, items) VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, i);
            long millis = utilDate.getTime();
            ps.setDate(2,  new Date(millis));
            List<Integer> lst=new ArrayList<>();
            Object[] ara={rnd.nextInt(11),rnd.nextInt(11)};
            Array array = connection.createArrayOf("INTEGER", ara);
            ps.setArray(3, array);
            ps.executeUpdate();
        }
        System.out.println("item Records inserted successfully!");
    }
}

