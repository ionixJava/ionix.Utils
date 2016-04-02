package ionix.Conversion;

import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;


public class UUIDConvertible implements Convertible{

    @Override
    public boolean toBoolean(Object value) {
        throw new UnsupportedOperationException("UUID to Boolean");
    }

    @Override
    public char toChar(Object value) {
        throw new UnsupportedOperationException("UUID to Char");
    }

    @Override
    public byte toByte(Object value) {
        throw new UnsupportedOperationException("UUID to Byte");
    }

    @Override
    public short toShort(Object value) {
        throw new UnsupportedOperationException("UUID to Short");
    }

    @Override
    public int toInt(Object value) {
        throw new UnsupportedOperationException("UUID to Integer");
    }

    @Override
    public long toLong(Object value) {
        throw new UnsupportedOperationException("UUID to Long");
    }

    @Override
    public float toFloat(Object value) {
        throw new UnsupportedOperationException("UUID to Float");
    }

    @Override
    public double toDouble(Object value) {
        throw new UnsupportedOperationException("UUID to Double");
    }

    @Override
    public Date toDate(Object value) {
        throw new UnsupportedOperationException("UUID to Date");
    }

    @Override
    public String toString(Object value) {
        return value.toString();
    }

    @Override
    public BigDecimal toBigDecimal(Object value) {
        throw new UnsupportedOperationException("UUID to BigDecimal");
    }

    @Override
    public byte[] toByteArray(Object value) {
        UUID uuid = (UUID)value;
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());
        return bb.array();
    }

    @Override
    public UUID toUUID(Object value) {
        return (UUID)value;
    }

    @Override
    public Timestamp toTimestamp(Object value) {
        throw new UnsupportedOperationException("Byte Array to Timestamp");
    }
}
