package concurrency.cooperation.wait;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author WangYao
 * @date 2020/6/19
 * @function
 */
public class Car {
    private boolean waxOn = false;
    public synchronized void waxed(){
        waxOn = true;
        notifyAll(); // 必须先获得锁才能notify
    }

    public synchronized void buffed(){
        waxOn = false;
        notifyAll();
    }

    public synchronized void waitForWax() throws InterruptedException{
        while (!waxOn)//这里使用while而不是if
            wait();
    }

    public synchronized void waitForBuffer() throws InterruptedException{
        while (waxOn)
            wait();
    }

    public static void main(String[] args) throws Exception{
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff(car));
        exec.execute(new WaxOn(car));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}

class WaxOn implements Runnable{
    private Car car;

    public WaxOn(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                System.out.println("Wax On!");
                TimeUnit.MILLISECONDS.sleep(100);
                car.waxed();
                car.waitForBuffer();
            }
        } catch (InterruptedException e){
            System.out.println("InterruptedException");
        }
        System.out.println("End Wax On");
    }
}

class WaxOff implements Runnable{
    private Car car;

    public WaxOff(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                System.out.println("Wax Off!");
                TimeUnit.MILLISECONDS.sleep(100);
                car.buffed();
                car.waitForWax();
            }
        } catch (InterruptedException e){
            System.out.println("InterruptedException");
        }
        System.out.println("End Wax Off");
    }
}