package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * 테스트는 순서랑 상관없이 모든 메소드들이 따로 동작하도록 설계해야 함
 * 테스트 하나 끝날 때 마다 저장소나 공용 데이터를 클리어 해줘야 함 (AfterEach)
 * TDD;Test Driven Development 테스트 주도 개발 : 테스트를 먼저만들고 구현 클래스를 만들어 돌려보는 것
 */
class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    // afterEach: 테스트 메소드 실행 끝날 때 마다 동작되는 콜백 메소드
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        // Optional은 get으로 값을 꺼냄
        Member result = repository.findById(member.getId()).get();
        // System.out.println("result = " + (result==member));
        // Assertions.assertEquals(member, result);  // Junit 꺼
        assertThat(member).isEqualTo(result);  // assertj 꺼
        // 기대값, 실제값
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        // shift+F6하면 객체 rename 가능
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        // Optional<Member> result = repository.findByName("spring1");
        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);

        // spring1 , 2
        // System.out.println("res = " + member1.getName() + " , " + member2.getId());
    }
}
