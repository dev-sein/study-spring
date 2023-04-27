//package com.example.intermediate.entity.file;
//
//import com.example.intermediate.repository.file.ReviewFileRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//
//import javax.transaction.Transactional;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.UUID;
//
//@SpringBootTest
//@Transactional
//@Rollback(false)
//@Slf4j
//public class ReviewFileRepositoryTests {
//    @Autowired
//    public ReviewFileRepository reviewFileRepository;
//
//    @Test
//    public void saveTest(){
//        ReviewFile reviewFile1 = ReviewFile.builder()
//                .name("파일이름1")
//                .uuid(UUID.randomUUID().toString())
//                .filePath("2023/04/24")
//                .fileSize(3024L)
//                .build();
//
//        ReviewFile reviewFile2 = ReviewFile.builder()
//                .name("파일이름2")
//                .uuid(UUID.randomUUID().toString())
//                .filePath("2023/04/23")
//                .fileSize(3024L)
//                .build();
//
//        ReviewFile reviewFile3 = ReviewFile.builder()
//                .name("파일이름3")
//                .uuid(UUID.randomUUID().toString())
//                .filePath("2023/04/25")
//                .fileSize(3024L)
//                .build();
//
//        reviewFileRepository.saveAll(new ArrayList(Arrays.asList(reviewFile1, reviewFile2, reviewFile3)));
//
//    }
//}
