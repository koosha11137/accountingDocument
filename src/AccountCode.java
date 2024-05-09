public class AccountCode {
    private int id;
    private String name;
    private AccountType accountType;

    public AccountCode(int id, String name, AccountType accountType) {
        this.id = id;
        this.name = name;
        this.accountType = accountType;
    }

    public String getName() {
        return name;
    }

    public AccountType getAccountType() {
        return accountType;
    }
}
