package ionix.Conversion;

import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.util.UUID;


public class FloatConvertible extends NumericConvertible {

    @Override
    public BigDecimal toBigDecimal(Object value) {
        return new BigDecimal((Float)value);
    }

    @Override
    public byte[] toByteArray(Object value) {
        byte[] bytes = new byte[4];
        ByteBuffer.wrap(bytes).putDouble((Float)value);
        return bytes;
    }

    @Override
    public UUID toUUID(Object value) {
        throw new UnsupportedOperationException("Float to UUID");
    }
}
