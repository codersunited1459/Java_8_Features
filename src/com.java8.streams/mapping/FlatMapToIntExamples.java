package com.java8.streams.mapping;

import java.util.List;

public class FlatMapToIntExamples {

    /*
     Definition:
     flatMapToInt() is an intermediate stream operation that transforms each element
     into an IntStream and then flattens those streams into a single IntStream.

     Method Signature:
     IntStream flatMapToInt(Function<? super T, ? extends IntStream> mapper)

     Characteristics:
     - Intermediate operation
     - Lazy
     - One-to-many transformation to int
    */

    public static void main(String[] args) {

        // Example 1: Integer transformation
        // Flatten list of lists of integers to IntStream
        List<List<Integer>> listOfLists = List.of(
            List.of(1, 2),
            List.of(3, 4, 5)
        );

        System.out.println("Example 1: Integer transformation");
        listOfLists.stream()
                   .flatMapToInt(list -> list.stream().mapToInt(Integer::intValue))
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
        // Get character codes from strings
        List<String> words = List.of("hi", "ok");

        System.out.println("\nExample 2: String transformation");
        words.stream()
             .flatMapToInt(String::chars)
             .forEach(System.out::println);

        /*
        Output:
        104
        105
        111
        107
        */

        // Example 3: Object transformation
        // Flatten employee ages from companies
        List<Company> companies = List.of(
            new Company("TechCorp", List.of(new Employee("John", 30, 50000), new Employee("Jane", 25, 60000))),
            new Company("BizInc", List.of(new Employee("Bob", 35, 70000)))
        );

        System.out.println("\nExample 3: Object transformation");
        companies.stream()
                 .flatMapToInt(company -> company.getEmployees().stream().mapToInt(Employee::getAge))
                 .forEach(System.out::println);

        /*
        Output:
        30
        25
        35
        */

        // Example 4: Array transformation
        // Flatten arrays of ints
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
        // Sum all employee ages from companies
        System.out.println("\nExample 5: Real-world - Sum of all ages");
        int totalAge = companies.stream()
                                .flatMapToInt(company -> company.getEmployees().stream().mapToInt(Employee::getAge))
                                .sum();
        System.out.println("Total age: " + totalAge);

        /*
        Output:
        Total age: 90
        */

    }
}
