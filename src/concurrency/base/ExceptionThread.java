package concurrency.base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author WangYao
 * @date 2020/6/12
 * @function 处理并发时的异常
 */
public class ExceptionThread implements Runnable {
    @Override
    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
//        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler()); //默认捕获器
//        try {
//            ExecutorService exec = Executors.newCachedThreadPool();
//            exec.execute(new ExceptionThread());
//        } catch (Exception e){
            //捕获失败
//            e.printStackTrace();
//        }
        ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
        exec.execute(new ExceptionThread());
    }
}

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught " + e);
    }
}

class HandlerThreadFactory implements ThreadFactory{//从该工厂出来的都带有捕获器
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        return t;
    }
}