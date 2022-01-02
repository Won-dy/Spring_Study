package hello.hellospring;

import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    // 자동으로 만들어 놓은 구현체 등록
    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    /*
    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    // MemberRepository는 인터페이스라서 new 안됨
    // 구현체인 MemoryMemberRepository를 new 해야 함
    @Bean
    public MemberRepository memberRepository() {
        // 인터페이스는 그대로 두고 구현체만 변경
        // 객체 지향의 다형성
        return new JpaMemberRepository(em);  // JPA
        // return new JdbcTemplateMemberRepository(dataSource);  // JdbcTemplate
        // return new JdbcMemberRepository(dataSource);  // JDBC
        //return new MemoryMemberRepository();  // 메모리
    }
*/
}
