package Thread.tutorial1.H_ReentrantLock.ProducerConsumer;


public class App
{
    public static void main(String[] args) throws InterruptedException
    {
        Helper helper = new Helper();
        Thread t1 = new Thread(()-> new Producer(10,helper).produce());
        Thread t2 = new Thread(()-> new Consumer(helper).consume());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
