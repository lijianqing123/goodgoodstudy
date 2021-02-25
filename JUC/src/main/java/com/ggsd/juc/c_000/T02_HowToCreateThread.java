package com.ggsd.juc.c_000;
import java.util.concurrent.*;

public class T02_HowToCreateThread {
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello MyThread!");
        }
    }

    static class MyRun implements Runnable {
        @Override
        public void run() {
            System.out.println("Hello MyRun!");
        }
    }

    static class MyCall implements Callable{

        @Override
        public Object call() throws Exception {
            return "Hello MyCall";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new MyThread().start();
        new Thread(new MyRun()).start();
        new Thread(()->{
            System.out.println("Hello Lambda!");
        }).start();

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future future = executorService.submit(new MyCall());
        System.out.println(future.get());
    }

}

//请你告诉我启动线程的三种方式 1：Thread 2: Runnable 3:Executors.newCachedThrad
