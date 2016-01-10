package ionix.Conversion;

import java.math.BigDecimal;
import java.util.UUID;


public class ByteConvertible extends NumericConvertible {

    @Override
    public BigDecimal toBigDecimal(Object value) {
        return new BigDecimal((byte)value);
    }

    @Override
    public byte[] toByteArray(Object value) {
        return new byte[] { (byte)value };
    }

    @Override
    public UUID toUUID(Object value) {
        throw new UnsupportedOperationException("Byte to UUID");
    }
}
