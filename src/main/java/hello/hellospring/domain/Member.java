package hello.hellospring.domain;

import javax.persistence.*;

@Entity  // JPA가 관리하는 Entity
public class Member {

    // IDENTITY DB가 알아서 id 값 생성
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // 시스템에서 등록

    // DB의 컬럼명이 name인 것과 mapping
    //@Column(name = "name")
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
