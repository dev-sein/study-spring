package com.example.intermediate.entity.file;

import com.example.intermediate.repository.file.ReviewFileDAO;
import com.example.intermediate.type.FileType;
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
public class ReviewFileTest {

    @Autowired
    ReviewFileDAO reviewFileDAO;

    @Test
    public void saveTest(){
    ReviewFile reviewFile = new ReviewFile();
    reviewFile.setName("리뷰 파일");
    reviewFile.setFileType(FileType.APPLICATION);
    reviewFile.setFilePath("filePath");
    reviewFile.setFileSize(30L);
    reviewFile.setUuid("uuid");

    reviewFileDAO.save(reviewFile);
    }

    @Test
    public void findTest(){
        reviewFileDAO.findById(1L).map(ReviewFile::toString).ifPresent(log::info);
    }

    @Test
    public void findAlltest(){
        reviewFileDAO.findAll().stream().map(ReviewFile::toString).forEach(log::info);
    }

    @Test
    public void deleteTest(){
        reviewFileDAO.findById(1L).ifPresent(reviewFileDAO::delete);
    }
}
