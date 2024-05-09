import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamCollectors {
    /**
     * Collector used to accumulate the stream data into a final result data
     * This is worked based on mutable reduction operation
     * This has 3 Generics :
     * <T> : Type of input element from Stream
     * <A> : Type of accumulator result type
     * <R> : Type of final result
     * It has 4 important things
     * 1. Supplier<A> supplier
     * 2. BiConsumer<A,T> accumulator
     * 3. BinaryOperator<A> combiner - combines two accumulators and produce result accumulator
     *      (left,right)->{left.add(right); return left;}
     *      or (left,right)->{supplier.get().add(left).add(right)}
     * 4. Function<A,R> finisher - If A and R same then it will be Identity function
     *
     * Finally, Characteristics (CONCURRENT, UNORDERED, IDENTITY_FINISH)
     *
     * Implementation for Collector
     *      CollectorImpl  available in Collectors class
     *
     * Collectors is a utility class that provides methods to get collector for specific purposes
     * like collect to LIST, MAP, SET
     * Collector fprovide factory method of(Supplier, accumulator, combiner, finisher, characteristics)
     * @param args
     */
    public static void main(String[] args) {

    }

    private static void toList() {
        List<String> cities = Arrays.asList("Delhi", "New York", "Moscow", "Shanghai", "Tokyo");
        cities.stream().collect(Collectors.toList());
    }
}
