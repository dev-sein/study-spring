package com.example.advanced.entity.member;

import com.example.advanced.repository.member.MemberDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
@Rollback(false)
@Slf4j
public class MemberDaoTests {
    @Autowired
    private MemberDAO memberDAO;

    @Test
    private void saveTest(){
        for(int i=0; i<10; i++){
            File file = new File();
            Member member = new Member();
            MemberAddress memberAddress = new MemberAddress();

            file.setFileName("name"+(i+1));
            file.setFilePath("filePath"+(i+1));
            file.setFileSize(i+1L);
            file.setFileUuid("fileuuid"+(i+1));

            member.setMemberId((i+1)+"memberIdentification");
            member.setMemberEmail((i+1)+"email");
            member.setMemberPassword("1234");

            memberAddress.setMemberAddress("address"+(i+1));
            memberAddress.setMemberAddressDetail("detail"+(i+1));
            memberAddress.setMemberPostcode("post"+(i+1));

        }
    }

}
