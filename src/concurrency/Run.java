package concurrency;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @author WangYao
 * @date 2020/6/1
 * @function
 */
public class Run {
    public static void main(String[] args) {
        //runnable
        ExecutorService exec = Executors.newCachedThreadPool();   //用时创建
//        ExecutorService exec = Executors.newFixedThreadPool(10);   //一次创建好
//        ExecutorService exec = Executors.newSingleThreadExecutor(); //只有一个(有序)
//        for (int i = 0; i < 5; i++) {
//            new Thread(new LiftOff()).start();
//            exec.execute(new LiftOff());  //管理异步任务执行,无需显示管理线程生命周期
//            exec.execute(new SleepingTask());
//        }

        //callable
//        ArrayList<Future<String>> results = new ArrayList<>();
//        for(int i = 0; i < 10; i++)
//            results.add(exec.submit(new TestWithResult(i)));
//        for (Future<String> fs : results)
//            try {
//                System.out.println(fs.get());
//            } catch (InterruptedException | ExecutionException e){
//                e.printStackTrace();
//            } finally {
//                exec.shutdown();
//            }

        //priority   好像体现不明显
//        for (int i = 0; i < 5; i++)
//            exec.execute(new SimplePriorities(Thread.MIN_PRIORITY));
//        exec.execute(new SimplePriorities(Thread.MAX_PRIORITY));



        exec.shutdown();
    }
}
