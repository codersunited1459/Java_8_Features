package com.java8.streams.filtering;

import java.util.List;

/*

Stream Method: skip()
1️⃣ Definition
skip() is an intermediate stream operation used to discard the first N elements of a stream and process the remaining elements.
It returns a new stream starting after the skipped elements.
________________________________________
2️⃣ Method Signature
Stream<T> skip(long n)
Parameters
Parameter	Description
n	Number of elements to skip
Returns
A stream containing the remaining elements after skipping n elements
________________________________________
3️⃣ Characteristics
•	Intermediate operation
•	Stateful operation
•	Lazy execution
•	Preserves encounter order
•	Often used with limit() for pagination


 */

public class SkipExample {

    public static void main(String[] args) {
        skipExample();
        skipWithStringExample();
        skipWithMapExample();
        skipWithFilterExample();
    }

    public static void skipExample() {
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);

        numbers.stream()
                .skip(5)
                .forEach(System.out::println);
        //Output: 6,7,8,9,10
    }

    public static void skipWithStringExample() {
        List<String> strings = List.of("apple", "banana", "avocado", "grape", "apricot");

        strings.stream()
                .skip(3)
                .forEach(System.out::println);
        //Output: grape, apricot
    }

    public static void skipWithMapExample() {
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);

        numbers.stream()
                .map(n -> n * n)
                .skip(5)
                .forEach(System.out::println);
        //Output: 36,49,64,81,100
    }

    public static void skipWithFilterExample() {
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);

        numbers.stream()
                .filter(n -> n % 2 == 0)
                .skip(2)
                .forEach(System.out::println);
        //Output: 6,8,10
    }
}
