package concurrency;

import java.util.Random;

/**
 * @author WangYao
 * @date 2020/6/15
 * @function 线程本地存储
 */
public class ThreadLocalVariableHolder {
    private static ThreadLocal<Integer> value = new ThreadLocal<Integer>(){
        private Random rand = new Random(47);
        protected synchronized Integer initialValue(){
            return rand.nextInt(10000);
        }
    };

    public static void increment(){
        value.set(value.get()+1);
    }

    public static int get(){return value.get();}


}
