package com.example.basic.repository;

import com.example.basic.domain.entity.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class MemberDAO {
    //application.yml파일에 작성된 Connection 정보를 통해 EntityManagerFactory가 생성된다.
    //EntityManagerFantory팩토리를 통해 EntityManager 객체갸
    @PersistenceContext //EntityManager를 통해서 생성된 Entity객체가 등록되는 영역
    private EntityManager entityManager; //EntityManageFactory를 통해 생성되며, Connection 객체를 통해 SQL문을 제작해준다.

    // 등록
    public Member save(Member member){
        entityManager.persist(member); //모든 entity 주소는 다르다. 동일한 key값, id를 공유하고 있는 값들은 주소값이 같다. 17번은 classtype이기 때문에 주소를 받음
        return member;
    }

    //pk로 조회
    public Optional<Member> findById(Long id) {
        //optiona은 null이 아니기 때문에 NPE를 방지할 수 있으며,
        //필드로 들어간 엔티티의 NULL검사를 편하게 할 수 있는 API이다.
        //단, Optional은 리턴타입에서만 사용하는 것을 권장한다. 
        return Optional.ofNullable(entityManager.find(Member.class, id));

    }
    
    // 삭제
    public void delete(Member member){
        entityManager.remove(member);
    }
}
