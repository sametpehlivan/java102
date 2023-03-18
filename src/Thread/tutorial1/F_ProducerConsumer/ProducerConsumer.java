package Thread.tutorial1.F_ProducerConsumer;

public class ProducerConsumer
{
    public static void main(String[] args) throws InterruptedException
    {
        Thread t1 = new Thread(()->{
            new Producer().produce();
        });
        Thread t2 = new Thread(()->{
            new Consumer().consume();
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
