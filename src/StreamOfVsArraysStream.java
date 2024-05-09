import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOfVsArraysStream {
    public static void main(String[] args) {
        /*
         * Arrays.stream() returns
         * For primitives
         * IntStream for integer array
         * LongStream for long array
         * DoubleStream for double array
         * Throws error for any other primitive data
         *
         * For non-primitives(Including Wrapper classes) it returns
         * Stream<T> - Generics for streams
         *
         * */
        int[] arr = {1, 2, 3, 3, 4, 5, 5, 55, 6};
        IntStream stream = Arrays.stream(arr);

        Integer[] arr2 = {9, 8, 7};
        Stream<Integer> stream2 = Arrays.stream(arr2);

        String[] names = {"Venkat", "Vikranth", "Prasu"};
        Stream<String> nameStream = Arrays.stream(names);

        char[] chars = {'V', 'E', 'N', 'K', 'A', 'T'};
//        Object charStream = Arrays.stream(chars);

        Character []characters = {'V', 'E', 'N', 'K', 'A', 'T'};
        Stream<Character> charStream = Arrays.stream(characters);

        /* Stream.of()
        * Provides Stream<T> always - There is no special stream for any data type
        * It's Just a wrapper around Arrays.Stream()
        * But has some differences
        *  For Non-primitives array<T> and Wrapper arrays
        *   - Invokes Arrays.Stream() - Stream<T> so no difference in stream
        *  For primitive arrays
        *   - It creates Stream<T[]> (Instead ofIntStream, LongStream, DoubleStream)
        * With vararg method
        *   Creates Stream<T> - T type of the argument
        **/

        Stream<String> nameStream3 = Stream.of(names);
        Integer[] intWrapArray = new Integer[]{1,2,3};
        Stream<Integer> wrapperintStream = Stream.of(intWrapArray);

        //Later we need to convert int[], long[], double[] streams to IntStream, DoubleStream, LongStream
        // stream.flatMapToInt() to get IntStream
        // Stream.flatMapToLong() to get LongStream
        // stream.flatMapToDouble() to get DoubleStream
        //For other primitive convert the type to Wrapper to get Stream<T> T is wrapper
        Stream<int[]> intStream2 = Stream.of(arr);
        Stream<char[]> charStream2 = Stream.of(chars);

        //Vararg method
        Stream<String> nameStream2 = Stream.of("Venkat", "Vikranth", "prasu");
        Stream<Character> charStream3 = Stream.of('V', 'N');
        Stream<Integer> intStream3 = Stream.of(1, 2, 3, 4, 5);

        Stream<String[]> varargStream = Stream.of(names, names, names);

    }

}
