package Thread.tutorial1.A_StartingThread;

class Runner extends Thread
{
    public void run()
    {
        for (int i=0;i<10;i++){
            System.out.println("Hello " + i);
            try {
                Thread.sleep(100);
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
class RunnerTwo implements Runnable
{
    public void run()
    {
        for (int i=0;i<10;i++){
            System.out.println("Hello " + i);
            try {
                Thread.sleep(100);
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
public class StartingThread
{
    public static void main(String[] args) throws InterruptedException{

        Thread t1 = new Thread(new RunnerTwo());
        RunnerTwo runner2 = new RunnerTwo();
        Thread t2 = new Thread(runner2);
        t1.start();
        t1.join();
        t2.start();
        System.out.println("Hello Main");
    }
}
