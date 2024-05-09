import java.time.Clock;

@FunctionalInterface
public interface SAM2 extends SAM1{
    void second();

    @Override
    default void single() {
        System.out.println("Single in SAM2");
    }
}
