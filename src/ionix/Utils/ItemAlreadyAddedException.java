package ionix.Utils;

public class ItemAlreadyAddedException extends RuntimeException {
    public ItemAlreadyAddedException()
    {
        super("Item has already been added");
    }
    public ItemAlreadyAddedException(String message)
    {
        super(message);
    }
}
