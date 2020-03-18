package concurrency;

/**
 * @author WangYao
 * @date 2020/3/5
 * @function 测试多线程
 */
public class SimpleConcurrentInstance implements Runnable {

    @Override
    public synchronized void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("run");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SimpleConcurrentInstance s = new SimpleConcurrentInstance();
        Thread t = new Thread(s);
        t.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("main");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
