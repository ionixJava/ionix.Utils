package ionix.Conversion;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;

public interface Convertible {

    boolean toBoolean(Object value);

    char toChar(Object value);

    byte toByte(Object value);

    short toShort(Object value);

    int toInt(Object value);

    long toLong(Object value);

    float toFloat(Object value);

    double toDouble(Object value);

    Date toDate(Object value);

    String toString(Object value);

    BigDecimal toBigDecimal(Object value);

    byte[] toByteArray(Object value);

    UUID toUUID(Object value);

    Timestamp toTimestamp(Object value);
}
