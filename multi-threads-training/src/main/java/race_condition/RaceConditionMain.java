package race_condition;

public class RaceConditionMain
{
    public static void main(String[] args) throws InterruptedException
    {
        long startValue = 0L;
        LongWrapperRaw l1 = new LongWrapperRaw(startValue);
        singleThread(l1);
        multiThread(l1);

        LongWrapperLock l2 = new LongWrapperLock(startValue);
        singleThread(l2);
        multiThread(l2);

        LongWrapperSynchronized l3 = new LongWrapperSynchronized(startValue);
        singleThread(l3);
        multiThread(l3);
    }

    private static void multiThread(ILongWrapper longWrapper) throws InterruptedException
    {
        Runnable r = () -> {
            for (int i = 0; i < 1000; i++)
            {
                longWrapper.increment();
            }
        };

        Thread[] threads = new Thread[1000];
        for (int i = 0; i < threads.length; i++)
        {
            threads[i] = new Thread(r);
            threads[i].start();
        }

        for (Thread thread : threads)
        {
            thread.join();
        }

        System.out.println("Multi thread result: " + longWrapper.value());
    }

    private static void singleThread(ILongWrapper longWrapper) throws InterruptedException
    {
        Runnable r = () -> {
            for (int i = 0; i < 1000; i++)
            {
                longWrapper.increment();
            }
        };

        Thread t1 = new Thread(r);
        t1.start();
        t1.join();

        System.out.println("Single thread result: " + longWrapper.value());
    }

}
