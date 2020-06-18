package concurrency.interrupt.io;

import concurrency.interrupt.IOBlocked;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author WangYao
 * @date 2020/6/16
 * @function 打断io
 */
public class CloseResource {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        ServerSocket socket = new ServerSocket(8080);
        InputStream input = new Socket("localhost", 8080).getInputStream();
        exec.execute(new IOBlocked(input));
        exec.execute(new IOBlocked(System.in));
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("shut down");
        exec.shutdownNow();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("closing " + input.getClass().getName());
        input.close();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("closing " + System.in.getClass().getName());
        System.in.close();
    }
}
