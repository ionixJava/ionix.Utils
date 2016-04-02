package ionix.Conversion;

import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;


public class TimestampConvertible implements Convertible{

    @Override
    public boolean toBoolean(Object value) {
        throw new UnsupportedOperationException("Timestamp to Boolean");
    }

    @Override
    public char toChar(Object value) {
        throw new UnsupportedOperationException("Timestamp to Char");
    }

    @Override
    public byte toByte(Object value) {
        throw new UnsupportedOperationException("Timestamp to Byte");
    }

    @Override
    public short toShort(Object value) {
        throw new UnsupportedOperationException("Timestamp to Short");
    }

    @Override
    public int toInt(Object value) {
        throw new UnsupportedOperationException("Timestamp to Integer");
    }

    @Override
    public long toLong(Object value) {
        return ((Timestamp)value).getTime();
    }

    @Override
    public float toFloat(Object value) {
        throw new UnsupportedOperationException("Timestamp to Float");
    }

    @Override
    public double toDouble(Object value) {
        throw new UnsupportedOperationException("Timestamp to Double");
    }

    @Override
    public Date toDate(Object value) {
        throw new UnsupportedOperationException("Timestamp to Date");
    }

    @Override
    public String toString(Object value) {
        return value.toString();
    }

    @Override
    public BigDecimal toBigDecimal(Object value) {
        throw new UnsupportedOperationException("Timestamp to BigDecimal");
    }

    @Override
    public byte[] toByteArray(Object value) {
        throw new UnsupportedOperationException("Timestamp to Byte Array");
    }

    @Override
    public UUID toUUID(Object value) {
        return (UUID)value;
    }

    @Override
    public Timestamp toTimestamp(Object value) {
        return (Timestamp)value;
    }
}
