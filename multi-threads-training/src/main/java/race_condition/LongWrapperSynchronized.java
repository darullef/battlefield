package race_condition;

public class LongWrapperSynchronized implements ILongWrapper
{
    private long l;

    public LongWrapperSynchronized(long l)
    {
        this.l = l;
    }

    @Override
    public long value()
    {
        return l;
    }

    @Override
    public synchronized void increment()
    {
        l = l + 1;
    }
}
