package com.java8.streams.sorting;

import java.util.List;
import java.util.stream.Collectors;

public class CustomSortedExamples {

    /*
     Definition:
     sorted(Comparator<? super T> comparator) is an intermediate stream operation
     that sorts elements using a custom Comparator instead of natural ordering.

     Method Signature:
     Stream<T> sorted(Comparator<? super T> comparator)

     Characteristics:
     - Intermediate operation
     - Lazy
     - Uses provided Comparator for sorting logic
     - More flexible than natural sorting
     - Can sort in any order (ascending, descending, custom criteria)

     When to use:
     - When you need custom sorting logic
     - When you want to sort in descending order
     - When you want to sort by specific fields of objects
     - When you want multiple criteria sorting

     Natural Sorting vs Custom Sorting:
     - Natural sorting: Uses the element's natural ordering (defined by Comparable interface)
     - Custom sorting: Uses a Comparator to define custom sorting logic
     - Custom sorting is more flexible and allows complex sorting scenarios
     - Custom sorting doesn't require elements to implement Comparable
    */

    public static void main(String[] args) {

        // Example 1: Sort integers in descending order
        // Using reverse comparison to reverse the natural order
        List<Integer> numbers = List.of(5, 2, 9, 1, 3);

        System.out.println("Example 1: Sort integers in descending order");
        numbers.stream()
               .sorted((a, b) -> Integer.compare(b, a))  // b compared to a = descending
               .forEach(System.out::println);

        /*
        Output:
        9
        5
        3
        2
        1
        */

        // Example 2: Sort strings by length (short to long)
        // Comparing strings based on their length instead of alphabetical order
        List<String> words = List.of("zebra", "apple", "a", "banana");

        System.out.println("\nExample 2: Sort strings by length");
        words.stream()
             .sorted((s1, s2) -> Integer.compare(s1.length(), s2.length()))
             .forEach(System.out::println);

        /*
        Output:
        a
        apple
        zebra
        banana
        */

        // Example 3: Sort objects by salary (ascending)
        // Custom sorting by a specific field of Employee object
        List<Employee> employees = List.of(
            new Employee(1, "Charlie", 55000),
            new Employee(2, "Alice", 60000),
            new Employee(3, "Bob", 50000)
        );

        System.out.println("\nExample 3: Sort employees by salary (ascending)");
        employees.stream()
                 .sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                 .forEach(System.out::println);

        /*
        Output:
        Employee{id=3, name='Bob', salary=50000.0}
        Employee{id=1, name='Charlie', salary=55000.0}
        Employee{id=2, name='Alice', salary=60000.0}
        */

        // Example 4: Sort objects by salary (descending)
        // Reverse the comparison order to get descending sort
        System.out.println("\nExample 4: Sort employees by salary (descending)");
        employees.stream()
                 .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                 .forEach(System.out::println);

        /*
        Output:
        Employee{id=2, name='Alice', salary=60000.0}
        Employee{id=1, name='Charlie', salary=55000.0}
        Employee{id=3, name='Bob', salary=50000.0}
        */

        // Example 5: Sort objects by name (alphabetically)
        // Custom sorting by the name field using String compareTo
        System.out.println("\nExample 5: Sort employees by name (alphabetically)");
        employees.stream()
                 .sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
                 .forEach(System.out::println);

        /*
        Output:
        Employee{id=2, name='Alice', salary=60000.0}
        Employee{id=3, name='Bob', salary=50000.0}
        Employee{id=1, name='Charlie', salary=55000.0}
        */

        // Example 6: Multiple field sorting (salary then name)
        // Sort by salary first; if salaries are equal, sort by name
        List<Employee> employees_multi = List.of(
            new Employee(1, "Charlie", 55000),
            new Employee(2, "Alice", 55000),
            new Employee(3, "Bob", 50000)
        );

        System.out.println("\nExample 6: Multiple field sorting (salary first, then name)");
        employees_multi.stream()
                       .sorted((e1, e2) -> {
                           // First, compare by salary
                           int salaryComparison = Double.compare(e1.getSalary(), e2.getSalary());
                           // If salaries are equal, compare by name
                           if (salaryComparison == 0) {
                               return e1.getName().compareTo(e2.getName());
                           }
                           return salaryComparison;
                       })
                       .forEach(System.out::println);

        /*
        Output:
        Employee{id=3, name='Bob', salary=50000.0}
        Employee{id=2, name='Alice', salary=55000.0}
        Employee{id=1, name='Charlie', salary=55000.0}
        */

        // Example 7: Using Comparator.comparing() for cleaner syntax
        // Modern approach using method reference and Comparator API
        System.out.println("\nExample 7: Using Comparator.comparing() - Sort by salary");
        employees.stream()
                 .sorted(java.util.Comparator.comparingDouble(Employee::getSalary))
                 .forEach(System.out::println);

        /*
        Output:
        Employee{id=3, name='Bob', salary=50000.0}
        Employee{id=1, name='Charlie', salary=55000.0}
        Employee{id=2, name='Alice', salary=60000.0}
        */

        // Example 8: Real-world backend example
        // Get top earners sorted by salary (descending) then by name
        System.out.println("\nExample 8: Real-world - Top earners list");
        List<Employee> topEarners = employees.stream()
                                             .sorted(java.util.Comparator.comparingDouble(Employee::getSalary).reversed()
                                                                          .thenComparing(Employee::getName))
                                             .collect(Collectors.toList());

        System.out.println("Employees sorted by salary (highest first), then by name:");
        topEarners.forEach(System.out::println);

        /*
        Output:
        Employees sorted by salary (highest first), then by name:
        Employee{id=2, name='Alice', salary=60000.0}
        Employee{id=1, name='Charlie', salary=55000.0}
        Employee{id=3, name='Bob', salary=50000.0}
        */

    }
}
