package ionix.Utils;

public class Locked<T> implements Lockable
{
    private T value;
    private boolean m_isLocked;

    public Locked(T value)
    {
        this.value = value;
        this.m_isLocked = false;
    }

    public T getValue() {
        return this.value;
    }
    public void setValue(final T value)
    {
        if (this.m_isLocked)
            throw  new ObjectIsLockedException("Locked<{0}>.Value is locked. " + value.getClass().getSimpleName());

        this.value = value;
    }

    @Override
    public boolean isLocked() { return this.m_isLocked; }

    @Override
    public void lock()
    {
        this.m_isLocked = true;
    }

    @Override
    public void unLock()
    {
        this.m_isLocked = false;
    }
}

