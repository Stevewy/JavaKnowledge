package concurrency.interrupt;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

/**
 * @author WangYao
 * @date 2020/6/16
 * @function 普通(可打断)
 */
public class SleepBlocked implements Runnable {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e){
            System.out.println("Interrupt");
        }
        System.out.println("exiting SleepBlocked run");
    }
}
