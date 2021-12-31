package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    // #1. DI 생성자 주입 > 셋팅 시 생성자에 한 번 주입되고 변경 못되도록 막아버려서 좋음
   private final MemberService memberService;

    // 스프링 컨테이너에 있는 MemberService를 가져다 연결 시켜줌 DI; 의존관계 주입
    // @Autowired: 스프링 빈 등록
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 데이터 조회할 때 GET
    @GetMapping("/members/new")
    public String createForm() {
        // 아무 일 안하고 members/createMemberForm로 이동
        return "members/createMemberForm";
    }

    // 데이터 등록할 때 POST
    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        // System.out.println("member = " + member.getName() + " " + member.getId());

        memberService.join(member);

        return "redirect:/";  // 회원가입 끝나면 홈 화면으로 보냄
    }

}

    // #2. DI 필드 주입 > 별로 안좋음
    // @Autowired private MemberService memberService;

    // #3. DI 셋터 주입 > 한 번 셋팅하면 중간에 바꿀 일 없는데 public으로 노출
    /* private MemberService memberService;

    @Autowired
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }
    */