package Thread.tutorial1.F_ProducerConsumer;

import java.util.concurrent.ArrayBlockingQueue;

public class Producer
{
    private static final ArrayBlockingQueue<Product> source = Source.getSource();
    public void produce()
    {
        while (true)
        {
            try
            {
                Thread.sleep(1000);
                var product = new Product();
                System.out.println("[PRODUCER] produce "+product.getName());
                source.put(product);
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
