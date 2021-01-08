package com.example.restfulwebservice.studyspring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudySpringController {
    // GET
    //    /hello-world (endpoint)
    // @Requestmapping() 도 썼었다. 지금은 GetMapping으로 대체.
    // @Requestmapping(method=RequestMethod.GET, path="/hello-world")
    @GetMapping(path = "/get-test")
    public String studyGet() {
        return "test string";
    }

    // alt + enter
    //RestController 특징
    // string값이 아니라 java bean 형태로 반환하면 스프링에서 json으로 반환한다.
    // response body에 반환하면 list든 뭐든 저절로 json으로 반환한다.
    @GetMapping(path = "/test-get-bean")
    public StudyGetBean studyGetBean() {
        return new StudyGetBean("test get bean");
    }

    // 지정되어 있는 변수값과 동일하게 지정하고, 가변데이터 @PathVariable로 준다.
    @GetMapping(path = "/test-get-bean/path-variable/{name}")
    public StudyGetBean studyGetBean(@PathVariable String name) {
        return new StudyGetBean(String.format("test get bean, %s", name));
    }
}
