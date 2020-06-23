package concurrency.cooperation.wait;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author WangYao
 * @date 2020/6/21
 * @function 比较notify和notifyAll
 */
public class Blocker {
    synchronized void waitCall(){
        try {
            while (!Thread.interrupted()) {
                wait();
                System.out.println(Thread.currentThread() + " ");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    synchronized void prod(){notify();}
    synchronized void prodAll() {notifyAll();}
}

class Test implements Runnable{
    static Blocker blocker = new Blocker(); // 多个共用一个blocker
    public void run(){
        blocker.waitCall();
    }

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Test());
        }
        exec.execute(new Test2());

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            boolean prod = true;
            public void run() {
                if(prod){
                    System.out.println("notify");
                    Test.blocker.prod();
                    prod = false;
                } else {
                    System.out.println("notifyAll");
                    Test.blocker.prodAll();
                    prod = true;
                }
            }
        }, 400, 400);
        TimeUnit.SECONDS.sleep(5);
        timer.cancel();
        System.out.println("Timer canceled");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("Test2.blocker.prodAll");
        Test2.blocker.prodAll();
        TimeUnit.MILLISECONDS.sleep(500);
        exec.shutdownNow();
    }
}

class Test2 implements Runnable{
    static Blocker blocker = new Blocker();
    public void run(){
        blocker.waitCall();
    }
}