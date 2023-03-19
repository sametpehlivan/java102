package Thread.tutorial1.G_NotifyWait;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Source
{
    private static final Queue<Product> source = new LinkedList<>();
    private static final Object LOCK = new Object();
    public static Queue<Product> getSource() {

        return Source.source;
    }
    public static Object getLock() {

        return Source.LOCK;
    }
}
