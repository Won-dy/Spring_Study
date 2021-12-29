package hello.hellospring.domain;

public class Member {

    private Long id;  // 시스템에서 등록
    private String name;  // 회원이 직접 등록

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
