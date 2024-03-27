package com.dailycoder.concurrency;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
public class MultiThreading4 {

    private Random random = new Random();
    private List<Integer> list = new ArrayList<>();
    private List<Integer> list1 = new ArrayList<>();

    private Object lock = new Object();
    private Object lock1 = new Object();

    private  void stageOne(){

        synchronized (lock){
            try{
                Thread.sleep(1);

            }catch (InterruptedException interruptedException){

            }
            list.add(random.nextInt(100));
        }
    }

    private void stageTwo(){
        synchronized (lock1){
            try{
                Thread.sleep(1);

            }catch (InterruptedException interruptedException){

            }
            list1.add(random.nextInt(100));
        }
    }

    private void process(){

        for (int i=0;i<1000;++i){
            stageOne();
            stageTwo();
        }
    }

    @SneakyThrows
    public static void main(String[] args) {

        MultiThreading4 app = new MultiThreading4();
        log.info("starting...");
        long start = System.currentTimeMillis();
//        app.process();
        Thread thread1 = new Thread(()-> app.process());
        Thread thread2 = new Thread(()-> app.process());

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        long end = System.currentTimeMillis();

        log.info("elasped time {}",end-start);
        log.info("list1 size {} and list2 size {}",app.list.size(),app.list1.size());
    }
}
