package com.zhoufa.demo.vertx;

import io.vertx.core.AbstractVerticle;

public class MyFirstVerticle extends AbstractVerticle {

    @Override
    public void start() {
        vertx.createHttpServer().requestHandler(req ->{
            req.response().putHeader("content-type", "text/plain").end("Hello world!!");
        }).listen(8878);
    }
}
