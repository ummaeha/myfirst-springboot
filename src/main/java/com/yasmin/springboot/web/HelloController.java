package com.yasmin.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // JSON 반환 컨트롤러로 만듦
public class HelloController {
    @GetMapping("/hello") // HTTP method인 GET요청을 받을 수 있는 API를 만들어줌. => /hello로 요청이 오면 문자열 hello를 반환하는 기능을 갖게됨
    public String hello() {
        return "hello";
    }
}
