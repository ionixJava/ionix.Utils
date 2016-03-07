package ionix.Utils;

public class Quartet<T1, T2, T3, T4> {
    public final T1 Item1;
    public final T2 Item2;
    public final T3 Item3;
    public final T4 Item4;

    public Quartet(T1 item1, T2 item2, T3 item3, T4 item4) {
        this.Item1 = item1;
        this.Item2 = item2;
        this.Item3 = item3;
        this.Item4 = item4;
    }
}
