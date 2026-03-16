package com.book.nss_board.board.service;

import com.book.nss_board.board.domain.Board;
import com.book.nss_board.board.dto.request.BoardCreateRequest;
import com.book.nss_board.board.dto.request.BoardUpdateRequest;
import com.book.nss_board.board.repository.BoardRepository;
import com.book.nss_board.user.domain.User;
import com.book.nss_board.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    public BoardService(BoardRepository boardRepository, UserRepository userRepository) {
        this.boardRepository = boardRepository;
        this.userRepository = userRepository;
    }

    public Board create(BoardCreateRequest request) {
        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + request.userId()));

        Board board = new Board(request.title(), request.content(), user);
        return boardRepository.save(board);
    }

    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    public Board findById(Long id) {
        return boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
    }

    public Board update(Long id, BoardUpdateRequest request) {
        Board board = findById(id);
        board.update(request.title(), request.content());
        return boardRepository.save(board);
    }

    public void delete(Long id) {
        boardRepository.deleteById(id);
    }
}