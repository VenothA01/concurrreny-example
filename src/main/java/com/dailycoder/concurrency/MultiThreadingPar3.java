package com.dailycoder.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class MultiThreadingPar3 {

    private int count = 0;

    public synchronized void increment(){
        count++;
    }

    public static void main(String[] args) throws InterruptedException {

        MultiThreadingPar3 app = new MultiThreadingPar3();
        app.doWork();

    }

    public void doWork() throws InterruptedException{

        Thread t1 = new Thread(()->{
            for (int i=0;i<1000;++i){
                increment();
            }
        });

        Thread t2 = new Thread(()->{
            for (int i=0;i<1000;++i){
                increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("count::"+count);
    }
}
