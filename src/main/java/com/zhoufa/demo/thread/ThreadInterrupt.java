package com.zhoufa.demo.thread;

import lombok.SneakyThrows;

/**
 * 中断线程
 */
public class ThreadInterrupt {

    @SneakyThrows
    public static void main(String[] args) {

        Thread t = new MyThread();
        t.start();
        Thread.sleep(1);
        t.interrupt();
        t.join();
        System.out.println("end");
    }

    static class MyThread extends Thread {

        @Override
        public void run() {
            int n = 0;
            while (!isInterrupted()) {
                n++;
                System.out.println(n + " hello!");
            }
        }
    }

}
