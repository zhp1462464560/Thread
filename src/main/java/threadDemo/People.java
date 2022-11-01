package threadDemo;

public class People extends Thread {

    String name;
    int index;
    ChopStick left;
    ChopStick right;

    public People(String name, int index, ChopStick left, ChopStick right) {
        this.name = name;
        this.index = index;
        this.left = left;
        this.right = right;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5);
            if (index % 2 == 0) {
                synchronized (left) {
                    System.out.println(index + "号拿到了左手筷子");
                }
                synchronized (right) {
                    Thread.sleep(3);
                    System.out.println(index + "号拿到了右手筷子");
                }
            }else{
                synchronized (right) {
                    System.out.println(index + "号拿到了左手筷子");
                }
                synchronized (left) {
                    Thread.sleep(3);
                    System.out.println(index + "号拿到了右手筷子");
                }
            }
            System.err.println(index + "号已经吃完");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
