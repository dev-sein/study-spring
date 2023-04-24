package com.example.basic.repository;

import com.example.basic.domain.entity.Board;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class BoardDAO {
    @PersistenceContext
    EntityManager entityManager;

    //글 작성
    public Board save(Board board) {
        entityManager.persist(board);
        return board;
    }

    //글 삭제
    public void delete(Board board) {
        entityManager.remove(board);
    }

    //글 1개 조회
    public Optional<Board> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Board.class, id));
    }

    public List<Board> findAll() {
        String query = "select b from Board b";
        TypedQuery<Board> result = entityManager.createQuery(query, Board.class);
        return result.getResultList();
    }

    public List<Board> findAllWithPaging(int offset, int amount) {
        String query = "select b from Board b order by b.id desc";
        TypedQuery<Board> result = entityManager.createQuery(query, Board.class);
        result.setFirstResult(offset - 1);
        result.setMaxResults(amount);
        return result.getResultList();

    }

    //특정 일자 데이터 조회
    public List<Board> findAllByDate(String boardDate) {
        String query = "select b from Board b where function('to_char', b.boardDate, 'yyyymmdd') = :boardDate";
        TypedQuery<Board> result = entityManager.createQuery(query, Board.class);
        result.setParameter("boardDate", boardDate);
        return result.getResultList();
    }

    //특정 출시 기간 조회
    public List<Board> findAllBetweenBoardDate(LocalDateTime startDate, LocalDateTime endDate) {
        String query = "select b from Board b where b.boardDate between :startDate and :endDate";
        TypedQuery<Board> result = entityManager.createQuery(query, Board.class);
        result.setParameter("startDate", startDate);
        result.setParameter("endDate", endDate);
        return result.getResultList();
    }

    //특정 이름 가격, 조회
    public List<Board> findAllByNameAndPrice(String title, String content) {
        String query = "select b from Board b where b.title = :title and b.content =: content";
        TypedQuery<Board> result = entityManager.createQuery(query, Board.class);
        result.setParameter("title", title);
        result.setParameter("content", content);
        return result.getResultList();
    }

}