package com.capellax.example;

public class MyFirstClass {

    private final String myVar;

    public MyFirstClass(String myVar) {
        this.myVar = myVar;
    }

    public String sayHello() {
        return "Hello from the first class ==> myVar = " + myVar;
    }

}
