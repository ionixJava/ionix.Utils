package ionix.Conversion;

import java.math.BigDecimal;
import java.util.UUID;

public class BigDecimalConvertible extends NumericConvertible {
    @Override
    public BigDecimal toBigDecimal(Object value) {
        return (BigDecimal)value;
    }

    @Override
    public byte[] toByteArray(Object value) {
        return ((BigDecimal)value).unscaledValue().toByteArray();
    }

    @Override
    public UUID toUUID(Object value) {
        throw new UnsupportedOperationException("BigDecimal to UUID");
    }
}
