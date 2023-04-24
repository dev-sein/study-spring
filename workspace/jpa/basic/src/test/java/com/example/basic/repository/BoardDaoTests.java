package com.example.basic.repository;

import com.example.basic.domain.entity.Board;
import com.example.basic.type.Category;
import com.example.basic.type.SuperCarType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class BoardDaoTests {

    @Autowired
    BoardDAO boardDAO;

    @Test
    public void saveTest() {
        Category[] categories = {Category.PHOTO, Category.TEXT, Category.VIDEO};
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            Board board = new Board();
            board.setTitle("title" + (i + 1));
            board.setWriter("user" + (i + 1));
            board.setContent("" + i);
            board.setCate(categories[random.nextInt(categories.length)]);
            board.setBoardDate(LocalDateTime.of(2022, 12, random.nextInt(31) + 1, 06, 00));

            boardDAO.save(board);
        }
    }

    @Test
    public void findByIdTest() {
        Optional<Board> foundBoard = boardDAO.findById(1L);
        foundBoard.map(Board::getTitle).ifPresentOrElse(log::info, () -> {
            log.info("찾으시는 게시글이 없습니다");
        });
    }

//    @Test
//    public void deleteTest(){
//        Optional<Board> foundBoard = boardDAO.findById(50L);
//        boardDAO.delete(foundBoard.orElseThrow(() -> {throw }));
//    }

    @Test
    public void updateTest() {
        Optional<Board> foundBoard = boardDAO.findById(1L);
        foundBoard.ifPresent(board -> board.setTitle("수정된 제목"));
        foundBoard.map(Board::getTitle).ifPresent(log::info);
    }

    @Test
    public void findAllTest() {
        boardDAO.findAll().stream().map(Board::getTitle).forEach(log::info);
    }

    @Test
    public void findAllWithPagingTest() {
        boardDAO.findAllWithPaging(21, 10).stream().map(Board::getContent).forEach(log::info);
    }

    @Test
    public void findAllByBoardDate() {
        boardDAO.findAllByDate("20221210").stream().map(Board::toString).forEach(log::info);
    }

    @Test
    public void findAllBetweenBoardDate() {
        LocalDateTime startDate = LocalDateTime.of(2022, 12, 06, 10, 00, 00);
        LocalDateTime endDate = LocalDateTime.of(2022, 12, 22, 00, 00, 00);
        log.info(boardDAO.findAllBetweenBoardDate(startDate, endDate).size() + "건");
    }



}
