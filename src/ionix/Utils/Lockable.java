package ionix.Utils;

public interface Lockable {
    void lock();
    void unLock();
    boolean isLocked();
}
