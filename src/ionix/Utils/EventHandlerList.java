package ionix.Utils;


import java.util.HashMap;
import java.util.Map;

public class EventHandlerList {
    private final Map<Object, Delegate> map;

    public EventHandlerList() {
        this.map = new HashMap<>();
    }

    public void addHandler(Object key, Action action) {
        if (null != key && null != action) {
            Delegate d = this.map.get(key);
            if (null == d) {
                d = new Delegate();
                this.map.put(key, d);
            }
            d.subscribe(action);
        }
    }

    public void removeHandler(Object key, Action action){
        if (null != key && null != action) {
            Delegate d = this.get(key);
            if (null != d)
                d.unSubscribe(action);
        }
    }

    public Delegate get(Object key){
        Delegate d =  this.map.get(key);
        if (null != d && d.size() == 0)
            d =  null;
        return  d;
    }
}
