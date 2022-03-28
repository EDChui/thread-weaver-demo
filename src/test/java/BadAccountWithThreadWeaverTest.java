import com.google.testing.threadtester.*;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class BadAccountWithThreadWeaverTest {
    BadAccount account;

    @ThreadedBefore
    public void before() {
        account = new BadAccount();
    }

    @ThreadedMain
    public void mainThread() {
        account.deposit(10);
    }

    @ThreadedSecondary
    public void secondThread() {
        account.deposit(20);
    }

    @ThreadedAfter
    public void after() {
        assertEquals(30, account.getBalance());
    }

    @Test
    public void depositWithThreadWeaverTest() {
        AnnotatedTestRunner runner = new AnnotatedTestRunner();
        HashSet<String> methods = new HashSet<>();
        runner.setMethodOption(MethodOption.ALL_METHODS, methods);
        // Show debug message
//        runner.setDebug(true);
        runner.runTests(this.getClass(), BadAccount.class);
    }
}