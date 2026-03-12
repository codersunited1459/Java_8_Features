package com.java8.streams.filtering;

import java.util.List;

/*

1️⃣ Definition
limit() is an intermediate stream operation used to restrict the number of elements in a stream to a specified maximum size.
It returns a new stream containing only the first N elements.
This operation is short-circuiting, meaning it stops processing once the limit is reached.
________________________________________
2️⃣ Method Signature
Stream<T> limit(long maxSize)
Parameters
Parameter	Description
maxSize	Maximum number of elements to include in the stream
Returns
A stream containing at most maxSize elements
________________________________________
3️⃣ Characteristics
•	Intermediate operation
•	Short-circuiting operation
•	Lazy execution
•	Preserves encounter order
•	Very useful for pagination and sampling


 */

public class LimitExamples {
    public static void main(String[] args) {
        limitExample();
        limitWithStringExample();
        limitWithMapExample();
        limitWithFilterExample();
    }

    public static void limitExample() {
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);

        numbers.stream()
                .limit(5)
                .forEach(System.out::println);
        //Output: 1,2,3,4,5
    }

    public static void limitWithStringExample() {
        List<String> strings = List.of("apple", "banana", "avocado", "grape", "apricot");

        strings.stream()
                .limit(3)
                .forEach(System.out::println);
        //Output: apple, banana, avocado
    }

    public static void limitWithMapExample() {
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);

        numbers.stream()
                .map(n -> n * n)
                .limit(5)
                .forEach(System.out::println);
        //Output: 1,4,9,16,25
    }

    public static void limitWithFilterExample() {
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);

        numbers.stream()
                .filter(n -> n % 2 == 0)
                .limit(3)
                .forEach(System.out::println);
        //Output: 2,4,6
    }


}
