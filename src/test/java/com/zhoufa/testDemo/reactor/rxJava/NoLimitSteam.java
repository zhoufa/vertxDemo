package com.zhoufa.testDemo.reactor.rxJava;

import io.reactivex.Observable;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigInteger;

//无限流
@Slf4j
public class NoLimitSteam {

    @Test
    public void TestNoLimitSteam() {
        Observable<Object> observable = Observable.create(observer -> {
            new Thread(() -> {
                BigInteger value = BigInteger.ZERO;
                while (true) {
                    observer.onNext(value);
                    value = value.add(BigInteger.ONE);
                }
            }).start();
        });

        observable.subscribe(System.out::println);
        observable.subscribe(System.out::println);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
