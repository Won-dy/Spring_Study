package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memeberRepository;

    // memeberRepository를 외부에서 넣어 줌
    // DI; Dependency Injection; 의존성 주입
    public MemberService(MemberRepository memeberRepository) {
        this.memeberRepository = memeberRepository;
    }

    /**
     * 회원 가입
     * 중복회원 검증 후 > 회원 저장, ID 반환
     */
    public Long join(Member member) {
        // Ctrl+Alt+V : "리턴타입 변수 = " 만들어줌

        // 같은 이름이 있는 중복 회원 검증
        validateDuplicateMember(member);

        // #2 - 직접 꺼내서 비교
        //Optional<Member> result = memeberRepository.findByName(member.getName());
        //Member member1 = result.get();

        memeberRepository.save(member);
        return member.getId();
    }

    // #1 - ifPresent(Optional의 메소드): null이 아닌 값이 있으면 로직 동작
    private void validateDuplicateMember(Member member) {
        // 로직이 있는 경우 메소드로 따로 뽑는 것이 좋다
        memeberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memeberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memeberRepository.findById(memberId);
    }

}
