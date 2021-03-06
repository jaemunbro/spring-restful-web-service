package com.example.restfulwebservice.studyspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class StudySpringController {

    //자동주입
    @Autowired
    private MessageSource messageSource;

    // GET
    //    /hello-world (endpoint)
    // @Requestmapping() 도 썼었다. 지금은 GetMapping으로 대체.
    // @Requestmapping(method=RequestMethod.GET, path="/hello-world")
    @GetMapping(path = "/get")
    public String studyGet() {
        return "test string";
    }

    // alt + enter
    //RestController 특징
    // string값이 아니라 java bean 형태로 반환하면 스프링에서 json으로 반환한다.
    // response body에 반환하면 list든 뭐든 저절로 json으로 반환한다.
    @GetMapping(path = "/get-bean")
    public StudyGetBean studyGetBean() {
        return new StudyGetBean("test get bean");
    }

    // 지정되어 있는 변수값과 동일하게 지정하고, 가변데이터 @PathVariable로 준다.
    @GetMapping(path = "/get-bean/path-variable/{name}")
    public StudyGetBean studyGetBean(@PathVariable String name) {
        return new StudyGetBean(String.format("test get bean, %s", name));
    }

    @GetMapping(path = "/get-internationalized")
    public String helloWorldInternationalized(
            @RequestHeader(name="Accept-Language", required=false) Locale locale) {
        return messageSource.getMessage("greeting.message", null, locale);
    }
}
