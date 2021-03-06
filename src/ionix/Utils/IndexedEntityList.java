package ionix.Utils;

import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


public class IndexedEntityList<TEntity> implements Collection<TEntity>{

    public static <TEntity> IndexedEntityList<TEntity> create(String... fieldNames)
    {
        return new IndexedEntityList<>(new HashMap<>(), fieldNames);
    }

    public static <TEntity> IndexedEntityList createConcurrent(String... fieldNames)
    {
        return new IndexedEntityList<TEntity>(new ConcurrentHashMap<>(), fieldNames);
    }


    private final Map<Key, TEntity> map;
    private final String[] fieldNames;
    private final HashSet<Field> fields;

    private IndexedEntityList(final Map<Key, TEntity> map,  String... fieldNames) {

        if (null == fieldNames || 0 == fieldNames.length)
            throw new IllegalArgumentException("fieldNames");

        this.map = map;
        this.fieldNames = fieldNames;
        this.fields = new HashSet<>(fieldNames.length);
    }

    private synchronized Collection<Field> getFields(TEntity entity) {
        if (fields.size() == 0) {
            Class elementClass = entity.getClass();
            for (String fm : fieldNames) {
                try {
                    Field f = elementClass.getDeclaredField(fm);
                    f.setAccessible(true);
                    this.fields.add(f);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        return this.fields;
    }

    private Key getKey(TEntity entity) {
        return new Key(this.getFields(entity), entity);
    }

    @Override
    public int size() {
        return this.map.size();
    }

    @Override
    public boolean isEmpty(){
        return this.map.isEmpty();
    }

    @Override
    public boolean contains(Object obj){
        if (null != obj) {
            Key k = this.getKey((TEntity) obj);
            return this.map.containsKey(k);
        }
        return false;
    }

    @Override
    public Iterator<TEntity> iterator(){
        return this.map.values().iterator();
    }

    @Override
    public Object[] toArray(){
        return this.map.values().toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return this.map.values().toArray(a);
    }

    @Override
    public boolean add(TEntity entity) {
        if (null != entity) {
            this.map.put(this.getKey(entity), entity);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object entity) {
        if (null != entity) {
            Key k = this.getKey((TEntity)entity);
            return this.map.remove(k) != null;
        }
        return false;
    }

    public boolean remove(Object... keyValues) {
        if (keyValues != null && keyValues.length > 0) {
            Key k = new Key(keyValues);
            return this.map.remove(k) != null;
        }
        return false;
    }


    @Override
    public boolean containsAll(Collection<?> c){
        if (null != c){
            boolean ret = true;
            for(Object item : c){
                ret = this.contains(item) && ret;
                if (!ret)
                    return false;
            }
            return ret;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends TEntity> c){
        if (null != c)
        {
            boolean ret = true;
            for(TEntity entity : c)
            {
                ret = this.add(entity) && ret;
            }
            return ret;
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c){
        if (null != c){
            boolean ret = true;
            for(Object item : c){
                ret = this.remove(item) && ret;
            }
            return ret;
        }
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c){
        if (null != c){
            IndexedEntityList<TEntity> retainList = IndexedEntityList.create(this.fieldNames);
            for(Object item : c){
                if(this.contains(item)) {
                    retainList.add((TEntity)item);
                }
            }

            boolean ret = true;
            ArrayList<TEntity> tempList = new ArrayList<>(this);
            for(TEntity e : tempList){
                if (!retainList.contains(e)){
                    ret = this.remove(e) && ret;
                }
            }
            return ret;
        }
        return false;
    }

    @Override
    public void clear() {
        this.map.clear();
    }


    public TEntity find(Object... keyValues)
    {
        if (keyValues != null && keyValues.length > 0)
        {
            Key k = new Key(keyValues);
            return this.map.get(k);
        }
        return null;
    }


    private final class Key {
        private final Object[] keys;

        Key(Collection<Field> keys, TEntity entity) {
            this.keys = new Object[keys.size()];
            int index = 0;
            for (Field field : keys) {
                try {
                    // field.setAccessible(true);
                    this.keys[index++] = field.get(entity);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        }

        Key(Object[] keys) {
            this.keys = keys;
        }


        @Override
        public int hashCode() {
            int length = this.keys.length;
            int hash = 17;
            for (int j = 0; j < length; ++j) {
                hash = hash * 23 + this.keys[j].hashCode();
            }
            return hash;


//            int size = this.keys.length;
//            int hash = 0;
//            for (int j = 0; j < size; ++j) {
//                hash ^= this.keys[j].hashCode();
//            }
//            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            return obj.hashCode() == this.hashCode();
        }
    }
}
