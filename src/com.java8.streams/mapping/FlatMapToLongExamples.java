package com.java8.streams.mapping;

import java.util.List;

public class FlatMapToLongExamples {

    /*
     Definition:
     flatMapToLong() is an intermediate stream operation that transforms each element
     into a LongStream and then flattens those streams into a single LongStream.

     Method Signature:
     LongStream flatMapToLong(Function<? super T, ? extends LongStream> mapper)

     Characteristics:
     - Intermediate operation
     - Lazy
     - One-to-many transformation to long
    */

    public static void main(String[] args) {

        // Example 1: Integer transformation
        // Flatten list of lists to LongStream
        List<List<Integer>> listOfLists = List.of(
            List.of(1, 2),
            List.of(3, 4)
        );

        System.out.println("Example 1: Integer transformation");
        listOfLists.stream()
                   .flatMapToLong(list -> list.stream().mapToLong(Integer::longValue))
                   .forEach(System.out::println);

        /*
        Output:
        1
        2
        3
        4
        */

        // Example 2: String transformation
        // Get hash codes as long from list of strings
        List<String> words = List.of("hello", "world");

        System.out.println("\nExample 2: String transformation");
        words.stream()
             .flatMapToLong(word -> java.util.stream.LongStream.of(word.hashCode()))
             .forEach(System.out::println);

        /*
        Output:
        99162322
        113318802
        */

        // Example 3: Object transformation
        // Flatten salaries as long from employees in companies
        List<Company> companies = List.of(
            new Company("TechCorp", List.of(new Employee("John", 30, 50000), new Employee("Jane", 25, 60000))),
            new Company("BizInc", List.of(new Employee("Bob", 35, 70000)))
        );

        System.out.println("\nExample 3: Object transformation");
        companies.stream()
                 .flatMapToLong(company -> company.getEmployees().stream().mapToLong(emp -> (long) emp.getSalary()))
                 .forEach(System.out::println);

        /*
        Output:
        50000
        60000
        70000
        */

        // Example 4: Array transformation
        // Flatten arrays to long (converting int to long)
        List<int[]> arrays = List.of(
            new int[]{1, 2},
            new int[]{3, 4}
        );

        System.out.println("\nExample 4: Array transformation");
        arrays.stream()
              .flatMapToLong(arr -> java.util.Arrays.stream(arr).mapToLong(i -> (long) i))
              .forEach(System.out::println);

        /*
        Output:
        1
        2
        3
        4
        */

        // Example 5: Real-world backend example
        // Sum all salaries as long from companies
        System.out.println("\nExample 5: Real-world - Sum of all salaries");
        long totalSalary = companies.stream()
                                    .flatMapToLong(company -> company.getEmployees().stream().mapToLong(emp -> (long) emp.getSalary()))
                                    .sum();
        System.out.println("Total salary: " + totalSalary);

        /*
        Output:
        Total salary: 180000
        */

    }
}
