package Thread.tutorial1.H_ReentrantLock;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
    private int count = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void increment(int j)
    {

        for (int i=0; i<1000; i++){
            count += j;
        }

    }
    public void first() {
        lock.lock();
        System.out.println("Waiting Thread 1 ...");
        try {
            condition.await();
            System.out.println("Thread 1 woken up");
            Thread.sleep(2000);
            increment(1);
        }catch (InterruptedException e){

        }finally {
            lock.unlock();
        }


    }
    public void second() {
        System.out.println("Thread 2 sleep...");
        try {
            Thread.sleep(5000);
            lock.lock();
            System.out.println("Press key...");
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
            condition.signal();
            increment(-1);
        }catch (InterruptedException e){

        }finally {
            lock.unlock();
        }


    }
    public void finished(){
        System.out.println("Count: "+count);
    }
}
