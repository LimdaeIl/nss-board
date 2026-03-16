package com.book.nss_board.board.repository;

import com.book.nss_board.board.domain.Board;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @Override
    @EntityGraph(attributePaths = {"user"})
    List<Board> findAll();

    @Override
    @EntityGraph(attributePaths = {"user"})
    Optional<Board> findById(Long id);
}