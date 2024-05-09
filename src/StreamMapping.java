import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMapping {
    public static void main(String[] args) {
        map();
        flatMap();
        flatMapWithArrays();
    }

    public static void map(){
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        stream.map(i->i*i).forEach(System.out::println);

        String[] names = {"venkat", "vikranth", "reddy", "india"};
        Stream<String> nameStream = Stream.of(names);
        nameStream.map(String::toUpperCase)
                .forEach(System.out::println);

        Stream.of(names).map(String::length).forEach(System.out::println);

        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee(1,"venkat",200000, "IT"));
        list.add(new Employee(2,"Ram",100000, "Security"));
        list.add(new Employee(3,"Vinay",250000, "HR"));
        list.add(new Employee(4,"Ashok",150000, "Admin"));
        list.add(new Employee(5,"Ravi",120000, "IT"));

        list.stream().map(Employee::getName).forEach(System.out::println);
        //Constructor reference
        list.stream().map(Staff::new).map(Staff::getName).forEach(System.out::println);

        list.stream().map(emp -> {
            return new Staff(emp);
        }).map(Staff::getName).forEach(System.out::println);
    }

    public static  void flatMap(){
        // Creating a list of Prime Numbers
        List<Integer> PrimeNumbers = Arrays.asList(5, 7, 11,13);

        // Creating a list of Odd Numbers
        List<Integer> OddNumbers = Arrays.asList(1, 3, 5);

        // Creating a list of Even Numbers
        List<Integer> EvenNumbers = Arrays.asList(2, 4, 6, 8);

        List<List<Integer>> listOfListofInts =
                Arrays.asList(PrimeNumbers, OddNumbers, EvenNumbers);

        List<Integer> list = listOfListofInts.stream().flatMap(List::stream).collect(Collectors.toList());


        System.out.println(listOfListofInts);
        System.out.println(list);

        List<List<Integer>> mapList = listOfListofInts.stream().map(e -> e).collect(Collectors.toList());
    }

    public static void flatMapWithArrays() {
        String[] a = { "A", "B", "C" };
        String[] b = { "i", "J", "K" };

        Stream<String[]> arrayStream = Stream.of(a, b);
        arrayStream.flatMap(Arrays::stream).forEach(System.out::println);
        //arrayStream.flatMap(ar -> Arrays.stream(ar)).forEach(System.out::println);
    }
    public static class Employee {
        Integer id;
        String name;
        Integer salary;
        String dept;

        public Employee(Integer id, String name, Integer salary, String dept) {
            this.id = id;
            this.name = name;
            this.salary = salary;
            this.dept = dept;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getSalary() {
            return salary;
        }

        public void setSalary(Integer salary) {
            this.salary = salary;
        }

        public String getDept() {
            return dept;
        }

        public void setDept(String dept) {
            this.dept = dept;
        }
    }
    public static class Staff{
        Integer id;
        String name;
        String dept;

        public Staff(Employee emp) {
            this.id = emp.getId();
            this.name = "Staff"+emp.getName();
            this.dept = emp.getDept();

        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDept() {
            return dept;
        }

        public void setDept(String dept) {
            this.dept = dept;
        }
    }

}
