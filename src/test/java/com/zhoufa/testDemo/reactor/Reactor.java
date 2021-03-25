package com.zhoufa.testDemo.reactor;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

public class Reactor {

    @Test
    public void testFlux() {
//        Flux<Integer> range = Flux.range(1, 4);
//        range.subscribe(System.out::println, error -> System.err.println("Error" + error), () -> System.out.println("Done"), subscription -> subscription.request(3));

        Flux<String> flux = Flux.generate(
                () -> 0,
                (state, sink) -> {
                    sink.next("3 x " + state + " = " + 3 * state);
                    if (state == 10) sink.complete();
                    return state + 1;
                });
        flux.subscribe(System.out::println);
    }


    @Test
    public void testPublishOn() throws InterruptedException {
        Scheduler s = Schedulers.newParallel("parallel-scheduler", 4);
        final Flux<String> flux = Flux
                .range(1, 4)
                .map(i -> 10 + i + ":aaaaa" + Thread.currentThread())
                .publishOn(s)
                .map(i -> "value " + i+":bbbb"+ Thread.currentThread());

        new Thread(() -> flux.subscribe(System.out::println),"ThreadA").start();
        System.out.println(Thread.currentThread());
        Thread.sleep(5000);
    }

    @Test
    public void testSubscribeOn() throws InterruptedException {
        Scheduler s = Schedulers.newParallel("parallel-scheduler", 4);
        final Flux<String> flux = Flux
                .range(1, 2)
                .map(i -> 10 + i + ":" + Thread.currentThread())
                .subscribeOn(s)
                .map(i -> "value " + i+":"+ Thread.currentThread());

        new Thread(() -> flux.subscribe(System.out::println),"ThreadA").start();
        Thread.sleep(5000);
    }

}
