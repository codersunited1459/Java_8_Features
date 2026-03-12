package com.java8.streams.mapping;

import java.util.List;

public class MapToIntExamples {

    /*
     Definition:
     mapToInt() is an intermediate stream operation that transforms each element
     of the stream into an int and returns an IntStream.

     Method Signature:
     IntStream mapToInt(ToIntFunction<? super T> mapper)

     Characteristics:
     - Intermediate operation
     - Lazy
     - One-to-one transformation to int
    */

    public static void main(String[] args) {

        // Example 1: Integer transformation
        // Convert Integer objects to primitive int (sum them)
        List<Integer> numbers = List.of(1, 2, 3, 4);

        System.out.println("Example 1: Integer transformation");
        int sum = numbers.stream()
                         .mapToInt(Integer::intValue)
                         .sum();
        System.out.println("Sum: " + sum);

        /*
        Output:
        Sum: 10
        */

        // Example 2: String transformation
        // Get lengths of strings
        List<String> words = List.of("hello", "world");

        System.out.println("\nExample 2: String transformation");
        words.stream()
             .mapToInt(String::length)
             .forEach(System.out::println);

        /*
        Output:
        5
        5
        */

        // Example 3: Object transformation
        // Extract ages from Employee objects
        List<Employee> employees = List.of(
            new Employee("John", 30, 50000),
            new Employee("Jane", 25, 60000)
        );

        System.out.println("\nExample 3: Object transformation");
        employees.stream()
                 .mapToInt(Employee::getAge)
                 .forEach(System.out::println);

        /*
        Output:
        30
        25
        */

        // Example 4: Array transformation
        // Get lengths of arrays
        List<int[]> arrays = List.of(
            new int[]{1, 2},
            new int[]{3, 4, 5}
        );

        System.out.println("\nExample 4: Array transformation");
        arrays.stream()
              .mapToInt(arr -> arr.length)
              .forEach(System.out::println);

        /*
        Output:
        2
        3
        */

        // Example 5: Real-world backend example
        // Calculate total age of employees
        System.out.println("\nExample 5: Real-world - Total age calculation");
        int totalAge = employees.stream()
                                .mapToInt(Employee::getAge)
                                .sum();
        System.out.println("Total age: " + totalAge);

        /*
        Output:
        Total age: 55
        */

    }
}
