package concurrency;

/**
 * @author WangYao
 * @date 2020/6/11
 * @function 优先级
 */
public class SimplePriorities implements Runnable {
    private int countDown = 5;
    private volatile double d = 0.0;
    private int priorities;

    public SimplePriorities(int priorities) {
        this.priorities = priorities;
    }

    @Override
    public String toString() {
        return Thread.currentThread() + ":" + countDown;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priorities);
        while (true){
            for (int i = 1; i < 1000000; i++) {
                d += (Math.PI + Math.E) / (double) i;
                if(i % 10 == 0)
                    Thread.yield();
            }
            System.out.println(this);
            if(--countDown == 0) return;
        }
    }
}
