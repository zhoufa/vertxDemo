package com.zhoufa.demo.thread;


// main线程通过调用t.interrupt()从而通知t线程中断，而此时t线程正位于hello.join（）的等待中，此方法会立刻结束等待并抛出InterruptedException。
// 由于我们在t线程中捕获了InterruptedException，因此就可以准备结束该线程，在t线程结束前，对hello线程也进行了interrupt()调用通知其中断，
//可以发现hello线程仍然会继续进行，且JVM不会退出
public class ThreadSecInterrupt {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThread();
        t.start();
        Thread.sleep(3000);
//        t.interrupt();
        t.join();
        System.out.println("end");
    }

    static class MyThread extends Thread {

        @Override
        public void run() {
            Thread hello = new HelloThread();
            hello.start();
            try {
                hello.join();
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }
            hello.interrupt();
        }
    }

    static class HelloThread extends Thread {

        @Override
        public void run() {
            int n = 0;
            while (!isInterrupted()) {
                n++;
                System.out.println(n + " hello !");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }

}
