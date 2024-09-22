package com.capellax.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

    private final MyFirstClass myFirstClass;

    @Value("${my.custom.property}")
    private String myCustomProperty;

    @Value("${my.custom.integer}")
    private Integer myCustomInteger;

    public MyFirstService(@Qualifier("bean1") MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }

    public String tellAStory() {
        return "the dependency is saying: " + myFirstClass.sayHello();
    }

    public String getMyCustomProperty() {
        return myCustomProperty;
    }

    public Integer getMyCustomInteger() {
        return myCustomInteger;
    }

}
