package Thread.tutorial1.E_Thread_Pools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Thread_Pools
{
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for(int i = 0; i<10; i++)
        {
            executorService.submit(new Processor());
        }
        executorService.shutdown();

    }

}
