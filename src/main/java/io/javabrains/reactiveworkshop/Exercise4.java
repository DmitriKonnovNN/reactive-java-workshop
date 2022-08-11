package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        // TODO: Write code here

        ReactiveSources.intNumberMono().log().subscribe(
            e-> System.out.println(e), 
            err-> System.out.println(err.getMessage()),
            ()-> System.out.println("On complete!")
        );

        // Get the value from the Mono into an integer variable
        // TODO: Write code here

        var integer = ReactiveSources.intNumberMono().block();
        var integerOptional = ReactiveSources.intNumberMono().blockOptional();

        var userMono = ReactiveSources.userMono().blockOptional();
        System.out.println(integer);
        System.out.println(integerOptional);
    }

}
