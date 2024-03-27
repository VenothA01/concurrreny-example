package com.dailycoder.concurrency;

import java.util.Scanner;

class Processor extends Thread{

    private volatile boolean running = true;

    @Override
    public void run() {
        while (running){
            System.out.println("Hello ");
            try{
                Thread.sleep(100);
            }
            catch (InterruptedException interruptedException){
                interruptedException.printStackTrace();
            }
        }
    }


    public void shutDown(){
        this.running = false;
    }
}

public class MultiThreadingPart2 {

    public static void main(String[] args) {
        Processor processor = new Processor();
        processor.start();
        System.out.println("Enter return to stop");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        processor.shutDown();
    }
}
