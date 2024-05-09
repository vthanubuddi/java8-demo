import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class WaysToCreateStream {
    public static void main(String[] args) {
        //1. Empty Stream
        Stream<Object> emptyStream = Stream.empty();

        //2. Stream.of() - Arrays.stream() for Specified Value - the supplied values as var-args, array or list
        Stream<Integer> intStream = Stream.of(1, 2, 3);
        Stream<Integer> integerStream = Stream.of(new Integer[]{1, 2, 3, 4});
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        Stream<ArrayList<Integer>> iLStream = Stream.of(integerList);

        //3.From Collections.stream()
        //Collection.stream() - List(ArrayList, LinkedList), Set (Tree Set, HashSet), Queue
        Stream<Integer> collectionStream = integerList.stream();

        //Map.stream()
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        hashMap.put("Venkat", 6);
        hashMap.put("Vikranth", 8);

        Stream<Map.Entry<String, Integer>> entryStream = hashMap.entrySet().stream();
        Stream<String> keyStream = hashMap.keySet().stream();
        Stream<Integer> valueStream = hashMap.values().stream();

        //4. Stream.builder()
        Stream<String> builderStream = Stream.<String>builder().add("Venkat").add("Vikranth").build();

        //Create Infinite Stream using iterator, generate
        //5. Stream.iterate()
        //iterate(seed, function) – accepts two parameters – a seed which is the first term in the stream, and a function  to produce the value of the next item in the stream. We can limit the stream using the limit() method.
        Stream<Integer> itStream = Stream.iterate(0, n -> n + 2).limit(10);

        //6. Stream.generate()
        //generate(supplier) – accepts a Supplier that provides an infinite series of elements which are placed in the stream. The limit() method can then be called in the stream chain to stop the series after a certain number of elements.
        // This is suitable for generating constant streams, streams of random elements, etc.
        Stream<Double> genStream = Stream.generate(Math::random).limit(10);
        //Random r = new Random()
        //Stream.generate(()->r.nextInt(100)).limit(20)

        //7. Create stream from a Pattern using Predicate
        //stream.filter(pattern.asPridicate);

        //8. From Stream Support
        //Int or long or double streams
        Iterator<Integer> list = Arrays.asList(1,2,3,4,5).iterator();
        Spliterator<Integer> splitorator = Spliterators.spliteratorUnknownSize(list, Spliterator.NONNULL);
       //StreamSupport.intStream(splitorator,false);
    }
}
