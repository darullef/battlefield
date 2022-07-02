package deadlock;

public class DeadlockMain
{
    public static void main(String[] args) throws InterruptedException
    {
        Deadlock deadlock = new Deadlock();

        Runnable r1 = deadlock::a;
        Runnable r2 = deadlock::b;

        Thread t1 = new Thread(r1);
        t1.start();

        Thread t2 = new Thread(r2);
        t2.start();

        t1.join();
        t2.join();
    }
}
