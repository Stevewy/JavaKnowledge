package concurrency.interrupt.lock;

import java.util.concurrent.TimeUnit;

/**
 * @author WangYao
 * @date 2020/6/18
 * @function
 */
public class Blocked2 implements Runnable {
    private BlockedMutex blocked = new BlockedMutex();
    @Override
    public void run() {
        //blocked = new BlockedMutex();                       // 如果在这里初始化不会阻塞,因为获取锁和使用在一个线程里面
        System.out.println("waiting for f()");
        blocked.f();                                         //因为另一个线程锁住了blocked,所以调用f会阻塞
        System.out.println("broken out of blocked call");
    }

    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(new Blocked2());
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("issuing interrupt");
        thread.interrupt();
    }
}
