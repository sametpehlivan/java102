package Thread.tutorial1.D_Multiple_Locks;

import java.util.ArrayList;
import java.util.List;

public class Multiple_Locks
{
    private List<Integer> listOne = new ArrayList<>();
    private List<Integer> listTwo = new ArrayList<>();
    private Object LOCK1 = new Object();
    private Object LOCK2 = new Object();
    public  void addListOne(int i)
    {
        try {
            Thread.sleep(1);
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        synchronized (LOCK1){
            listOne.add(i);
        }

    }
    public void addListTwo(int i)
    {
        try {
            Thread.sleep(1);
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        synchronized (LOCK2){
            listTwo.add(i);
        }

    }
    public void addLists()
    {
        Thread t1 = new Thread(()->{
            for (int i=0; i<500; i++)
            {
                addListOne(i);
                addListTwo(i);
            }
        });
        Thread t2 = new Thread(()->{
            for (int i=0; i<500; i++)
            {
                addListOne(i);
                addListTwo(i);
            }
        });
        t1.start();
        t2.start();
        try
        {
            t1.join();
            t2.join();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    public void main()
    {
        System.out.println("Starting");
        long start = System.currentTimeMillis();
        addLists();
        System.out.println("Finished...");
        System.out.println("Time: "+(System.currentTimeMillis()-start));
        System.out.println("List1 Count: "+ listOne.size()+" List2 Count: "+listTwo.size());
    }
}
