package ionix.Conversion;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class CharacterConvertible implements Convertible {

    private Integer castInt(Object value)
    {
        return new Integer((Character)value);
    }
    @Override
    public boolean toBoolean(Object value) {
        return castInt(value) == 0;
    }

    @Override
    public char toChar(Object value) {
        return (Character)value;
    }

    @Override
    public byte toByte(Object value) {
        return castInt(value).byteValue();
    }

    @Override
    public short toShort(Object value) {
        return castInt(value).shortValue();
    }

    @Override
    public int toInt(Object value) {
        return castInt(value).intValue();
    }

    @Override
    public long toLong(Object value) {
        return castInt(value).longValue();
    }

    @Override
    public float toFloat(Object value) {
        return castInt(value).floatValue();
    }

    @Override
    public double toDouble(Object value) {
        return castInt(value).doubleValue();
    }

    @Override
    public Date toDate(Object value) {
        IntegerConvertible c = new IntegerConvertible();
        return c.toDate(value);
    }

    @Override
    public String toString(Object value) {
        return value.toString();
    }

    @Override
    public BigDecimal toBigDecimal(Object value) {
        return new BigDecimal((Character)value);
    }

    @Override
    public byte[] toByteArray(Object value) {
        throw new UnsupportedOperationException("Character to Byte Array");
    }

    @Override
    public UUID toUUID(Object value) {
        throw new UnsupportedOperationException("Character to UUID");
    }
}
