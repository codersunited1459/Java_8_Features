package com.java8.streams.mapping;

import java.util.List;

public class MapToDoubleExamples {

    /*
     Definition:
     mapToDouble() is an intermediate stream operation that transforms each element
     of the stream into a double and returns a DoubleStream.

     Method Signature:
     DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper)

     Characteristics:
     - Intermediate operation
     - Lazy
     - One-to-one transformation to double
    */

    public static void main(String[] args) {

        // Example 1: Integer transformation
        // Convert integers to double
        List<Integer> numbers = List.of(1, 2, 3, 4);

        System.out.println("Example 1: Integer transformation");
        numbers.stream()
               .mapToDouble(Integer::doubleValue)
               .forEach(System.out::println);

        /*
        Output:
        1.0
        2.0
        3.0
        4.0
        */

        // Example 2: String transformation
        // Get lengths as double
        List<String> words = List.of("hello", "world");

        System.out.println("\nExample 2: String transformation");
        words.stream()
             .mapToDouble(String::length)
             .forEach(System.out::println);

        /*
        Output:
        5.0
        5.0
        */

        // Example 3: Object transformation
        // Extract salaries from Employee objects
        List<Employee> employees = List.of(
            new Employee("John", 30, 50000),
            new Employee("Jane", 25, 60000)
        );

        System.out.println("\nExample 3: Object transformation");
        employees.stream()
                 .mapToDouble(Employee::getSalary)
                 .forEach(System.out::println);

        /*
        Output:
        50000.0
        60000.0
        */

        // Example 4: Array transformation
        // Get average of arrays as double
        List<int[]> arrays = List.of(
            new int[]{1, 2},
            new int[]{3, 4, 5}
        );

        System.out.println("\nExample 4: Array transformation");
        arrays.stream()
              .mapToDouble(arr -> java.util.Arrays.stream(arr).average().orElse(0.0))
              .forEach(System.out::println);

        /*
        Output:
        1.5
        4.0
        */

        // Example 5: Real-world backend example
        // Calculate average salary
        System.out.println("\nExample 5: Real-world - Average salary calculation");
        double avgSalary = employees.stream()
                                    .mapToDouble(Employee::getSalary)
                                    .average()
                                    .orElse(0.0);
        System.out.println("Average salary: " + avgSalary);

        /*
        Output:
        Average salary: 55000.0
        */

    }
}
