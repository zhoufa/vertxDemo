package com.zhoufa.demo.reactor.consumer;

import io.reactivex.functions.Consumer;
import lombok.SneakyThrows;

public class App {

    @SneakyThrows
    public static void main(String[] args) {
        Consumer<String> consumer = System.out::println;
        consumer.accept("有参数无返回");

        invokeCook(() -> System.out.println("做饭"));

    }

    public interface Cook{
        void makeFood();
    }

    static void invokeCook(Cook cook) {
        cook.makeFood();
    }
}
