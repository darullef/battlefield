package consumer_producer.car_factory;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Producer implements Runnable
{
    private final CarPartsStorage carPartsStorage;
    private final PartType partType;
    private final int maxProductionTime;
    private final Random random;

    private boolean isWorking = true;

    public Producer(CarPartsStorage carPartsStorage, PartType partType, int maxProductionTime)
    {
        this.carPartsStorage = carPartsStorage;
        this.partType = partType;
        this.maxProductionTime = maxProductionTime;
        this.random = new Random();
    }

    @Override
    public void run()
    {
        while (isWorking)
        {
            int quantity = carPartsStorage.getQuantity(partType);
            carPartsStorage.addPart(partType);
            System.out.println("Current stock of " + partType.name() + " is " + quantity + ", producer add 1 more part");
            sleep();
        }
    }

    public void stop()
    {
        isWorking = false;
    }

    private void sleep()
    {
        try
        {
            TimeUnit.SECONDS.sleep(getDelay());
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    private int getDelay()
    {
        return random.nextInt(maxProductionTime);
    }
}
