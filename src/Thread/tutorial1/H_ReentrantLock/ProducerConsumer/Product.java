package Thread.tutorial1.H_ReentrantLock.ProducerConsumer;

public class Product
{
    private static int count = 0;
    private String name;
    public Product()
    {
        count++;
        name = "[ PRODUCT-"+count+" ]";
    }
    public String getName()
    {
        return name;
    }
}
