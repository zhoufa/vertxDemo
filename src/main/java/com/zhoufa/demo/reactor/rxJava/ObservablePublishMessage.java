package com.zhoufa.demo.reactor.rxJava;

import io.reactivex.Observable;

/**
 * 针对流处理，一般包含以下几种方法：*Next(), *Subscribe(), *Complete(), *Error()
 *
 * Observable 类似一个数据流, 实现 Flow.publisher
 * io.reactivex.ObservableSource
 *
 * subscribe传入的参数是一个观察者（Observer =={Subscriber}）
 * 参数传入的是一个lambda表达式，进入到方法看会看到Observer实现类为： LambdaObserver
 * 除了onNext自定义，其它的onSubscribe, onComplete, onError都是默认参数
 * 函数式接口Consumer accept(T)含意： 传入consumer回调， 可以执行T这个函数动作： 可以打印，或者作排序，或者作对象属性的操作
 * 函数式接口：ObservableOnSubscribe 传入的参数是： ObservableEmitter， Observable.create(observer)，观察者实际是ObservableEmitter。 里面的方法onNext()， onComplete都是ObservableEmitter的具体实现
 * 而Observable::create的时候，返回的是一个ObservableCreate，所以ObservableEmitter的具体实现是ObservableCreate.CreateEmitter
 *
 *  LambdaObserver的onNext方法就是回调了这个T
 *
 * 下面的demo中， 产生了两个订阅，会生成两个不同的数据，由此可见这是两个不相干的流，每订阅一次， 就会收到observable发来的数据流
 *
 */
public class ObservablePublishMessage {

    public static void main(String[] args) {

        Observable<Object> observable = Observable.create(observer -> {
            observer.onNext(Math.random() * 100);
            observer.onComplete();
        });

//        .cache() 做一个缓存，适用于， 创建的数据流只需执行一次，不需要在每次订阅的时候，执行create,

        observable.subscribe(consume -> System.out.println("我处理的元素是：" +consume));

        observable.subscribe(consume -> System.out.println("我处理的元素是：" +consume));

    }
}
