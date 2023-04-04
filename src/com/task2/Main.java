package com.task2;

public class Main {
    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(50);

        Thread fizzThread = new Thread(new FizzBuzzThread(fizzBuzz, "fizz"));
        Thread buzzThread = new Thread(new FizzBuzzThread(fizzBuzz, "buzz"));
        Thread fizzbuzzThread = new Thread(new FizzBuzzThread(fizzBuzz, "fizzbuzz"));
        Thread numberThread = new Thread(new FizzBuzzThread(fizzBuzz, "number"));

        fizzThread.start();
        buzzThread.start();
        fizzbuzzThread.start();
        numberThread.start();
    }
}
