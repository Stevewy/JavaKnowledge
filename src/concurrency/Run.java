package concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author WangYao
 * @date 2020/6/1
 * @function
 */
public class Run {
    public static void main(String[] args) {
//        ExecutorService exec = Executors.newCachedThreadPool(); //用时创建
//        ExecutorService exec = Executors.newFixedThreadPool(5); //一次创建好
        ExecutorService exec = Executors.newSingleThreadExecutor(); //有序
        for (int i = 0; i < 5; i++) {
//            new Thread(new LiftOff()).start(); // 顺序混乱
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
