package race_condition;

public class LongWrapperLock implements ILongWrapper
{
    private final Object LOCK = new Object();
    private long l;

    public LongWrapperLock(long l)
    {
        this.l = l;
    }

    @Override
    public long value()
    {
        return l;
    }

    @Override
    public void increment()
    {
        synchronized (LOCK)
        {
            l = l + 1;
        }
    }
}
