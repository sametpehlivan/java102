package Thread.tutorial1.E_Thread_Pools;

public class Processor implements Runnable
{
    private static int count = 0;
    private int id;
    public static int value = 0;
    private static final Object lock = new Object();
    protected Processor()
    {
        count++;
        id = count;
    }
    @Override
    public void run() {
        System.out.println(toString()+" -> Starting...");
        try{
            Thread.sleep(1);
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        synchronized (lock){
            for (int i = 0; i < 100; i++){
                value++;
            }
        }

        System.out.println(toString()+" -> Completed... " + value);
    }
    @Override
    public String toString() {
        return "[ Processor-"+id+" ]";
    }
}
