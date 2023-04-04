package com.task1;

public class TimeReporter {
    public static void main(String[] args) {
        System.out.println("The program has started");
        displayElapsedTime();
        printElapsedTimeMessage();
    }

    public static void displayElapsedTime() {
        long startProgram = System.currentTimeMillis();

        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                    long elapsedSeconds = (System.currentTimeMillis() - startProgram) / 1000;
                    if (elapsedSeconds == 1) {
                        System.out.println(elapsedSeconds + " second have elapsed since the start of the program");
                    } else {
                        System.out.println(elapsedSeconds + " seconds have elapsed since the start of the program");
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.start();
    }

    public static void printElapsedTimeMessage() {
        Thread thread = new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(5000);
                    System.out.println("5 seconds have elapsed");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread.start();
    }
}