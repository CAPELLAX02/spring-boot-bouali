package com.capellax.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Service;

@Service
@PropertySources({
        @PropertySource("classpath:custom.properties"),
        @PropertySource("classpath:custom-2.properties")
})
public class MyFirstService {

    private final MyFirstClass myFirstClass;

    @Value("${my.prop}")
    private String customPropertyFromAnotherFile;

    @Value("${my.prop-2}")
    private String customPropertyFromAnotherFile2;

    @Value("${my.custom.property}")
    private String myCustomProperty;

    @Value("${my.custom.integer}")
    private Integer myCustomInteger;

    public MyFirstService(MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }

    public String tellAStory() {
        return "the dependency is saying: " + myFirstClass.sayHello();
    }

    public String getCustomPropertyFromAnotherFile() {
        return customPropertyFromAnotherFile;
    }

    public String getCustomPropertyFromAnotherFile2() {
        return customPropertyFromAnotherFile2;
    }

    public String getMyCustomProperty() {
        return myCustomProperty;
    }

    public Integer getMyCustomInteger() {
        return myCustomInteger;
    }

}
