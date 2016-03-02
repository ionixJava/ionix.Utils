package ionix.Utils;

import com.google.gson.Gson;
import ionix.Conversion.Convert;
import java.util.*;



public final class Ext {

    public static <T> T as(Class<T> clazz, Object obj) {
        if (clazz.isInstance(obj)) {
            return clazz.cast(obj);
        }
        return null;
    }


    public static <T> T convertTo(Class<T> clazz, Object obj) {
        return Ext.as(clazz, Convert.changeType(obj, clazz));
    }



    public static boolean isNull(Object obj) {
        return obj == null || obj.toString().length() == 0;
    }

    public static boolean in(Object itemToFind, Object... items) {
        if (null != items && items.length != 0) {
            for (Object item : items) {
                if (item.equals(itemToFind))
                    return true;
            }
        }
        return false;
    }

    private static final Gson gson = new Gson();

    @SuppressWarnings("unchecked")
    public static <T> T copy(T obj) {
        Class<T> clazz = (Class<T>)obj.getClass();
        return Ser.fromJson(Ser.toJson(obj), clazz);
    }

    public static boolean isEmptyList(Iterable<?> list) {
        if (list != null) {

            if (list instanceof Collection<?>){
                return ((Collection<?>)list).size() == 0;
            }

            Iterator<?> it = list.iterator();
            return !it.hasNext();
        }
        return true;
    }

    public static <T> void addRange(Collection<T> list, Iterable<T> source){
        if (null != list && null != source){
            for(T item : source){
                list.add(item);
            }
        }
    }

    public static <T> List<T> copyIterator(Iterator<T> iter) {
        if (null != iter) {
            List<T> copy = new ArrayList<>();
            while (iter.hasNext())
                copy.add(iter.next());
            return copy;
        }
        return Collections.emptyList();
    }

    public static <T> List<T> copyIterator(Iterable<T> iter) {
        if (iter != null)
            return copyIterator(iter.iterator());
        return Collections.emptyList();
    }

    public static Iterable<?> paging(Iterable<?> iter, int page, int pagesize)
    {
        if (iter != null)
        {
            int from = Math.max(0,page*pagesize);
            List<?> list;
            if (iter instanceof List<?>){
                list = (List<?>)iter;
            }
            else {
                list = copyIterator(iter);
            }
            int to = Math.min(list.size(),(page+1)*pagesize);
            return list.subList(from,to);

        }
        return Collections.emptyList();
    }

    public static <T> SingleItemList<T> toSingleItemList(T item)
    {
        return new SingleItemList(item);
    }

    public static <T> void forEach(Iterable<T> iter, Action<T> func){
        if (null != iter && null != func){
            for(T item : iter){
                func.exec(item);
            }
        }
    }

    public static boolean isNullOrEmpty(String s){
        return s == null || s.isEmpty();
    }


    public static int size(Iterable<?> iterable) {
        if (iterable instanceof Collection)
            return ((Collection<?>)iterable).size();

        Iterator<?> it = iterable.iterator();
        int count = 0;
        while (it.hasNext()) {
            it.next();
            count++;
        }
        return count;
    }

    public static boolean equals(Object objA, Object objB){
        return objA == objB || (objA != null && objB != null && objA.equals(objB));
    }

    public static <T> List toList(Iterable<T> iterable){
        if (null != iterable){
            if (iterable instanceof List){
                return  (List<T>)iterable;
            }
            else{
                ArrayList<T> list = new ArrayList<>();
                for(T item : iterable){
                    list.add(item);
                }
                return list;
            }
        }
        return Collections.emptyList();
    }
}
