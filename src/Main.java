import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        SAM2 s2 = ()-> System.out.println("Second SAM2");
        SAM1 s1 = ()-> System.out.println("Single in SAM1");

        s1.single();
        s2.single();
        s2.second();

        List<String> names = new ArrayList<>();
        names.add("Venkat");
        System.out.println("" == names.stream().filter(String::isEmpty).collect(Collectors.joining(" | ")));

        List<List<Fruit>> fruits = List.of(List.of(new Fruit("Orange"), new Fruit("Orange"), new Fruit("Mango")),
                List.of(new Fruit("Banana"), new Fruit("Banana"), new Fruit("Mango")));

        // Max Frequent Items
        String value = fruits.stream().flatMap(List::stream).collect(Collectors.groupingBy(Fruit::getName, Collectors.counting()))
                .entrySet().stream().collect(Collectors.groupingBy(Map.Entry::getValue, TreeMap::new, Collectors.mapping(Map.Entry::getKey, Collectors.joining("_"))))
                .lastEntry().getValue();

        System.out.print(value);

    }

    static class Fruit{
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private String name;

        public Fruit(String name){
            this.name = name;
        }
    }
}