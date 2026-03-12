package com.java8.streams.mapping;

import java.util.List;

public class MapToLongExamples {

    /*
     Definition:
     mapToLong() is an intermediate stream operation that transforms each element
     of the stream into a long and returns a LongStream.

     Method Signature:
     LongStream mapToLong(ToLongFunction<? super T> mapper)

     Characteristics:
     - Intermediate operation
     - Lazy
     - One-to-one transformation to long
    */

    public static void main(String[] args) {

        // Example 1: Integer transformation
        // Convert integers to long
        List<Integer> numbers = List.of(1, 2, 3, 4);

        System.out.println("Example 1: Integer transformation");
        numbers.stream()
               .mapToLong(Integer::longValue)
               .forEach(System.out::println);

        /*
        Output:
        1
        2
        3
        4
        */

        // Example 2: String transformation
        // Get hash codes of strings as long
        List<String> words = List.of("hello", "world");

        System.out.println("\nExample 2: String transformation");
        words.stream()
             .mapToLong(String::hashCode)
             .forEach(System.out::println);

        /*
        Output:
        99162322
        113318802
        */

        // Example 3: Object transformation
        // Convert age to long (though age is int, for demonstration)
        List<Employee> employees = List.of(
            new Employee("John", 30, 50000),
            new Employee("Jane", 25, 60000)
        );

        System.out.println("\nExample 3: Object transformation");
        employees.stream()
                 .mapToLong(emp -> (long) emp.getAge())
                 .forEach(System.out::println);

        /*
        Output:
        30
        25
        */

        // Example 4: Array transformation
        // Get sum of arrays as long
        List<int[]> arrays = List.of(
            new int[]{1, 2},
            new int[]{3, 4, 5}
        );

        System.out.println("\nExample 4: Array transformation");
        arrays.stream()
              .mapToLong(arr -> java.util.Arrays.stream(arr).sum())
              .forEach(System.out::println);

        /*
        Output:
        3
        12
        */

        // Example 5: Real-world backend example
        // Calculate total salary as long (rounded)
        System.out.println("\nExample 5: Real-world - Total salary calculation");
        long totalSalary = employees.stream()
                                    .mapToLong(emp -> (long) emp.getSalary())
                                    .sum();
        System.out.println("Total salary: " + totalSalary);

        /*
        Output:
        Total salary: 110000
        */

    }
}
