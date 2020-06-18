package concurrency.interrupt;

/**
 * @author WangYao
 * @date 2020/6/18
 * @function synchronized(不可打断)
 */
public class SynchronizedBlocked implements Runnable {

    public synchronized void f() { //一直锁
        while (true)
            Thread.yield();
    }

    public SynchronizedBlocked() {
        new Thread(){
            public void run(){
                f();
            }
        }.start();
    }

    @Override
    public void run() {
        System.out.println("trying to call f()");
        f();
        System.out.println("exiting SynchronizedBlocked run");
    }
}