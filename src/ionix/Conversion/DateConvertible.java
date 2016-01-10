package ionix.Conversion;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;


public class DateConvertible implements Convertible {
    @Override
    public boolean toBoolean(Object value) {
        throw new UnsupportedOperationException("Date to boolean");
    }

    @Override
    public char toChar(Object value) {
        throw new UnsupportedOperationException("Date to char");
    }

    @Override
    public byte toByte(Object value) {
        throw new UnsupportedOperationException("Date to byte");
    }

    @Override
    public short toShort(Object value) {
        throw new UnsupportedOperationException("Date to short");
    }

    @Override
    public int toInt(Object value) {
        throw new UnsupportedOperationException("Date to int");
    }

    @Override
    public long toLong(Object value) {
        throw new UnsupportedOperationException("Date to long");
    }

    @Override
    public float toFloat(Object value) {
        throw new UnsupportedOperationException("Date to float");
    }

    @Override
    public double toDouble(Object value) {
        throw new UnsupportedOperationException("Date to double");
    }

    @Override
    public Date toDate(Object value) {
        return (Date)value;
    }

    @Override
    public String toString(Object value) {
        return value.toString();
    }

    @Override
    public BigDecimal toBigDecimal(Object value) {
        throw new UnsupportedOperationException("Date to BigDecimal");
    }

    @Override
    public byte[] toByteArray(Object value) {
        throw new UnsupportedOperationException("Date to ByteArray");
    }

    @Override
    public UUID toUUID(Object value) {
        throw new UnsupportedOperationException("Date to UUID");
    }
}
