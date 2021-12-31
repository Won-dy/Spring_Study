package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    // MemberRepository는 인터페이스라서 new 안됨
    // 구현체인 MemoryMemberRepository를 new 해야 함
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
