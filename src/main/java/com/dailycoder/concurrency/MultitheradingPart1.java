package com.dailycoder.concurrency;

class ThreadRunner extends Thread{

    @Override
    public void run(){
        System.out.println(this.getClass().getName()+Thread.currentThread()+"is running ");
    }
}

class RunnableRunner implements Runnable{

    @Override
    public void run() {
        System.out.println(this.getClass().getName()+Thread.currentThread()+"is running ");
    }
}

public class MultitheradingPart1 {

    public static void main(String[] args) {

        ThreadRunner threadRunner = new ThreadRunner();
        ThreadRunner threadRunner1 = new ThreadRunner();

        threadRunner1.start();
        threadRunner.start();
        threadRunner.run();

        RunnableRunner runner = new RunnableRunner();
        Thread thread = new Thread(runner);

        RunnableRunner runner1 = new RunnableRunner();
        Thread thread1 = new Thread(runner1);

        thread.start();
        thread1.start();

        Runnable runnable = () -> System.out.println(Thread.currentThread()+"is running ");
        Runnable runnable1 = () -> System.out.println(Thread.currentThread()+"is running");

        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable1);

        thread2.start();
        thread3.start();


    }
}
