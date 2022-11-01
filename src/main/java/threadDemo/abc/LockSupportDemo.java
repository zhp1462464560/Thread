package threadDemo.abc;

import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {
    static Thread t2 = null;
    static Thread t1 = null;
    public static void main(String[] args) {

        char [] c = new String("123456").toCharArray();
        char [] c1 = new String("abcdef").toCharArray();
        t1 = new Thread(() -> {
            for (int i = 0; i < c.length; i++) {
                    System.err.println(c[i]);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        }, "数字");

         t2 = new Thread(() -> {
            for (int i = 0; i < c1.length; i++) {
                LockSupport.park();
                System.err.println(c1[i]);
                LockSupport.unpark(t1);
            }
        }, "字母");
         t1.start();
         t2.start();
    }

}
