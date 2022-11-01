package threadDemo.abc;

import java.util.concurrent.locks.LockSupport;

public class WaitTest {

    public static void main(String[] args) {
        char[] c = new String("123456").toCharArray();
        char[] c1 = new String("abcdef").toCharArray();
        Object o = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (o) {
                for (int i = 0; i < c.length; i++) {
                    System.err.println(c[i]);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (o) {
                for (int i = 0; i < c1.length; i++) {
                    System.err.println(c1[i]);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
}
