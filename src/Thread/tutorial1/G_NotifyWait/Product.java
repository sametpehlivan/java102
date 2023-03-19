package Thread.tutorial1.G_NotifyWait;

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
