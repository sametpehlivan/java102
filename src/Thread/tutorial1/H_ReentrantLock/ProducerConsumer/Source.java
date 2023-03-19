package Thread.tutorial1.H_ReentrantLock.ProducerConsumer;

import java.util.Queue;

public class Source
{
    private static int count = 0;
    private String name;
    private Queue<Product> list;
    public Source(Queue<Product> list)
    {
        count++;
        name = "[ SOURCE-"+count+" ]";
        this.list = list;
    }

    public  Queue<Product> getList()
    {
        return list;
    }
    public String getName(){
        return name;
    }
}
