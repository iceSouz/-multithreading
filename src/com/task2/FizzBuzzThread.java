package com.task2;

public class FizzBuzzThread implements Runnable {
    private final FizzBuzz fizzBuzz;
    private final String methodName;

    public FizzBuzzThread(FizzBuzz fizzBuzz, String methodName) {
        this.fizzBuzz = fizzBuzz;
        this.methodName = methodName;
    }

    @Override
    public void run() {
        switch (methodName) {
            case "fizz":
                fizzBuzz.fizz();
                break;
            case "buzz":
                fizzBuzz.buzz();
                break;
            case "fizzbuzz":
                fizzBuzz.fizzbuzz();
                break;
            case "number":
                fizzBuzz.number();
                break;
            default:
                throw new IllegalArgumentException("Invalid method name");
        }
    }
}
