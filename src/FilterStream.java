import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterStream {
    public static void main(String[] args) {
        //
        Random r = new Random();
        Stream.generate(()-> r.nextInt(1000)).limit(500).filter(i->i%2==0).collect(Collectors.toList()).forEach(System.out::println);

        Stream.of("Venkat","viKranth","Prasu").map(String::toLowerCase).filter(s->s.contains("v")).forEach(System.out::println);

        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee(1, "Venkat", 100000d));
        list.add(new Employee(2, "Vikranth", 200000d));
        list.add(new Employee(3, "Prasu", 50000d));
        list.add(new Employee(4, "Reddy", 75000d));

        list.stream().filter(e -> e.getSalary()>50000d).forEach(e -> System.out.println(e.getName()));

        //Map
        HashMap<String,Integer> population = new HashMap<>();
        population.put("AP",10);
        population.put("TS", 7);
        population.put("TN", 10);
        population.put("KL",5);

        population.entrySet().stream().filter(e->e.getValue()>=7).map(Map.Entry::getKey).forEach(System.out::println);


    }

    public static class Employee{
        Integer id;

        public Employee(Integer id, String name, Double salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getSalary() {
            return salary;
        }

        public void setSalary(Double salary) {
            this.salary = salary;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        Double salary;
    }
}
