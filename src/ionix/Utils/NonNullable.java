package ionix.Utils;

public final class NonNullable<T> {

    private final T value;

    public NonNullable(final T value){

        if (null == value)
            throw  new IllegalArgumentException("value");
        this.value = value;
    }

    public T get() {
        if (null == this.value)
            throw new NullPointerException("value");
        return this.value;
    }
}