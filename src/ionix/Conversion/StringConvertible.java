package ionix.Conversion;

import sun.misc.BASE64Decoder;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


public class StringConvertible implements Convertible {

    @Override
    public boolean toBoolean(Object value) {
        return Boolean.parseBoolean((String)value);
    }

    @Override
    public char toChar(Object value) {
        return ((String)value).charAt(0);
    }

    @Override
    public byte toByte(Object value) {
        return Byte.parseByte((String)value);
    }

    @Override
    public short toShort(Object value) {
        return Short.parseShort((String)value);
    }

    @Override
    public int toInt(Object value) {
        return Integer.parseInt((String)value);
    }

    @Override
    public long toLong(Object value) {
        return Long.parseLong((String)value);
    }

    @Override
    public float toFloat(Object value) {
        return Float.parseFloat((String)value);
    }

    @Override
    public double toDouble(Object value) {
        return Double.parseDouble((String)value);
    }

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
    @Override
    public Date toDate(Object value) {
        try {
            return sdf.parse((String)value);
        }
        catch(Exception ex) {
            return new Date();
        }
    }

    @Override
    public String toString(Object value) {
        return (String)value;
    }

    @Override
    public BigDecimal toBigDecimal(Object value) {
        return new BigDecimal((String)value);
    }

    @Override
    public byte[] toByteArray(Object value) {
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            return decoder.decodeBuffer((String)value);
        }
        catch(Exception ex){
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public UUID toUUID(Object value) {
        return UUID.fromString((String)value);
    }
}
