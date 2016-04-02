package ionix.Conversion;

import sun.misc.BASE64Encoder;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;


public class ByteArrayConvertible implements Convertible {

    @Override
    public boolean toBoolean(Object value) {
        throw new UnsupportedOperationException("Byte Array to Boolean");
    }

    @Override
    public char toChar(Object value) {
        throw new UnsupportedOperationException("Byte Array to Char");
    }

    @Override
    public byte toByte(Object value) {
        throw new UnsupportedOperationException("Byte Array to Byte");
    }

    @Override
    public short toShort(Object value) {
        throw new UnsupportedOperationException("Byte Array to Short");
    }

    @Override
    public int toInt(Object value) {
        throw new UnsupportedOperationException("Byte Array to Integer");
    }

    @Override
    public long toLong(Object value) {
        throw new UnsupportedOperationException("Byte Array to Long");
    }

    @Override
    public float toFloat(Object value) {
        throw new UnsupportedOperationException("Byte Array to Float");
    }

    @Override
    public double toDouble(Object value) {
        throw new UnsupportedOperationException("Byte Array to Double");
    }

    @Override
    public Date toDate(Object value) {
        throw new UnsupportedOperationException("Byte Array to Date");
    }

    @Override
    public Timestamp toTimestamp(Object value) {
        throw new UnsupportedOperationException("Byte Array to Timestamp");
    }

    @Override
    public String toString(Object value) {
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode((byte[])value);
    }

    @Override
    public BigDecimal toBigDecimal(Object value) {
        BigInteger bi2 = new BigInteger((byte[])value);
        return new BigDecimal(bi2, 0);
    }

    @Override
    public byte[] toByteArray(Object value) {
        return (byte[])value;
    }

    @Override
    public UUID toUUID(Object value) {
        ByteBuffer bb = ByteBuffer.wrap((byte[])value);
        long high = bb.getLong();
        long low = bb.getLong();
        return new UUID(high, low);
    }
}
