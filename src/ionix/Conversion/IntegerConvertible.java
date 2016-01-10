package ionix.Conversion;

import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.util.UUID;

public class IntegerConvertible extends NumericConvertible{

    @Override
    public BigDecimal toBigDecimal(Object value) {
        return new BigDecimal((Integer)value);
    }

    @Override
    public byte[] toByteArray(Object value) {
        return ByteBuffer.allocate(4).putInt((Integer)value).array();
    }

    @Override
    public UUID toUUID(Object value) {
        throw new UnsupportedOperationException("Integer to UUID");
    }
}
