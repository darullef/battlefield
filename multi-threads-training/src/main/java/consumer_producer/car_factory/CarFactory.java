package consumer_producer.car_factory;

public class CarFactory
{
    public static void main(String[] args)
    {
        CarPartsStorage storage = new CarPartsStorage();
        Producer p1 = new Producer(storage, PartType.BODY, 15);
        Producer p2 = new Producer(storage, PartType.ENGINE, 10);
        Producer p3 = new Producer(storage, PartType.TRANSMISSION, 8);
        Producer p4 = new Producer(storage, PartType.WHEELS, 4);

        Consumer c1 = new Consumer(storage, 5);
        Consumer c2 = new Consumer(storage, 10);

        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);
        Thread t3 = new Thread(p3);
        Thread t4 = new Thread(p4);
        Thread t5 = new Thread(c1);
        Thread t6 = new Thread(c2);

        start(t1, t2, t3, t4, t5, t6);
        join(t1, t2, t3, t4, t5, t6);
    }

    private static void start(Thread t1, Thread t2, Thread t3, Thread t4, Thread t5, Thread t6)
    {
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }

    private static void join(Thread t1, Thread t2, Thread t3, Thread t4, Thread t5, Thread t6)
    {
        try
        {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
            t6.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

}
