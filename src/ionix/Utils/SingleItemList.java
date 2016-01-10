package ionix.Utils;

import java.util.Iterator;

public final class SingleItemList<T> implements Iterable<T>
{
    private final T item;

    public SingleItemList(final T item)
    {
        this.item = item;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index == 0;
            }

            @Override
            public T next() {
                return index++ == 0 ? item : null;
            }
        };
    }
}
