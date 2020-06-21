package concurrency.lock;

/**
 * @author WangYao
 * @date 2020/6/13
 * @function
 */
public abstract class IntChecker {
    private volatile boolean canceled = false; //为了原子性和可视性
    public abstract int next();

    public void cancel(){canceled = true;}

    public boolean isCanceled(){return canceled;}
}
