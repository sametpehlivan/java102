package Thread.tutorial1.H_ReentrantLock;

public class ReentrantLock {
    public static void main(String[] args) throws InterruptedException {
        var runner  = new Runner();
        Thread t1 = new Thread(()->runner.first());
        Thread t2 = new Thread(()->runner.second());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        runner.finished();
    }
}
