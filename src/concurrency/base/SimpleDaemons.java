package concurrency.base;

import java.util.concurrent.TimeUnit;

/**
 * @author WangYao
 * @date 2020/6/11
 * @function 后台线程
 */
public class SimpleDaemons implements Runnable {
    @Override
    public void run() {
        try {
            while (true){
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e){
            System.out.println("sleep interrupt");
        }
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true);
            daemon.start();
        }
        System.out.println("All started");
        TimeUnit.MILLISECONDS.sleep(100);
    }
}
