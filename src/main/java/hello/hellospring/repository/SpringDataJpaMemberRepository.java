package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    // JpaRepository 상속 > 구현체 자동 생성, SpringBean에 자동 등록
    @Override
    Optional<Member> findByName(String name);
    // findBy((Name)) 명명 규칙 > JPQL > select m from Member m where m.name = ?
}
