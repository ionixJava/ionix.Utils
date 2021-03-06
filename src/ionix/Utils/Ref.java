package ionix.Utils;

import ionix.Conversion.Convert;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;


public final class Ref {
    public static <T> void copyFields(T source, T dest) {
        if (null != source && null != dest) {
            for (Field field : source.getClass().getDeclaredFields()) {
                try {
                    field.setAccessible(true);
                    Object sourceValue = field.get(source);
                    field.set(dest, sourceValue);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public static void copyFieldsSafely(Object source, Object dest, Convert convert) {
        if (null != source && null != dest) {
            Class<?> destClass = dest.getClass();
            for (Field sourceField : source.getClass().getDeclaredFields()) {
                try {
                    sourceField.setAccessible(true);
                    Field destField = destClass.getDeclaredField(sourceField.getName());
                    destField.setAccessible(true);

                    Object sourceValue = sourceField.get(source);
                    setValueSafely(destField, dest, sourceValue, convert);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    public static void copyFieldsSafely(Object source, Object dest){
        copyFieldsSafely(source, dest, Convert.Instance);
    }

    public static void setValueSafely(Field field, Object obj, Object value, Convert convert) {
        try {
            field.set(obj, convert.changeType(value, field.getType()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void setValueSafely(Field field, Object obj, Object value){
        setValueSafely(field, obj, value, Convert.Instance);
    }

    public static Object getDefault(Class<?> cls) {
        if (null != cls) {
            if (cls.isPrimitive()) {
                return 0;
            }
        }
        return null;
    }

    public static Class getClass(String className) {
        if (Ext.isNullOrEmpty(className))
            throw new IllegalArgumentException("className");

        try {
            return Class.forName(className);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static boolean isIterable(Object obj) {
        return obj instanceof Iterable<?>;
    }

    public static boolean isFieldIterable(Field field){
        return null != field ? Iterable.class.isAssignableFrom(field.getType()) : false;
    }

    private static <T extends Annotation> T getAnnotation(Annotation[] ann, Class<T> annotationCls){
        if (null != ann) {
            for (Annotation item : ann) {
                T temp = Ext.as(annotationCls, item);
                if (null != temp)
                    return temp;
            }
        }
        return null;
    }

    public static <T extends Annotation> T getAnnotation(Class objCls, Class<T> annotationCls){
        if (null != objCls && null !=  annotationCls) {
            Annotation[] ann = objCls.getDeclaredAnnotations();
            return getAnnotation(ann, annotationCls);
        }
        return null;
    }

    public static <T extends Annotation> T getAnnotation(Field field, Class<T> annotationCls){
        if (null != field && null != annotationCls) {
            Annotation[] ann = field.getDeclaredAnnotations();
            return getAnnotation(ann, annotationCls);
        }
        return null;
    }
}