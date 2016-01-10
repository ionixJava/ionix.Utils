package ionix.Utils;

public class ObjectIsLockedException extends RuntimeException {
    public ObjectIsLockedException()
    {
        super("Object is Locked");
    }
    public ObjectIsLockedException(String message)
    {
        super(message);
    }
}
