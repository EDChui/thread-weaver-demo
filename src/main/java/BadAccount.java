import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BadAccount {
    private int balance = 0;

    public int getBalance() {
        return balance;
    }

    // The keyword "synchronized" is supposed to be added here.
    public synchronized void deposit(int amount) {
        int newBalance = balance + amount;
        balance = newBalance;
    }

    public static void raceConditionDemo() {
        BadAccount account = new BadAccount();

        System.out.println("The old balance: " + account.getBalance());

        // Deposit a total of 10000 into the account, by different threads.
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 10000; i++) {
            executor.execute(() -> account.deposit(1));
        }
        executor.shutdown();
        // Wait for all tasks to be finished.
        while(!executor.isTerminated()) {}

        // It is expected that the new balance is 10000.
        // We can that #deposit() is not thread-safe.
        System.out.println("The new balance: " + account.getBalance());
    }

    public static void main(String[] args) {
        raceConditionDemo();
    }
}
