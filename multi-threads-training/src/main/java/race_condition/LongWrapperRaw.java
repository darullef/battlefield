package race_condition;

public class LongWrapperRaw implements ILongWrapper
{
    private long l;

    public LongWrapperRaw(long l)
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
        l = l + 1;
    }
}
