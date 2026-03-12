package com.java8.streams.mapping;

import java.util.List;

public class FlatMapToDoubleExamples {

    /*
     Definition:
     flatMapToDouble() is an intermediate stream operation that transforms each element
     into a DoubleStream and then flattens those streams into a single DoubleStream.

     Method Signature:
     DoubleStream flatMapToDouble(Function<? super T, ? extends DoubleStream> mapper)

     Characteristics:
     - Intermediate operation
     - Lazy
     - One-to-many transformation to double
    */

    public static void main(String[] args) {

        // Example 1: Integer transformation
        // Flatten list of lists to DoubleStream
        List<List<Integer>> listOfLists = List.of(
            List.of(1, 2),
            List.of(3, 4)
        );

        System.out.println("Example 1: Integer transformation");
        listOfLists.stream()
                   .flatMapToDouble(list -> list.stream().mapToDouble(Integer::doubleValue))
                   .forEach(System.out::println);

        /*
        Output:
        1.0
        2.0
        3.0
        4.0
        */

        // Example 2: String transformation
        // Get lengths as double from strings
        List<String> words = List.of("hello", "world");

        System.out.println("\nExample 2: String transformation");
        words.stream()
             .flatMapToDouble(word -> java.util.stream.DoubleStream.of(word.length()))
             .forEach(System.out::println);

        /*
        Output:
        5.0
        5.0
        */

        // Example 3: Object transformation
        // Flatten salaries from employees in companies
        List<Company> companies = List.of(
            new Company("TechCorp", List.of(new Employee("John", 30, 50000), new Employee("Jane", 25, 60000))),
            new Company("BizInc", List.of(new Employee("Bob", 35, 70000)))
        );

        System.out.println("\nExample 3: Object transformation");
        companies.stream()
                 .flatMapToDouble(company -> company.getEmployees().stream().mapToDouble(Employee::getSalary))
                 .forEach(System.out::println);

        /*
        Output:
        50000.0
        60000.0
        70000.0
        */

        // Example 4: Array transformation
        // Flatten arrays to double
        List<int[]> arrays = List.of(
            new int[]{1, 2},
            new int[]{3, 4}
        );

        System.out.println("\nExample 4: Array transformation");
        arrays.stream()
              .flatMapToDouble(arr -> java.util.Arrays.stream(arr).mapToDouble(i -> (double) i))
              .forEach(System.out::println);

        /*
        Output:
        1.0
        2.0
        3.0
        4.0
        */

        // Example 5: Real-world backend example
        // Average of all salaries from companies
        System.out.println("\nExample 5: Real-world - Average of all salaries");
        double avgSalary = companies.stream()
                                    .flatMapToDouble(company -> company.getEmployees().stream().mapToDouble(Employee::getSalary))
                                    .average()
                                    .orElse(0.0);
        System.out.println("Average salary: " + avgSalary);

        /*
        Output:
        Average salary: 60000.0
        */

    }
}
