package StreamDemo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class streamOperationDemo {

    static List<Student> stdList = Arrays.asList(

            new Student("Tim", 21, 5000.00),
            new Student("Rim", 19, 10000.00),
            new Student("Kim", 22, 7000.00),
            new Student("Jim", 18, 8000.00),
            new Student("Xim", 20, 2000.00));

    public static void main(String[] aa) {

        // List<Student> filteredstdList = stdList.stream()
        // .limit(3)
        // .collect(Collectors.toList());

        // List<Student> filteredstdList = stdList.stream()
        // .distinct()
        // .collect(Collectors.toList());

        // List<Student> filteredstdList = stdList.stream()
        // .filter((Student std) -> std.getStdAge() > 21)
        // .collect(Collectors.toList());

        // List<Student> filteredstdList = stdList.stream()
        // .skip(2)
        // .collect(Collectors.toList());

        // filteredstdList.forEach(System.out::println);

        // Stream.iterate(0, n -> n + 2)
        // .peek(num -> System.out.println(num))
        // .limit(7)
        // .forEach(System.out::println);

        List<Double> feeList = stdList.stream()
                .map(std -> std.getFeeAmount())
                .collect(Collectors.toList());

        feeList.forEach(System.out::println);

        double totalFee = stdList.stream()
                .map(std -> std.getFeeAmount())
                .reduce(0.00, (a, b) -> a + b);

        System.out.println("Total Fee Is :" + totalFee);
    }
}