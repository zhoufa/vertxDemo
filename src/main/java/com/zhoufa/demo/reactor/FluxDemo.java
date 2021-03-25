package com.zhoufa.demo.reactor;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.locks.LockSupport;

public class FluxDemo {

    public static void main(String[] args) {
        Flux.generate(() -> 0, (state, sink) -> {
            System.out.println("1231231");
            sink.next("str" + state);
            LockSupport.parkNanos(Duration.ofSeconds(1).toNanos());
            if (state++ == 10) {
                sink.complete();
            }
            return state;
        }, System.out::println);
    }
}
