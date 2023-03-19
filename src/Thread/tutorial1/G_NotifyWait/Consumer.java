package Thread.tutorial1.G_NotifyWait;

import java.util.Queue;


public class Consumer
{
    private static final Queue<Product> source = Source.getSource();
    private static final Object LOCK = Source.getLock();
    private static int count = 0;
    private String name;
    public Consumer()
    {
        count++;
        name = "[CONSUMER-"+count+"]";
    }
    public synchronized void consume()
    {
        while (true)
        {
            try
            {
                Thread.sleep(5000);
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            synchronized (LOCK)
            {
                while (source.size() == 0){
                    try
                    {
                        LOCK.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                var product = source.remove();
                System.out.println(name+" consume " + product.getName() + " QUEUE SIZE : " + source.size());
                LOCK.notify();
            }
        }

    }
}
