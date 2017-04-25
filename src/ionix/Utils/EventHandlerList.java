package ionix.Utils;


import java.util.HashMap;
import java.util.Map;

public class EventHandlerList {
    private final Map<Object, Event> map;

    public EventHandlerList() {
        this.map = new HashMap<>();
    }

    public void addHandler(Object key, Action action) {
        if (null != key && null != action) {
            Event d = this.map.get(key);
            if (null == d) {
                d = new Event();
                this.map.put(key, d);
            }
            d.subscribe(action);
        }
    }

    public void removeHandler(Object key, Action action){
        if (null != key && null != action) {
            Event d = this.get(key);
            if (null != d)
                d.unSubscribe(action);
        }
    }

    public Event get(Object key){
        Event d =  this.map.get(key);
        if (null != d && d.size() == 0)
            d =  null;
        return  d;
    }
}
