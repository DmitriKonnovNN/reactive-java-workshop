package io.javabrains.reactiveworkshop;

import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        StreamSources.intNumbersStream().forEach(System.out::println);
        // Print all numbers in the intNumbersStream stream
        // TODO: Write code here

        StreamSources.intNumbersStream().filter(i -> i < 5).forEach(System.out::println);
        // Print numbers from intNumbersStream that are less than 5
        // TODO: Write code here

        StreamSources.intNumbersStream().filter(integer -> integer>5).skip(1).limit(2).forEach(System.out::println);
        // Print the second and third numbers in intNumbersStream that's greater than 5
        // TODO: Write code here

        StreamSources.intNumbersStream().filter(integer -> integer>5)
        .findFirst()
        .ifPresentOrElse(integer -> System.out.println(integer),()-> System.out.println(-1) );
        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        // TODO: Write code here
        StreamSources.userStream().forEach(user-> System.out.println(user.getFirstName()));
        // Print first names of all users in userStream
        // TODO: Write code here

        StreamSources.userStream()
                .filter(u-> StreamSources.intNumbersStream().anyMatch(i->i==u.getId()))
                .peek(System.out::println)
                .map(u->u.getFirstName())
                .forEach(System.out::println);

        StreamSources
                .intNumbersStream()
                .flatMap(integer -> StreamSources.userStream().filter(user -> user.getId()==integer))
                .forEach(user -> System.out.println(user.getFirstName()));

        // Print first names in userStream for users that have IDs from number stream
        // TODO: Write code here

    }

}
