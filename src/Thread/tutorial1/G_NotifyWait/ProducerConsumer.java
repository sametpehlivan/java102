package Thread.tutorial1.G_NotifyWait;


public class ProducerConsumer
{
    public static void main(String[] args) throws InterruptedException
    {
        Thread t1 = new Thread(()-> new Producer(10).produce());

        Thread t2 = new Thread(()-> new Consumer().consume());
        Thread t3 = new Thread(()-> new Consumer().consume());
        Thread t4 = new Thread(()-> new Consumer().consume());
        Thread t5 = new Thread(()-> new Consumer().consume());

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();

    }
}
