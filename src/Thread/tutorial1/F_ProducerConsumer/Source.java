package Thread.tutorial1.F_ProducerConsumer;

import java.util.concurrent.ArrayBlockingQueue;

public class Source
{
    private static final ArrayBlockingQueue<Product> source = new ArrayBlockingQueue<>(10);

    public static ArrayBlockingQueue<Product> getSource() {
        return Source.source;
    }
}
