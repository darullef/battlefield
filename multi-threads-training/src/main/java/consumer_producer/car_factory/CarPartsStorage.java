package consumer_producer.car_factory;

import java.util.concurrent.atomic.AtomicInteger;

public class CarPartsStorage
{
    private final AtomicInteger body;
    private final AtomicInteger engine;
    private final AtomicInteger transmission;
    private final AtomicInteger wheels;
    private final AtomicInteger cars;

    public CarPartsStorage()
    {
        this.body = new AtomicInteger(0);
        this.engine = new AtomicInteger(0);
        this.transmission = new AtomicInteger(0);
        this.wheels = new AtomicInteger(0);
        this.cars = new AtomicInteger(0);
    }

    public synchronized void addPart(PartType partType)
    {
        switch (partType)
        {
            case BODY -> body.incrementAndGet();
            case ENGINE -> engine.incrementAndGet();
            case TRANSMISSION -> transmission.incrementAndGet();
            case WHEELS -> wheels.incrementAndGet();
        }
    }

    public synchronized int getQuantity(PartType partType)
    {
        int result;
        switch (partType)
        {
            case BODY -> result = body.get();
            case ENGINE -> result = engine.get();
            case TRANSMISSION -> result = transmission.get();
            case WHEELS -> result = wheels.get();
            default -> result = 0;
        }
        return result;
    }

    public synchronized int getCarsStock()
    {
        return cars.get();
    }

    public synchronized void takePart(PartType partType)
    {
        switch (partType)
        {
            case BODY -> body.decrementAndGet();
            case ENGINE -> engine.decrementAndGet();
            case TRANSMISSION -> transmission.decrementAndGet();
            case WHEELS -> wheels.decrementAndGet();
        }
    }

    public synchronized void makeCar()
    {
        cars.incrementAndGet();
    }
}
