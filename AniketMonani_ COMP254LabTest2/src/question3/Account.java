package question3;

class Account {
    int accountNumber;
    String customerName;
    double accountBalance;

    public Account(int accountNumber, String customerName, double accountBalance) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.accountBalance = accountBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    @Override
    public String toString() {
        return String.format("Account{accountNumber=%d, customerName='%s', accountBalance=%.2f}",
                accountNumber, customerName, accountBalance);
    }
}
