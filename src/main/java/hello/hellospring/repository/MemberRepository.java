package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);  // 회원이 저장소에 저장
    // Optional null 값일 때 null을 Optional로 감싸서 처리
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();  // 저장된 모든 회원 리스트 반환
}
