package com.zhoufa.demo.vertx;

import io.vertx.core.Vertx;

public class VertxDemo {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(MyFirstVerticle.class.getName());
    }
}
