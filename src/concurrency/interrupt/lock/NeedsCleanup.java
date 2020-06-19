package concurrency.interrupt.lock;

/**
 * @author WangYao
 * @date 2020/6/18
 * @function 模拟要被清理的资源
 */
public class NeedsCleanup {
    private final int id;

    public NeedsCleanup(int id) {
        this.id = id;
        System.out.println("NeedsCleanup " + id);
    }
    public void cleanup(){
        System.out.println("cleanup " + id);
    }
}
