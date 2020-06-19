package concurrency.interrupt.lock;

/**
 * @author WangYao
 * @date 2020/6/18
 * @function 一个线程获得一个对象锁后可以调用其他synchronized方法
 */
public class MultiLock {
    public synchronized void f1(int count){
        if(count-- > 0){
            System.out.println("f1() calling f2() with count " + count);
            f2(count);
        }
    }

    public synchronized void f2(int count){
        if(count-- > 0){
            System.out.println("f2() calling f1() with count " + count);
            f1(count);
        }
    }

    public static void main(String[] args) {
        MultiLock multiLock = new MultiLock();
        new Thread() {
            public void run(){
                multiLock.f1(10);
            }
        }.start();
    }
}
