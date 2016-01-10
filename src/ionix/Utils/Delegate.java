package ionix.Utils;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Delegate<E> implements Iterable<Action<E>> {

    private final List<Action<E>> list;

    public Delegate(){
        this.list = new LinkedList<>();
    }

    public Delegate<E> subscribe(Action<E> action){
        if (null != action)
            this.list.add(action);
        return this;
    }

    public boolean unSubscribe(Action<E> action){
        if (null != action)
            return this.list.remove(action);
        return false;
    }

    public void notify(E arg){
        this.list.forEach((item)-> item.exec(arg));
    }

    public void clear(){
        this.list.clear();
    }

    public int size(){
        return this.list.size();
    }

    @Override
    public Iterator<Action<E>> iterator() {
        return this.list.iterator();
    }
}
