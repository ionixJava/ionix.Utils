package ionix.Conversion;

import ionix.Utils.CachedTypes;

import java.math.BigDecimal;
import java.util.HashMap;


public final class Convert {

    private final static HashMap<Class, Convertible> converters = new HashMap<>();

    private static synchronized HashMap<Class, Convertible> getConverter(){
        if (converters.size() == 0){
            converters.put(CachedTypes.String, new StringConvertible());
            converters.put(CachedTypes.BigDecimal, new BigDecimalConvertible());
            converters.put(CachedTypes.Int, new IntegerConvertible());
            converters.put(CachedTypes.Nullable_Int, new IntegerConvertible());
            converters.put(CachedTypes.Date, new DateConvertible());
            converters.put(CachedTypes.Double, new DoubleConvertible());
            converters.put(CachedTypes.Nullable_Double, new DoubleConvertible());
            converters.put(CachedTypes.ByteArray, new ByteArrayConvertible());
            converters.put(CachedTypes.Boolean, new BooleanConvertible());
            converters.put(CachedTypes.Nullable_Boolean, new BooleanConvertible());
            converters.put(CachedTypes.Byte, new ByteConvertible());
            converters.put(CachedTypes.Nullable_Byte, new ByteConvertible());
            converters.put(CachedTypes.Char, new CharacterConvertible());
            converters.put(CachedTypes.Nullable_Char, new CharacterConvertible());
            converters.put(CachedTypes.Float, new FloatConvertible());
            converters.put(CachedTypes.Nullable_Float, new FloatConvertible());
            converters.put(CachedTypes.Short, new ShortConvertible());
            converters.put(CachedTypes.Nullable_Short, new ShortConvertible());
            converters.put(CachedTypes.Long, new LongConvertible());
            converters.put(CachedTypes.Nullable_Long, new LongConvertible());
            converters.put(CachedTypes.UUID, new UUIDConvertible());
        }
        return converters;
    }


    public static Object changeType(Object value, Class targetClass) {

        if (null == targetClass)
            throw new IllegalArgumentException();

        if (null != value) {
            Convertible c = getConverter().get(value.getClass());
            if (null != c) {
                if (targetClass == CachedTypes.String)
                    return  c.toString(value);
                else if (targetClass == CachedTypes.BigDecimal)
                    return c.toBigDecimal(value);
                else if (targetClass == CachedTypes.Int || targetClass == CachedTypes.Nullable_Int)
                    return c.toInt(value);
                else if (targetClass == CachedTypes.Date)
                    return c.toDate(value);
                else if (targetClass == CachedTypes.Double || targetClass == CachedTypes.Nullable_Double)
                    return c.toDouble(value);
                else if (targetClass == CachedTypes.ByteArray)
                    return  c.toByteArray(value);
                else if (targetClass == CachedTypes.Boolean || targetClass == CachedTypes.Nullable_Boolean)
                    return c.toBoolean(value);
                else if (targetClass == CachedTypes.Byte || targetClass == CachedTypes.Nullable_Byte)
                    return c.toByte(value);
                else if (targetClass == CachedTypes.Char || targetClass == CachedTypes.Nullable_Char)
                    return  c.toChar(value);
                else if (targetClass == CachedTypes.Float|| targetClass == CachedTypes.Nullable_Float)
                    return c.toFloat(value);
                else if (targetClass == CachedTypes.Short || targetClass == CachedTypes.Nullable_Short)
                    return c.toShort(value);
                else if (targetClass == CachedTypes.Long || targetClass == CachedTypes.Nullable_Long)
                    return c.toLong(value);
                else if (targetClass == CachedTypes.UUID)
                    return c.toUUID(value);
                else
                    throw new UnsupportedOperationException(targetClass.getName());
            }

            throw new UnsupportedOperationException(value.getClass().getName());
        }
        return null;
    }
}

