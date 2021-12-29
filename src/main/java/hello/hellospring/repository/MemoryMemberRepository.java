package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

/**
 * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
 */
public class MemoryMemberRepository implements MemberRepository {

    // Key: ID, Value: ID+Name
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);  // ID 셋팅
        store.put(member.getId(), member);  // store Map에 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        // null이 반환 될 가능성이 있으면 Optional로 감쌈
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        // loop를 돌면서 Map에서 name 찾으면 optional로 반환 없으면 optional에 null이 포함돼서 반환
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());  // Map의 Member들을 반환
    }

    public void clearStore() {
        store.clear();
    }
}
