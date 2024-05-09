public class Item {
    private int id;
    private AccountCode accountCode;
    private AccountType accountType;
    private double amount;

    public Item(int id, AccountCode accountCode, AccountType accountType, double amount) {
        this.id = id;
        this.accountCode = accountCode;
        this.accountType = accountType;
        this.amount = amount;
    }

    public AccountCode getAccountCode() {
        return accountCode;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public double getAmount() {
        return amount;
    }
}
