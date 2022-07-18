package io.javabrains.reactiveworkshop;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.Disposable;
import reactor.core.publisher.ConnectableFlux;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise2 {

    public static void main(String[] args) throws IOException {

        List <Integer> list = new ArrayList<>();
        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()
        ReactiveSources.intNumbersFlux().log().subscribe(new Subscriber<>() {
            @Override
            public void onSubscribe(Subscription s) {
                s.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Integer integer) {
                list.add(integer);

            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {
                System.out.println(list);
            }
        });


        // Print all numbers in the ReactiveSources.intNumbersFlux stream
        // TODO: Write code here

        ReactiveSources.userFlux().log().subscribe(user -> System.out.println(user.getFirstName()));
        // Print all users in the ReactiveSources.userFlux stream
        // TODO: Write code here

        System.out.println("Press a key to end");
        System.in.read();


        ConnectableFlux<Object> flux = ReactiveSources.fluxPrintTime();
        var d3 = flux.connect();
        Disposable d1 = flux.subscribe(e-> System.out.println("d1: "+ e));
        Disposable d2 = flux.subscribe(e-> System.out.println("d2: "+ e));


    }


}
