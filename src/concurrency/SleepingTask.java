package concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @author WangYao
 * @date 2020/6/10
 * @function 睡眠
 */
public class SleepingTask extends LiftOff {
    public void run(){
        try {
            while (countDown-- > 0) {
                System.out.println(status());
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }


}
