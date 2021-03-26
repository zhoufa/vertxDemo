package com.zhoufa.demo.thread;

import lombok.SneakyThrows;

public class ThreadMain {

    // New、Runnable、Blocked、Waiting、Timed Waiting和Terminated 线程的几个状态：  新建， 运行中线程， 运行中线程（阻塞）， 运行中线程（等待）， 运行中线程（计时等待）， 终止
    @SneakyThrows
    public static void main(String[] args) {
        Thread t = new Thread(() -> System.out.println("hello"));

        System.out.println("start");

        t.start();  // 线程执行
        t.join(); // 线程等待

        System.out.println("end");
    }
}
