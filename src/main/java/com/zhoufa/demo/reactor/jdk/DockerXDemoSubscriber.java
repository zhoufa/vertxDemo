package com.zhoufa.demo.reactor.jdk;

import lombok.Getter;

import java.util.concurrent.Flow;

@Getter
public class DockerXDemoSubscriber<T> implements Flow.Subscriber<T> {

    private final String name;

    private Flow.Subscription subscription;

    final long bufferSize;

    long count;

    public DockerXDemoSubscriber(String name, long bufferSize) {
        this.name = name;
        this.bufferSize = bufferSize;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        (this.subscription  = subscription).request(bufferSize);
        System.out.println("开始onSubscribe订阅");

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onNext(T item) {
        System.out.println(" #####" + Thread.currentThread().getName() + "name: " + name + " item: " + item + " ####");
        System.out.println(name + " received: " + item);
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("Completed");
    }
}
