package com.java8.streams.filtering;

/*

Stream Method: takeWhile()
1️⃣ Definition
takeWhile() is an intermediate stream operation that processes elements from the stream while a given condition is true.
As soon as the condition becomes false, the stream stops processing further elements.
This method works best with ordered streams.
________________________________________
2️⃣ Method Signature
Stream<T> takeWhile(Predicate<? super T> predicate)
Parameter
Parameter	Description
predicate	condition that must remain true
Returns
Stream containing elements while condition is true
________________________________________


 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class TakeWhile {

    public static void main(String[] args) {
        integerExample();
        stringExample();
        arrayExample();
        primitiveStreamExample();
    }

    public static void integerExample(){
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8);

        numbers.stream()
                .takeWhile(n -> n < 5)
                .forEach(System.out::println);
        //Output: 1,2,3,4
        //Stops when element 5 appears
    }

    public static void stringExample(){
        List<String> strings = List.of("apple", "avocado", "banana", "grape", "apricot");

        strings.stream()
                .takeWhile(s -> s.startsWith("a"))
                .forEach(System.out::println);
        //Output: apple, avocado
        //Stops when element "banana" appears
    }

    public static void arrayExample(){
        int[] numbers = {2,4,6,8,9,10};

        Arrays.stream(numbers)
                .takeWhile(n -> n % 2 == 0)
                .forEach(System.out::println);
        //Output: 2,4,6,8
        //Stops when element 9 appears
    }

    public static void primitiveStreamExample(){
        IntStream.range(1,20)
                .takeWhile(n -> n < 7)
                .forEach(System.out::println);
        //Output: 1,2,3,4,5,6
        //Stops when element 7 appears
    }

    /*

    8️⃣ Real Backend Example

    Processing log entries until a specific condition.

    logs.stream()
     .takeWhile(log -> !log.contains("ERROR"))
            .forEach(System.out::println);

    Explanation

    Process logs until an error occurs
     */

    /*
    Important Difference: filter() vs takeWhile()

    Example data

        1 2 3 7 4 5
            filter
            list.stream()
                .filter(n -> n < 5)

        Output : 1 2 3 4
-------------------------------------------------
        takeWhile
        list.stream()
            .takeWhile(n -> n < 5)

        Output

        1 2 3

        Explanation

        Stops when it sees 7
     */
}
