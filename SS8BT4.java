// ===== Interface =====
interface IBank {
    void deposit(double amount);
    void withdraw(double amount);
}

// ===== BankAccount Class =====
class BankAccount implements IBank {
    private String accountId;
    private double balance;
    private String userName;
    private String phoneNumber;

    public BankAccount(String accountId, String userName, String phoneNumber) {
        this.accountId = accountId;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.balance = 0;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        }
    }

    public void displayBalance() {
        System.out.println("Tài khoản: " + accountId +
                " | Chủ tài khoản: " + userName +
                " | Số dư: " + balance);
    }
}

// ===== Main Class =====
public class SS8BT4 {
    public static void main(String[] args) {

        // Tạo tài khoản A và B
        BankAccount accountA = new BankAccount("A001", "Nguyễn Văn A", "0123456789");
        BankAccount accountB = new BankAccount("B001", "Nguyễn Văn B", "0987654321");

        // Nạp tiền vào tài khoản A
        accountA.deposit(1000);

        // Chuyển 300 từ A sang B
        double transferAmount = 300;
        accountA.withdraw(transferAmount);
        accountB.deposit(transferAmount);

        // Hiển thị số dư
        accountA.displayBalance();
        accountB.displayBalance();
    }
}
