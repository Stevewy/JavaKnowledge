package concurrency.interrupt.lock;

import java.util.concurrent.TimeUnit;

/**
 * @author WangYao
 * @date 2020/6/18
 * @function
 */
public class Blocked3 implements Runnable {
    private volatile double d = 0.0;
    @Override
    public void run() {
        try{
            while (!Thread.interrupted()) {
                NeedsCleanup n1 = new NeedsCleanup(1);
                try {
                    System.out.println("Sleeping");
                    TimeUnit.SECONDS.sleep(1);
                    NeedsCleanup n2 = new NeedsCleanup(2);
                    try {
                        System.out.println("Calculating");
                        for (int i = 0; i < 2500000; i++) {
                            d = d+(Math.E+Math.PI)/d;
                            System.out.println("finished calculating");
                        }
                    } finally {
                        n2.cleanup();
                    }
                } finally {
                    n1.cleanup();
                }
            }
            System.out.println("exiting while()");
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
    }

    public static void main(String[] args) throws Exception {
        /*if (args.length != 1) {
            System.out.println("usage");
            System.exit(1);
        }*/
        Thread t = new Thread(new Blocked3());
        t.start();
        TimeUnit.MILLISECONDS.sleep(1000); //调参数来观察出现异常对资源的清理
        t.interrupt();
    }
}
