package Thread.tutorial1.G_NotifyWait;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Producer
{
    private static final Queue<Product> source = Source.getSource();
    private static final Object LOCK = Source.getLock();
    int limit;
    public Producer(int limit)
    {
        this.limit = limit;
    }
    public void produce()
    {
        while(true)
        {
            try
            {
                Thread.sleep(1000);
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            synchronized (LOCK)
            {
                while (source.size() == limit){
                    try
                    {
                        LOCK.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                var product = new Product();
                System.out.println("[PRODUCER] produce "+product.getName());
                source.add(product);
                LOCK.notify();
            }
        }

    }
}
