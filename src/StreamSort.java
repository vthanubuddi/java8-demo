import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamSort {
    public static void main(String[] args) {
//        stringSort();
//        intSort();
//        sortWithKeyExtractor();
//        sortWithChainOfComparators();
//        intStreamSort();
        sortWithNulls();
    }

    private static void stringSort() {
        List<String> list = Arrays.asList("Milan",
                "london",
                "San Francisco",
                "Tokyo",
                "New Delhi");
        list.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println(list);

        list.sort(Comparator.naturalOrder());
        System.out.println(list);

        list.sort(Comparator.reverseOrder());
        System.out.println(list);

    }

    private static void intSort() {
        List<Integer> numbers = Arrays.asList(6, 2, 1, 4, 9);
        System.out.println(numbers); //[6, 2, 1, 4, 9]

        numbers.sort(Comparator.naturalOrder());
        System.out.println(numbers); //[1, 2, 4, 6, 9]
        Collections.sort(numbers, Comparator.reverseOrder());
        System.out.println(numbers);
        Collections.sort(numbers);
        System.out.println(numbers);

        List<Integer> list = Arrays.asList(1,5,3,7,2,10,8);
        List<Integer> intArr = list.stream().sorted().collect(Collectors.toList());
        System.out.println(list);
        System.out.println(intArr);
        Collections.sort(list,(i1,i2)->i1.compareTo(i2));
        System.out.println(list);
        Collections.sort(Arrays.asList(1,5,3,7,2,10,8),Integer::compareTo);
    }

    private static void intStreamSort() {
        List<Integer> list = Arrays.asList(1,5,3,7,2,10,8);
        List<Integer> natural = list.stream().sorted().collect(Collectors.toList());
        System.out.println(natural);
        List<Integer> naturalComp = list.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        System.out.println(naturalComp);
        List<Integer> naturalRverse = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(naturalRverse);
        List<Integer> methodReference = list.stream().sorted(Integer::compareTo).collect(Collectors.toList());
        System.out.println(methodReference);
        List<Integer> methodReference2 = list.stream().sorted(Integer::compare).sorted().collect(Collectors.toList());
        System.out.println(methodReference);
    }

    private static void sortWithKeyExtractor() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1, "Venkat", "IT", 20000L));
        list.add(new Employee(2, "Vikranth", "Admin", 10000L));
        list.add(new Employee(3, "Vinay", "HR", 50000L));
        list.add(new Employee(4, "Ram", "Transport", 30000L));
        list.add(new Employee(5, "Prakash", "Electricity", 4000L));

        list.sort(Comparator.comparing(Employee::getName));
        System.out.println(list);

        list.sort(Comparator.comparing(Employee::getDept).reversed());
        System.out.println(list);

        list.sort(Comparator.comparingLong(Employee::getSalary));
        System.out.println(list);

        //Custom comparator with Key extractor
//        list.sort(Comparator.comparing(Employee::getName, (name1, name2) -> ((Character) name1.charAt(1)).compareTo((Character) name2.charAt(1))));
        list.sort(Comparator.comparing(Employee::getName, (name1, name2) -> Character.compare(name1.charAt(1),name2.charAt(1))));

    }

    private static void sortWithChainOfComparators() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1, "Venkat", "IT", 20000L));
        list.add(new Employee(2, "Vikranth", "Admin", 10000L));
        list.add(new Employee(3, "Vinay", "HR", 50000L));
        list.add(new Employee(6, "Vinay", "HR", 60000L));
        list.add(new Employee(4, "Ram", "Transport", 30000L));
        list.add(new Employee(5, "Prakash", "Electricity", 4000L));

        List<Employee> streamSort = list.stream().sorted(Comparator.comparing(Employee::getName, Comparator.reverseOrder())).collect(Collectors.toList());
        System.out.println(streamSort);

        list.sort(Comparator.comparing(Employee::getName)
                .reversed()
                .thenComparing(
                        Comparator.comparingLong(Employee::getSalary).reversed()
                )
        );

        System.out.println(list);
    }

    private static void sortWithNulls() {
        List<Employee> list = new ArrayList<>();
        list.add(null);
        list.add(new Employee(1, "Venkat", "IT", 20000L));
        list.add(new Employee(2, "Vikranth", "Admin", 10000L));
        list.add(new Employee(3, "Vinay", "HR", 50000L));
        list.add(null);
        list.add(new Employee(6, "Vinay", "HR", 60000L));
        list.add(new Employee(4, "Ram", "Transport", 30000L));
        list.add(new Employee(5, "Prakash", "Electricity", 4000L));

        List<Employee> nullsLast = list.stream().sorted(Comparator.nullsLast(Comparator.comparing(Employee::getName))).collect(Collectors.toList());
        System.out.println(nullsLast);
        List<Employee> nullsFirst = list.stream().sorted(Comparator.nullsFirst(Comparator.comparing(Employee::getName))).collect(Collectors.toList());
        System.out.println(nullsFirst);

        list.add(new Employee(10,null,null,2000L));
        List<Employee> nullsFirstWithNullName = list.stream().sorted(Comparator.nullsFirst(Comparator.comparing(Employee::getName,(s1,s2)->{
            if(s1==null)
                return -1;
            if(s2 == null)
                    return 1;

            return s1.compareTo(s2);
        }))).collect(Collectors.toList());
        System.out.println(nullsFirstWithNullName);

    }
}
