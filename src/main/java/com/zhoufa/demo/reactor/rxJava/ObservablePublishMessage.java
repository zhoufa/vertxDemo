package com.zhoufa.demo.reactor.rxJava;

import io.reactivex.Observable;

public class ObservablePublishMessage {

    public static void main(String[] args) {

        Observable<Object> observable = Observable.create(observer -> {
            observer.onNext(Math.random() * 100);
            observer.onComplete();
        });

        observable.subscribe(consume ->{
            System.out.println("我处理的元素是：" +consume);
        });
    }
}
