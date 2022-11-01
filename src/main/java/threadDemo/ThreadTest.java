package threadDemo;

public class ThreadTest {
    public static void main(String[] args) {
        ChopStick c1 = new ChopStick();
        ChopStick c2 = new ChopStick();
        ChopStick c3 = new ChopStick();
        ChopStick c4 = new ChopStick();
        ChopStick c5 = new ChopStick();

        People p1 = new People("p1", 1, c1, c2);
        People p2 = new People("p2", 2, c2, c3);
        People p3 = new People("p3", 3, c3, c4);
        People p4 = new People("p4", 4, c4, c5);
        People p5 = new People("p5", 5, c5, c1);

        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();



    }
}
