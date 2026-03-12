package com.java8.streams.mapping;

import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExamples {

    /*
     Definition:
     flatMap() is an intermediate stream operation that transforms each element
     into a stream and then flattens those streams into a single stream.

     Method Signature:
     <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)

     Characteristics:
     - Intermediate operation
     - Lazy
     - One-to-many transformation
    */

    public static void main(String[] args) {

        // Example 1: Integer transformation
        // Flatten list of lists of integers
        List<List<Integer>> listOfLists = List.of(
            List.of(1, 2),
            List.of(3, 4, 5)
        );

        System.out.println("Example 1: Integer transformation");
        listOfLists.stream()
                   .flatMap(List::stream)
                   .forEach(System.out::println);

        /*
        Output:
        1
        2
        3
        4
        5
        */

        // Example 2: String transformation
        // Split strings into characters
        List<String> words = List.of("hello", "world");

        System.out.println("\nExample 2: String transformation");
        words.stream()
             .flatMap(word -> word.chars().mapToObj(c -> (char) c))
             .forEach(System.out::println);

        /*
        Output:
        h
        e
        l
        l
        o
        w
        o
        r
        l
        d
        */

        // Example 3: Object transformation
        // Flatten list of companies to employees
        List<Company> companies = List.of(
            new Company("TechCorp", List.of(new Employee("John", 30, 50000), new Employee("Jane", 25, 60000))),
            new Company("BizInc", List.of(new Employee("Bob", 35, 70000)))
        );

        System.out.println("\nExample 3: Object transformation");
        companies.stream()
                 .flatMap(company -> company.getEmployees().stream())
                 .forEach(System.out::println);

        /*
        Output:
        Employee{name='John', age=30, salary=50000.0}
        Employee{name='Jane', age=25, salary=60000.0}
        Employee{name='Bob', age=35, salary=70000.0}
        */

        // Example 4: Array transformation
        // Flatten arrays into single stream
        List<int[]> arrays = List.of(
            new int[]{1, 2},
            new int[]{3, 4}
        );

        System.out.println("\nExample 4: Array transformation");
        arrays.stream()
              .flatMapToInt(java.util.Arrays::stream)
              .forEach(System.out::println);

        /*
        Output:
        1
        2
        3
        4
        */

        // Example 5: Real-world backend example
        // Get all employee names from companies
        System.out.println("\nExample 5: Real-world - All employee names");
        List<String> allNames = companies.stream()
                                         .flatMap(company -> company.getEmployees().stream())
                                         .map(Employee::getName)
                                         .collect(Collectors.toList());

        allNames.forEach(System.out::println);

        /*
        Output:
        John
        Jane
        Bob
        */

    }
}
