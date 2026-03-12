package com.java8.streams.filtering;
/*
Stream Method: dropWhile()
1️⃣ Definition
dropWhile() is an intermediate stream operation that discards elements from the beginning of the stream while a given condition is true.
Once the condition becomes false, it returns all remaining elements of the stream.
It works best with ordered streams.
________________________________________
2️⃣ Method Signature
Stream<T> dropWhile(Predicate<? super T> predicate)
Parameter
Parameter	Description
predicate	condition used to drop elements
Returns
A stream containing the remaining elements after dropping matching elements
________________________________________

 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class DropWhile {
    public static void main(String[] args) {

        integerExample();
        stringExample();
        arrayExample();
        primitiveStreamExample();
    }

    public static void integerExample(){
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8);

        numbers.stream()
                .dropWhile(n -> n < 5)
                .forEach(System.out::println);
        //Output: 5,6,7,8
        //Drops elements 1-4 and starts output from element 5
    }

    public static void stringExample(){
        List<String> strings = List.of("apple", "avocado", "banana", "grape", "apricot");

        strings.stream()
                .dropWhile(s -> s.startsWith("a"))
                .forEach(System.out::println);
        //Output: banana, grape, apricot
        //Drops elements "apple" and "avocado" and starts output from element "banana"
    }

    public static void arrayExample(){
        int[] numbers = {2,4,6,8,9,10};

        Arrays.stream(numbers)
                .dropWhile(n -> n % 2 == 0)
                .forEach(System.out::println);
        //Output: 9,10
        //Drops elements 2,4,6,8 and starts output from element 9
    }

    public static void primitiveStreamExample(){
        IntStream.range(1,10)
                .dropWhile(n -> n < 6)
                .forEach(System.out::println);
        //Output: 6,7,8,9
        //Drops elements 1-5 and starts output from element 6
    }

    /*

    Real Backend Example

        Example: skip logs until a specific event appears.

        logs.stream()
            .dropWhile(log -> !log.contains("START"))
            .forEach(System.out::println);

        Explanation

        Ignore logs until START event
        Then process remaining logs

     -------------------------------------------------------------------
      Difference Between takeWhile() and dropWhile()

        Example list

        1 2 3 4 5 6 7
        takeWhile(n < 5)
        1 2 3 4

        Stops when condition becomes false.

        dropWhile(n < 5)
        5 6 7

        Drops elements until condition becomes false.

         Visual Understanding

        Stream

        1 2 3 4 5 6 7

        Condition

        n < 5
        Method	Result
        takeWhile	1 2 3 4
        dropWhile	5 6 7

     */

}
