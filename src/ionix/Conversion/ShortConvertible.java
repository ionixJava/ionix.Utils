package ionix.Conversion;

import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.util.UUID;


public class ShortConvertible extends NumericConvertible {
    @Override
    public BigDecimal toBigDecimal(Object value) {
        return new BigDecimal((Short)value);
    }

    @Override
    public byte[] toByteArray(Object value) {
        return ByteBuffer.allocate(2).putShort((Short)value).array();
    }

    @Override
    public UUID toUUID(Object value) {
        throw new UnsupportedOperationException("Short to UUID");
    }
}
