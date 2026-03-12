package com.java8.streams.filtering;

import java.util.List;

/*

1️⃣ Stream Method: filter()
Definition
filter() is an intermediate stream operation used to
select elements from a stream that satisfy a given condition (predicate).
It returns a new stream containing only the elements that match the condition.
The method takes a Predicate functional interface as input.
________________________________________
Method Signature
Stream<T> filter(Predicate<? super T> predicate)
Parameters
•	predicate → A boolean condition used to filter elements.
Returns
•	A new filtered Stream
________________________________________
Characteristics
•	Intermediate operation
•	Lazy execution
•	Does not modify original collection
•	Works with any stream type

 */
public class FilterExample {
    public static void main(String[] args) {

        filterNumbersGreaterThan();
        filterEvenNumbers();
        filterStartingWithOne();
        filterStringStartsWithAlphabet();
        filterStringLengthGreaterThan();
        filterStringContains();
        objectFilter();
    }

    public static void filterNumbersGreaterThan() {
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);

        numbers.stream()
                .filter(n -> n > 5)
                .forEach(System.out::println);

        //Output: 6,7,8,9,10
    }

    public static void filterEvenNumbers() {
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);

        numbers.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);
        //Output: 2,4,6,8,10
    }

    public static void filterStartingWithOne() {
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);

        numbers.stream()
                .filter(n -> String.valueOf(n).startsWith("1"))
                .forEach(System.out::println);
        //Output: 1,10
    }

    public static void filterStringStartsWithAlphabet() {
        List<String> strings = List.of("apple", "banana", "avocado", "grape", "apricot");

        strings.stream()
                .filter(s -> s.startsWith("a"))
                .forEach(System.out::println);

        //Output: apple, avocado, apricot
    }

    public static void filterStringLengthGreaterThan() {
        List<String> strings = List.of("apple", "banana", "avocado", "grape", "apricot");

        strings.stream()
                .filter(s -> s.length() > 5)
                .forEach(System.out::println);
    }

    public static void filterStringContains() {
        List<String> strings = List.of("apple", "banana", "avocado", "grape", "apricot");

        strings.stream()
                .filter(s -> s.contains("a"))
                .forEach(System.out::println);

        //Output: apple, banana, avocado, grape, apricot
    }

    public static void objectFilter() {
        List<Person> people = List.of(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35),
                new Person("David", 20)
        );

        people.stream()
                .filter(p -> p.getAge() > 30)
                .forEach(p -> System.out.println(p.getName()));
        //Output: Charlie
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}