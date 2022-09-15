package com.yasmin.springboot.web;

import com.yasmin.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) // 스프링부트 테스트와 JUnit 사이의 연결자: 테스트 진행시, JUnit 에 내장된 실행자 외에 다른 실행자(ex, SpringRunner)를 실행시킴.
@WebMvcTest(controllers = HelloController.class) // Spring MVC 에 집중할 수 있는 어노테이션
public class HelloControllerTest {
    @Autowired // 스프링이 관리하는 Bean 을 주입받음.
    private MockMvc mvc; // 웹 API 테스트시에 사용, 스프링 MVC 테스트의 시작점, 클래스를 통해 HTTP GET, POST 등에 대한 API 테스트를 할 수 있음.

    @Test
    public void return_hello() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")).andExpect(status().isOk()).andExpect(content().string(hello));
        // perform: 메소드에 맞게 요청을 하고, 체이닝을 지원함.
        // andExpect: perform 의 결과를 검증
        // andExpect > status(): Header 의 Status(ex, 200, 404, 500)를 검증.
        // andExpect > content(): 응답 본문의 내용을 검증(Controller 의 리턴값과 맞는지 검증)
    }
}
