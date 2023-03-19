package Thread.tutorial1.F_ProducerConsumer;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Consumer
{
    private static final ArrayBlockingQueue<Product> source = Source.getSource();
    public synchronized void consume()
    {
            while (true)
            {
                try
                {
                    Thread.sleep(1000);
                    var product = source.take();
                    System.out.println("[CONSUMER] consume " + product.getName() + " QUEUE SIZE : " + source.size());
                }catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

            }
    }
}
