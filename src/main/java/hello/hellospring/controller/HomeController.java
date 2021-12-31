package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")  // localhost:8080 하면 바로 뜸
    public String home() {
        return "home";  // resources:templates/의 home을 찾아서 실행시켜라, 랜더링해라
    }
}
