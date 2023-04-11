package com.example.basic.repository;

import com.example.basic.domain.entity.Member;
import com.example.basic.type.MemberType;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
@Transactional // 필드 안에 있는 모든 메소드에 트랜잭션이 각각 생긴다.
@Rollback(false)
public class MemberDaoTests {
    @Autowired
    private MemberDAO memberDAO;

    @Test
    public void saveTest(){
        Member member = new Member();
        member.setMemberName("한동석");
        member.setMemberEmail("tedhan1204@gmail.com");
        member.setMemberPassword("1234");
        member.setMemberType(MemberType.MEMBER);
        member.setMemberAge(20);

        memberDAO.save(member);
    }

    @Test
    public void setMemberAgeTest(){
        Member member = new Member();
        member.setMemberName("한동석");
        member.setMemberEmail("tedhan1204@gmail.com");
        member.setMemberPassword("1234");
        member.setMemberType(MemberType.MEMBER);
        member.setMemberAge(20);

        memberDAO.save(member);
        member.setMemberAge(99);
    }

    @Test
    public void deleteTest(){
        Member member = new Member();
        member.setMemberName("한동석");
        member.setMemberEmail("tedhan1204@gmail.com");
        member.setMemberPassword("1234");
        member.setMemberType(MemberType.MEMBER);
        member.setMemberAge(20);

        memberDAO.save(member);
        memberDAO.delete(member);
    }

    @Test
    public void findByIdTest(){
        Optional<Member> optionalMember = memberDAO.findById(10L);
//        Member member = optionalMember.orElse(new Member());
//        Member member = optionalMember.orElseGet(Member::new);

//        if(optionalMember.isPresent()){
//            optionalMember.get();
//        }

//        optionalMember.ifPresent(member -> assertThat(member.getMemberName()).isEqualTo("한동석"));
    }
}





















