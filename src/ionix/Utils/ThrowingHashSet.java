package ionix.Utils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class ThrowingHashSet<T> implements Collection<T>// a proxy
{
    private final Set<T> hash;

    public ThrowingHashSet()
    {
        this.hash = new HashSet<>();
    }

    @Override
    public int size() {
        return this.hash.size();
    }

    @Override
    public boolean isEmpty() {
        return this.hash.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return this.hash.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return this.hash.iterator();
    }

    @Override
    public Object[] toArray() {
        return this.hash.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return this.hash.toArray(a);
    }

    @Override
    public boolean add(T t) {
        if (!this.hash.add(t))
            throw  new ItemAlreadyAddedException();
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return this.hash.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return this.hash.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for(T item : c)
            this.add(item);
        return c.size() >  0;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return this.hash.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return this.hash.retainAll(c);
    }

    @Override
    public void clear() {
        this.hash.clear();
    }

    @Override
    public boolean equals(Object o) {
        return this.hash.equals(o);
    }

    @Override
    public int hashCode() {
        return this.hash.hashCode();
    }
}
