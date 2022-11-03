package threadDemo.singleton;

public class SyncSingleton {
    private  volatile static SyncSingleton syscSingleton;

    private SyncSingleton() {
    }

    public static SyncSingleton getInstance() {
        if (syscSingleton == null) {
            synchronized (SyncSingleton.class) {
                if (syscSingleton == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    syscSingleton = new SyncSingleton();
                }
            }
        }
        return syscSingleton;
    }

    public static void main(String[] args) {
            for (int i = 0; i < 1000; i++) {
                new Thread(() -> {
                System.err.println(SyncSingleton.getInstance().hashCode());
                }).start();
            }
    }
}
