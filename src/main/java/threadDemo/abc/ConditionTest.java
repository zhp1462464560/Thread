package threadDemo.abc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(1);
        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        char[] c = new String("123456").toCharArray();
        char[] c1 = new String("abcdef").toCharArray();
        Object o = new Object();
        Thread t1 = new Thread(() -> {
//            try {
//                latch.await();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            lock.lock();
            try {
                for (int i = 0; i < c.length; i++) {
                    System.err.println(c[i]);
                    condition2.signal();
                    condition1.await();

                }
                condition2.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        });

        Thread t2 = new Thread(() -> {
            lock.lock();
//            latch.countDown();
            try {
                for (int i = 0; i < c1.length; i++) {
                    System.err.println(c1[i]);
                    condition1.signal();
                    condition2.await();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        });
        t1.start();
        t2.start();
    }
}
