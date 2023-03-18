package Thread.tutorial1.C_Synchronized_Keyword;

public class Synchronized_Keyword
{
    int count = 0;
    public synchronized void increment(int i)
    {
        count += i;
    }
    public void doWork() throws InterruptedException
    {
        Thread t1 = new Thread(()->{
            for (int i = 0;i<5000;i++){
                increment(1);
            }
        });
        Thread t2 = new Thread(()->{
            for (int i = 0;i<5000;i++){
                increment(-1);
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Count: "+count);
    }
    public static void main(String[] args) throws InterruptedException
    {
        Synchronized_Keyword synchronizedKeyword = new Synchronized_Keyword();
        synchronizedKeyword.doWork();

    }
}
