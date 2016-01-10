package ionix.Conversion;

import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.util.UUID;


public class LongConvertible extends NumericConvertible {
    @Override
    public BigDecimal toBigDecimal(Object value) {
        return new BigDecimal((Long)value);
    }

    @Override
    public byte[] toByteArray(Object value) {
        return ByteBuffer.allocate(8).putLong((Long)value).array();
    }

    @Override
    public UUID toUUID(Object value) {
        throw new UnsupportedOperationException("Long to UUID");
    }
}
