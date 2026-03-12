package com.java8.streams.mapping;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MapExamples {

    /*
     Definition:
     map() is an intermediate stream operation used to transform each element
     of the stream into another form using a function.

     Method Signature:
     <R> Stream<R> map(Function<? super T, ? extends R> mapper)

     Characteristics:
     - Intermediate operation
     - Lazy
     - One-to-one transformation
    */

    public static void main(String[] args) {

        // Example 1: Integer transformation
        // Convert numbers to their squares
        List<Integer> numbers = List.of(1, 2, 3, 4);

        System.out.println("Example 1: Integer transformation");
        numbers.stream()
               .map(n -> n * n)
               .forEach(System.out::println);

        /*
        Output:
        1
        4
        9
        16
        */

        // Example 2: String transformation
        // Convert strings to uppercase
        List<String> words = List.of("hello", "world");

        System.out.println("\nExample 2: String transformation");
        words.stream()
             .map(String::toUpperCase)
             .forEach(System.out::println);

        /*
        Output:
        HELLO
        WORLD
        */

        // Example 3: Object transformation
        // Extract names from Employee objects
        List<Employee> employees = List.of(
            new Employee("John", 30, 50000),
            new Employee("Jane", 25, 60000)
        );

        System.out.println("\nExample 3: Object transformation");
        employees.stream()
                 .map(Employee::getName)
                 .forEach(System.out::println);

        /*
        Output:
        John
        Jane
        */

        // Example 4: Array transformation
        // Calculate sum of each array
        List<int[]> arrays = List.of(
            new int[]{1, 2},
            new int[]{3, 4, 5}
        );

        System.out.println("\nExample 4: Array transformation");
        arrays.stream()
              .map(arr -> Arrays.stream(arr).sum())
              .forEach(System.out::println);

        /*
        Output:
        3
        12
        */

        // Example 5: Real-world backend example
        // Convert Employee entities to EmployeeDTOs
        System.out.println("\nExample 5: Real-world - Entity to DTO conversion");
        List<EmployeeDTO> dtos = employees.stream()
                                          .map(emp -> new EmployeeDTO(emp.getName(), emp.getSalary()))
                                          .collect(Collectors.toList());

        dtos.forEach(System.out::println);

        /*
        Output:
        EmployeeDTO{name='John', salary=50000.0}
        EmployeeDTO{name='Jane', salary=60000.0}
        */

    }
}
