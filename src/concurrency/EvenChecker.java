package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author WangYao
 * @date 2020/6/13
 * @function
 */
public class EvenChecker implements Runnable {
    private IntChecker generator;
    private final int id;

    public EvenChecker(IntChecker generator, int id) {
        this.generator = generator;
        this.id = id;
    }

    @Override
    public void run() {
        while (!generator.isCanceled()){
            int val = generator.next();
            if(val % 2 != 0){
                System.out.println(id + ": " + val + "not even!");
                generator.cancel();//一旦有一个不是偶数,所有共用一个intChecker的EvenChecker线程都会停止
            }
        }
    }

    public static void main(String[] args) {
        IntChecker checker = new IntChecker() {
            private int curr = 0;
            @Override
            public synchronized int next() {//加了锁就不会出问题
                curr++;
                Thread.yield();//不加这行效果不明显,但是有
                curr++;
                return curr;
            }
        };

        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 10; i++){
            exec.execute(new EvenChecker(checker, i));
        }
        exec.shutdown();
    }
}
