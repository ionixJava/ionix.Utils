package ionix.Conversion;

import ionix.Utils.CachedTypes;

import java.util.HashMap;


//inheritable hale getirildi.
public class Convert {
    public final static Convert Instance = new Convert();

    protected Convert(){}

    private final HashMap<Class, Convertible> converters = new HashMap<>();

    protected void putConverters(HashMap<Class, Convertible> converterRepo){
        converterRepo.put(CachedTypes.String, new StringConvertible());
        converterRepo.put(CachedTypes.BigDecimal, new BigDecimalConvertible());
        converterRepo.put(CachedTypes.Int, new IntegerConvertible());
        converterRepo.put(CachedTypes.Nullable_Int, new IntegerConvertible());
        converterRepo.put(CachedTypes.Date, new DateConvertible());
        converterRepo.put(CachedTypes.Double, new DoubleConvertible());
        converterRepo.put(CachedTypes.Nullable_Double, new DoubleConvertible());
        converterRepo.put(CachedTypes.ByteArray, new ByteArrayConvertible());
        converterRepo.put(CachedTypes.Boolean, new BooleanConvertible());
        converterRepo.put(CachedTypes.Nullable_Boolean, new BooleanConvertible());
        converterRepo.put(CachedTypes.Byte, new ByteConvertible());
        converterRepo.put(CachedTypes.Nullable_Byte, new ByteConvertible());
        converterRepo.put(CachedTypes.Char, new CharacterConvertible());
        converterRepo.put(CachedTypes.Nullable_Char, new CharacterConvertible());
        converterRepo.put(CachedTypes.Float, new FloatConvertible());
        converterRepo.put(CachedTypes.Nullable_Float, new FloatConvertible());
        converterRepo.put(CachedTypes.Short, new ShortConvertible());
        converterRepo.put(CachedTypes.Nullable_Short, new ShortConvertible());
        converterRepo.put(CachedTypes.Long, new LongConvertible());
        converterRepo.put(CachedTypes.Nullable_Long, new LongConvertible());
        converterRepo.put(CachedTypes.UUID, new UUIDConvertible());
        converterRepo.put(CachedTypes.Timestamp, new TimestampConvertible());
    }

    //template method pattern
    private synchronized HashMap<Class, Convertible> getConverter(){
        if (this.converters.size() == 0){
            this.putConverters(this.converters);
        }
        return this.converters;
    }

    protected Object convert(Convertible c,Object value, Class targetClass) {
        if (targetClass == CachedTypes.String)
            return c.toString(value);
        else if (targetClass == CachedTypes.BigDecimal)
            return c.toBigDecimal(value);
        else if (targetClass == CachedTypes.Int || targetClass == CachedTypes.Nullable_Int)
            return c.toInt(value);
        else if (targetClass == CachedTypes.Date)
            return c.toDate(value);
        else if (targetClass == CachedTypes.Timestamp)
            return c.toTimestamp(value);
        else if (targetClass == CachedTypes.Double || targetClass == CachedTypes.Nullable_Double)
            return c.toDouble(value);
        else if (targetClass == CachedTypes.ByteArray)
            return c.toByteArray(value);
        else if (targetClass == CachedTypes.Boolean || targetClass == CachedTypes.Nullable_Boolean)
            return c.toBoolean(value);
        else if (targetClass == CachedTypes.Byte || targetClass == CachedTypes.Nullable_Byte)
            return c.toByte(value);
        else if (targetClass == CachedTypes.Char || targetClass == CachedTypes.Nullable_Char)
            return c.toChar(value);
        else if (targetClass == CachedTypes.Float || targetClass == CachedTypes.Nullable_Float)
            return c.toFloat(value);
        else if (targetClass == CachedTypes.Short || targetClass == CachedTypes.Nullable_Short)
            return c.toShort(value);
        else if (targetClass == CachedTypes.Long || targetClass == CachedTypes.Nullable_Long)
            return c.toLong(value);
        else if (targetClass == CachedTypes.UUID)
            return c.toUUID(value);
        else
            return null;
    }

    public final Object changeType(Object value, Class targetClass) {
        if (null == targetClass)
            throw new IllegalArgumentException();

        if (null != value) {//null için elbette casting e gerek yok
            Convertible c = this.getConverter().get(value.getClass());
            if (null != c) {
                Object convertedValue = this.convert(c,value, targetClass);
                if (null == convertedValue)
                    throw new UnsupportedOperationException(c.getClass().getName() + " can not convert to type: " + targetClass.getName());

                return convertedValue;
            }
            throw new UnsupportedOperationException("No Convertible found for type: " + value.getClass().getName());
        }
        return null;
    }
}

