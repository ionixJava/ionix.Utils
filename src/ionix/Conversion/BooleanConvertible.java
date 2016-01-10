package ionix.Conversion;

import java.math.BigDecimal;
import java.util.UUID;

public class BooleanConvertible extends NumericConvertible {

    @Override
    public BigDecimal toBigDecimal(Object value) {
        return new BigDecimal(((Boolean)value) ? 1 : 0);
    }

    @Override
    public byte[] toByteArray(Object value) {
        return new byte[] { ((Boolean)value) ? (byte)1 : (byte)0 };
    }

    @Override
    public UUID toUUID(Object value) {
        throw new UnsupportedOperationException("Boolean to UUID");
    }
}
