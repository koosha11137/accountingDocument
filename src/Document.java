import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Document {
    private Integer id;
    private java.sql.Date date;
    private List<Item> items;

    public Document(int id, Date date) {
        this.id = id;
        this.date = date;
        this.items = new ArrayList<>();
    }

    public Document() {

    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public double getTotalAmount() {
        double totalAmount = 0;
        for (Item item : items) {
            totalAmount += item.getAmount();
        }
        return totalAmount;
    }

    public boolean isBalanced() {
        double totalDebitAmount = 0;
        double totalCreditAmount = 0;
        for (Item item : items) {
            if (item.getAccountType() == AccountType.DEBIT) {
                totalDebitAmount += item.getAmount();
            } else {
                totalCreditAmount += item.getAmount();
            }
        }
        return totalDebitAmount == totalCreditAmount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public java.sql.Date getDate() {
        return date;
    }


    public boolean isUnique(Connection connection) throws SQLException {
        //  عبارت SQL برای بررسی تکراری بودن سند
        String sql = "SELECT COUNT(*) FROM document WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, this.getId());

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            int count = resultSet.getInt(1);
            if (count > 0) {
                return false;
            }
        }
        resultSet.close();
        statement.close();
        connection.close();
        return true;
    }
}
