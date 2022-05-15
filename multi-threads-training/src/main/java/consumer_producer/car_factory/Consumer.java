package consumer_producer.car_factory;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable
{
    private final CarPartsStorage storage;
    private final int maxProductionTime;
    private final Random random;

    private boolean isWorking = true;

    public Consumer(CarPartsStorage storage, int maxProductionTime)
    {
        this.storage = storage;
        this.maxProductionTime = maxProductionTime;
        this.random = new Random();
    }

    @Override
    public void run()
    {
        while (isWorking)
        {
            int bodyQuantity = storage.getQuantity(PartType.BODY);
            int engineQuantity = storage.getQuantity(PartType.ENGINE);
            int transmissionQuantity = storage.getQuantity(PartType.TRANSMISSION);
            int wheelsQuantity = storage.getQuantity(PartType.WHEELS);

            if (canMakeCar(bodyQuantity, engineQuantity, transmissionQuantity, wheelsQuantity))
            {
                storage.takePart(PartType.BODY);
                storage.takePart(PartType.ENGINE);
                storage.takePart(PartType.TRANSMISSION);
                storage.takePart(PartType.WHEELS);
                storage.makeCar();
                int carsStock = storage.getCarsStock();
                System.out.println("New car has been build! Current stock of cars is " + carsStock);
            }
            else
            {
                System.out.println("Can't build new car! There are missing parts!");
            }
            sleep();
        }
    }

    private boolean canMakeCar(int bodyQuantity, int engineQuantity, int transmissionQuantity, int wheelsQuantity)
    {
        return bodyQuantity >= 1 && engineQuantity >= 1 && transmissionQuantity >= 1 && wheelsQuantity >= 4;
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
