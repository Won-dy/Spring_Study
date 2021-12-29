package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    // 웹애플리케이션에서 /hello를 들어오면 해당 메소드를 호출해준다.
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello"; // resources:templates/의 hello를 찾아서 실행시켜라, 랜더링해라
    }

    // MVC와 템플릿 엔진
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    // API #1: 문자열 반환 - StringConverter
    @GetMapping("hello-string")
    @ResponseBody  // http에서 body부에 return 데이터를 직접 넣어주겠다
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;  // View 같은 거 없이 문자가 그냥 내려감
    }

    // API #2: 객체 반환 - JsonConverter / Jackson> 객체를 Json 형식으로 바꿔주는 라이브러리
    @GetMapping("hello-api")
    @ResponseBody  // http에서 body부에 return 데이터를 직접 넣어주겠다
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        // javabean 표준 방식 a.k.a 겟터셋터
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
