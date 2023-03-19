package Thread.tutorial1.H_ReentrantLock.ProducerConsumer;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class Helper
{

    private Source source;
    private Lock lock;
    private Condition condition;
    public synchronized Source getSource()
    {
        if (source == null) source = new Source(new LinkedList<Product>());
        return source;
    }
    public synchronized Lock getLock()
    {
        if (lock == null)
        {
            lock = new ReentrantLock();
        }
        return lock;
    }

    public synchronized Condition getCondition()
    {
        Lock lock = getLock();
        if (condition == null) condition = lock.newCondition();
        return condition;
    }


}
