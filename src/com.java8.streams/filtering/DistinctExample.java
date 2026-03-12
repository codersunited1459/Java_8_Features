package com.java8.streams.filtering;

import java.util.List;
import java.util.Map;

/*
1️⃣ Definition
distinct() is an intermediate stream operation used to remove duplicate elements from a stream.
It returns a new stream containing only unique elements.
Internally, it uses the equals() and hashCode() methods to determine whether two elements are duplicates.
________________________________________
2️⃣ Method Signature
Stream<T> distinct()
Returns
A stream with duplicate elements removed.
________________________________________
3️⃣ Characteristics
•	Intermediate operation
•	Stateless operation
•	Lazy execution
•	Preserves encounter order (for ordered streams)
•	Uses equals() and hashCode()

Important Note
--------------

For objects to work properly with distinct(), you must override:

equals()
hashCode()

Otherwise Java treats every object as different.

*/

public class DistinctExample {
    public static void main(String[] args) {

        distinctIntegers();
        distinctStrings();
        distinctCustomObjects();
        distinctArrays();
        distinctWithMap();
        distinctWithFilter();
        distinctWithmap();
    }

    public static void distinctIntegers() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10);

        numbers.stream()
                .distinct()
                .forEach(System.out::println);
        //Output: 1,2,3,4,5,6,7,8,9,10
    }

    public static void distinctStrings() {
        List<String> strings = List.of("apple", "banana", "avocado", "grape", "apricot", "apple");

        strings.stream()
                .distinct()
                .forEach(System.out::println);

        //Output: apple, banana, avocado, grape, apricot
    }

    public static void distinctCustomObjects() {
        List<Employee> people = List.of(
                new Employee("Alice", 30),
                new Employee("Bob", 25),
                new Employee("Alice", 30),
                new Employee("Charlie", 35)
        );

        people.stream()
                .distinct()
                .forEach(System.out::println);

        //Output: Alice (30), Bob (25), Charlie (35)
    }

    public static void distinctArrays() {
        List<int[]> arrays = List.of(
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{1, 2, 3},
                new int[]{7, 8, 9}
        );

        arrays.stream()
                .distinct()
                .forEach(arr -> System.out.println(java.util.Arrays.toString(arr)));

        //Output: [1, 2, 3], [4, 5, 6], [7, 8, 9]
    }

    public static void distinctWithMap() {
        Map<Integer, String> map = Map.of(
                1, "Ravi",
                2, "Arjun",
                3, "Ravi"
        );

        map.values()
                .stream()
                .distinct()
                .forEach(System.out::println);
        //Output: Ravi, Arjun
    }


    public static void distinctWithFilter() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10);

        numbers.stream()
                .filter(n -> n % 2 == 0) // Filter even numbers
                .distinct() // Remove duplicates
                .forEach(System.out::println);
        //Output: 2,4,6,8,10


    }

    public static void distinctWithmap() {
        List<String> strings = List.of("apple", "banana", "avocado", "grape", "apricot", "apple");

        strings.stream()
                .map(String::toUpperCase) // Convert to uppercase
                .distinct() // Remove duplicates
                .forEach(System.out::println);

        //Output: APPLE, BANANA, AVOCADO, GRAPE, APRICOT
    }
}
class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (age != employee.age) return false;
        return name != null ? name.equals(employee.name) : employee.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}
