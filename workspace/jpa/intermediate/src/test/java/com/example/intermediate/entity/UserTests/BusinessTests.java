package com.example.intermediate.entity.UserTests;

import com.example.intermediate.entity.member.Member;
import com.example.intermediate.repository.user.MemberDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class BusinessTests {
    @Autowired
    private MemberDAO memberDAO;


}
