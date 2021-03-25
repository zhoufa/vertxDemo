package com.zhoufa.demo.reactor.jdk;

import lombok.SneakyThrows;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.SubmissionPublisher;
import java.util.stream.LongStream;

public class ConsumeSubmissionPublisher {

    public static void main(String[] args) {
        System.out.println("--------------");
        publish();
    }

    @SneakyThrows
    public static void publish() {
        CompletableFuture<?> future = null;
        try (SubmissionPublisher<Long> publisher = new SubmissionPublisher<>()){
            System.out.println("Subscriber Buffer Size: " + publisher.getMaxBufferCapacity());
            future = publisher.consume(System.out::println);
            LongStream.range(1, 10).forEach(publisher::submit);
        }finally {
            Objects.requireNonNull(future).get();
        }

    }
}
