package concurrency.interrupt;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author WangYao
 * @date 2020/6/18
 * @function io (不可打断)
 */
public class IOBlocked implements Runnable{
    private InputStream in;

    public IOBlocked(InputStream in) {
        this.in = in;
    }

    @Override
    public void run() {
        try {
            System.out.println("wait for read");
            in.read();
        } catch (IOException e){
            if(Thread.currentThread().isInterrupted())
                System.out.println("io interrupted");
            else
                throw new RuntimeException(e);
        }
        System.out.println("exiting IOBlocked run");
    }
}