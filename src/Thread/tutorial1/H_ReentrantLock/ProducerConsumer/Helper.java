package Thread.tutorial1.H_ReentrantLock.ProducerConsumer;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class Helper
{
    private Source source = new Source(new LinkedList<Product>());
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public Source getSource()
    {
        return source;
    }
    public Lock getLock()
    {
        return lock;
    }

    public Condition getCondition()
    {
        return condition;
    }


}
