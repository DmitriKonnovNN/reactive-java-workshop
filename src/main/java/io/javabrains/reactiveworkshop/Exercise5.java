package io.javabrains.reactiveworkshop;

import java.io.IOException;

import org.reactivestreams.Subscription;

import reactor.core.publisher.BaseSubscriber;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        // TODO: Write code here

        ReactiveSources.intNumberMono().subscribe(
            n-> System.out.println(n),
            err-> System.out.println(err),
            ()->System.out.println("Completed!"));

        ReactiveSources.userMono().subscribe(
            user -> System.out.println(user.getFirstName()),
            error-> System.out.println(error.getMessage()),
            ()-> System.out.println("Completeded!")
        );

        // Subscribe to a flux using an implementation of BaseSubscriber
        // TODO: Write code here

        ReactiveSources.intNumbersFlux().subscribe(
            n-> System.out.println(n), err-> System.out.println(err), ()-> System.out.println("Completed!"));

        ReactiveSources.intNumbersFlux().subscribe(new MySubcriber<>());

        System.out.println("Press a key to end");
        System.in.read();
    }



}
class MySubcriber<T> extends BaseSubscriber<T>{
    
    public void onSubscribeHook(Subscription sbscrptn){
    System.out.println("Subsciption happened!");
    request(1);
    }

    public void onNextHook(T value) {
        System.out.println(value + "value recieved");
        request(1);
    }

}
