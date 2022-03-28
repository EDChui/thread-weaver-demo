import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;

class BadAccountTest {
    @Test
    public void depositStressTest() {
        BadAccount account = new BadAccount();

        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 10000; i++) {
            executor.execute(() -> account.deposit(1));
        }
        executor.shutdown();
        // Wait for all tasks to be finished.
        while(!executor.isTerminated()) {}

        assertEquals(10000, account.getBalance());
    }
}