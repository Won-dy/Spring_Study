package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    // 스프링 컨테이너에 있는 MemberService를 가져다 연결 시켜줌 DI; 의존관계 주입
    // @Autowired: 스프링 빈 등록
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
