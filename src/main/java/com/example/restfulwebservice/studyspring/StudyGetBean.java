package com.example.restfulwebservice.studyspring;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// lombok -> setter/getter 생성자 tostring , equeals 모두 자동 생성해줌.
// HellowWorldBean 모든 property에 대해서 메소드가 생
// lombok 사용 위한 옵션 켜줘야해. -> enable annotation processing

// @AllArgsConstructor 모든 argument를 갖는 생성자가 갖게 됨.
//public HelloWorldBean(String message){
//        this.message = message;
//        }
//@NoArgsConstructor
// 매개변수 없는 생성자
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudyGetBean {
    private String message;
}
