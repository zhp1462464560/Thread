package threadDemo.abc;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(1);
        char[] c = new String("123456").toCharArray();
        char[] c1 = new String("abcdef").toCharArray();
        Object o = new Object();
        Thread t1 = new Thread(() -> {

            synchronized (o) {
                for (int i = 0; i < c.length; i++) {
                    System.err.println(c[i]);
                    latch.countDown();
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
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
