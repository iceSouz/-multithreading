package com.task2;

public class FizzBuzz {
    private final int n;
    private int currentNumber;
    private final Object lock;

    public FizzBuzz(int n) {
        this.n = n;
        this.currentNumber = 1;
        this.lock = new Object();
    }

    public void fizz() {
        while (currentNumber <= n) {
            synchronized (lock) {
                if (currentNumber % 3 == 0 && currentNumber % 5 != 0) {
                    System.out.println("fizz");
                    currentNumber++;
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public void buzz() {
        while (currentNumber <= n) {
            synchronized (lock) {
                if (currentNumber % 5 == 0 && currentNumber % 3 != 0) {
                    System.out.println("buzz");
                    currentNumber++;
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public void fizzbuzz() {
        while (currentNumber <= n) {
            synchronized (lock) {
                if (currentNumber % 3 == 0 && currentNumber % 5 == 0) {
                    System.out.println("fizzbuzz");
                    currentNumber++;
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public void number() {
        while (currentNumber <= n) {
            synchronized (lock) {
                if (currentNumber % 3 != 0 && currentNumber % 5 != 0) {
                    System.out.println(currentNumber);
                    currentNumber++;
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
