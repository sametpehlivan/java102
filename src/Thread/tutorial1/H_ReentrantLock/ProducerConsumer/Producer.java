package Thread.tutorial1.H_ReentrantLock.ProducerConsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Producer
{
    private Source source;
    private Condition condition;
    private Lock lock;
    int limit;
    public Producer(int limit,Helper helper){
        this.limit = limit;
        source = helper.getSource();
        lock = helper.getLock();
        condition = helper.getCondition();
    }
    public void produce()
    {
        while (true)
        {
            try
            {
                Thread.sleep(1000);
                lock.lock();
                while (source.getList().size() == limit) condition.await();
                var product = new Product();
                System.out.println("[PRODUCER] produce "+product.getName());
                source.getList().add(product);
                condition.signal();
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        }
    }
}
