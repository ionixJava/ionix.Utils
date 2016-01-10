package ionix.Conversion;

import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.util.UUID;


public class DoubleConvertible extends NumericConvertible {

    @Override
    public BigDecimal toBigDecimal(Object value) {
        return new BigDecimal((Double)value);
    }

    @Override
    public byte[] toByteArray(Object value) {
        byte[] bytes = new byte[8];
        ByteBuffer.wrap(bytes).putDouble((Double)value);
        return bytes;
    }

    @Override
    public UUID toUUID(Object value) {
        throw new UnsupportedOperationException("Double to UUID");
    }
}
