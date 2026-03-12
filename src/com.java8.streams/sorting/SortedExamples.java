package com.java8.streams.sorting;

import java.util.List;
import java.util.stream.Collectors;

public class SortedExamples {

    /*
     Definition:
     sorted() is an intermediate stream operation used to sort the elements
     of a stream according to their natural order.

     Method Signature:
     Stream<T> sorted()

     Characteristics:
     - Intermediate operation
     - Lazy
     - Requires elements to be Comparable
     - Performs natural sorting
     - Uses the element's compareTo() method

     When to use:
     - When you need to sort elements in their natural order
     - For Comparable objects (Integer, String, Double, etc.)
     - When you want simple ascending order without custom logic

     Natural Sorting vs Custom Sorting:
     - Natural sorting: Uses the element's natural ordering (defined by Comparable interface)
     - Custom sorting: Uses a Comparator to define custom sorting logic
     - Natural sorting is simpler but less flexible
     - Custom sorting provides more control over the sorting criteria
    */

    public static void main(String[] args) {

        // Example 1: Natural sorting of integers (ascending order)
        // Integers have natural ordering: 1 < 2 < 3 < 4 < 5
        List<Integer> numbers = List.of(5, 2, 9, 1, 3);

        System.out.println("Example 1: Natural sorting of integers");
        numbers.stream()
               .sorted()
               .forEach(System.out::println);

        /*
        Output:
        1
        2
        3
        5
        9
        */

        // Example 2: Natural sorting of strings (alphabetical order)
        // Strings have natural ordering: "apple" < "banana" < "cherry" (lexicographically)
        List<String> words = List.of("zebra", "apple", "banana", "cherry");

        System.out.println("\nExample 2: Natural sorting of strings");
        words.stream()
             .sorted()
             .forEach(System.out::println);

        /*
        Output:
        apple
        banana
        cherry
        zebra
        */

        // Example 3: Natural sorting of objects
        // Employee objects must implement Comparable for natural sorting
        List<Employee> employees = List.of(
            new Employee(3, "Charlie", 55000),
            new Employee(1, "Alice", 60000),
            new Employee(2, "Bob", 50000)
        );

        System.out.println("\nExample 3: Natural sorting of Employee objects (by ID)");
        employees.stream()
                 .sorted()
                 .forEach(System.out::println);

        /*
        Output:
        Employee{id=1, name='Alice', salary=60000.0}
        Employee{id=2, name='Bob', salary=50000.0}
        Employee{id=3, name='Charlie', salary=55000.0}
        */

        // Example 4: Array sorting using streams
        // Convert array to stream, sort, and collect back
        int[] numbers_array = {7, 2, 8, 1, 5};

        System.out.println("\nExample 4: Array sorting using streams");
        int[] sorted_array = java.util.Arrays.stream(numbers_array)
                                             .sorted()
                                             .toArray();

        java.util.Arrays.stream(sorted_array)
                        .forEach(System.out::println);

        /*
        Output:
        1
        2
        5
        7
        8
        */

        // Example 5: Primitive streams (IntStream, DoubleStream)
        // Primitive streams have their own sorted() method
        System.out.println("\nExample 5: Primitive streams sorting");
        java.util.stream.IntStream.of(4, 1, 3, 2, 5)
                                  .sorted()
                                  .forEach(System.out::println);

        /*
        Output:
        1
        2
        3
        4
        5
        */

        // Example 6: Real-world backend example
        // Sort employees and then extract their names
        System.out.println("\nExample 6: Real-world - Get sorted employee list");
        List<Employee> sortedEmployees = employees.stream()
                                                  .sorted()
                                                  .collect(Collectors.toList());

        System.out.println("Sorted Employees by ID:");
        sortedEmployees.forEach(System.out::println);

        /*
        Output:
        Sorted Employees by ID:
        Employee{id=1, name='Alice', salary=60000.0}
        Employee{id=2, name='Bob', salary=50000.0}
        Employee{id=3, name='Charlie', salary=55000.0}
        */

    }
}

