package ionix.Conversion;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

public abstract class NumericConvertible implements Convertible{

    private Number cast(Object value){
        return  (Number)value;
    }

    @Override
    public boolean toBoolean(Object value) {
        return cast(value).intValue() == 0;
    }

    @Override
    public char toChar(Object value) {
        return (char)cast(value).intValue();
    }

    @Override
    public byte toByte(Object value) {
        return cast(value).byteValue();
    }

    @Override
    public short toShort(Object value) {
        return cast(value).shortValue();
    }

    @Override
    public int toInt(Object value) {
        return cast(value).intValue();
    }

    @Override
    public long toLong(Object value) {
        return cast(value).longValue();
    }

    @Override
    public float toFloat(Object value) {
        return cast(value).floatValue();
    }

    @Override
    public double toDouble(Object value) {
        return cast(value).doubleValue();
    }

    @Override
    public Date toDate(Object value) {
        long l = cast(value).longValue();
        return new Date(l);
    }

    @Override
    public Timestamp toTimestamp(Object value) {
        throw new UnsupportedOperationException("Numeric to Timestamp");
    }

    @Override
    public String toString(Object value) {
        return value.toString();
    }


    public abstract BigDecimal toBigDecimal(Object value);

    public abstract byte[] toByteArray(Object value);

    public abstract UUID toUUID(Object value);
}
