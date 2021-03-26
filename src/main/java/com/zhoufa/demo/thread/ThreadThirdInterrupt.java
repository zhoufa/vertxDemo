package com.zhoufa.demo.thread;

public class ThreadThirdInterrupt {

    public static void main(String[] args) throws InterruptedException {
        HelloThread t = new HelloThread();
        t.start();
        Thread.sleep(100);
        t.running = false;
    }

    static class HelloThread extends Thread {

        volatile boolean running = true;
        @Override
        public void run() {
            int n = 0;
            while (running && n < 500) {
                n++;
                System.out.println(n + " hello!");
            }
            System.out.println("end");
        }
    }

}
