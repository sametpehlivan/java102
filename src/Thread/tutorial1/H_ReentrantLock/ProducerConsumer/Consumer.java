package Thread.tutorial1.H_ReentrantLock.ProducerConsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Consumer
{
    private Source source;
    private Condition condition;
    private Lock lock;
    private static int count = 0;
    private String name;

    public Consumer(Helper helper){
        source = helper.getSource();
        lock = helper.getLock();
        condition = helper.getCondition();
        count++;
        name = "[CONSUMER-"+count+"]";
    }
    public void consume()
    {
        while(true)
        {
            try
            {
              Thread.sleep(2200);
              lock.lock();
              while (source.getList().size() == 0) condition.await();
              var product = source.getList().remove();
              System.out.println(name+" consume " + product.getName() + " QUEUE SIZE : " + source.getList().size());
              condition.signal();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }

        }
    }


}
