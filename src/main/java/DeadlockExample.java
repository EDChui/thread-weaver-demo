import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockExample {
    private Lock lock1 = new ReentrantLock(true);
    private Lock lock2 = new ReentrantLock(true);

    public void method1() {
        lock1.lock();
        System.out.println("Method1: Acquired lock1");

        // Adding delay demonstrating the effect of deadlock.
        try {
            Thread.sleep(1000);
        } catch (Exception ignore) {}

        lock2.lock();
        System.out.println("Method2: Acquired lock2");

        lock2.unlock();
        lock1.unlock();
    }

    public void method2() {
        lock2.lock();
        System.out.println("Method2: Acquired lock2");

        // Adding delay demonstrating the effect of deadlock.
        try {
            Thread.sleep(1000);
        } catch (Exception ignore) {}

        lock1.lock();
        System.out.println("Method2: Acquired lock1");

        lock1.unlock();
        lock2.unlock();
    }

    public static void main(String[] args) {
        DeadlockExample deadlockExample = new DeadlockExample();
        Thread thread1 = new Thread(deadlockExample::method1);
        Thread thread2 = new Thread(deadlockExample::method2);
        thread1.start();
        thread2.start();
    }
}
