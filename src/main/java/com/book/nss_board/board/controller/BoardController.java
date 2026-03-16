package com.book.nss_board.board.controller;

import com.book.nss_board.board.domain.Board;
import com.book.nss_board.board.dto.request.BoardCreateRequest;
import com.book.nss_board.board.dto.request.BoardUpdateRequest;
import com.book.nss_board.board.dto.response.BoardResponse;
import com.book.nss_board.board.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/boards")
public class BoardController implements BoardControllerDocs {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @Override
    @PostMapping
    public ResponseEntity<BoardResponse> create(@RequestBody BoardCreateRequest request) {
        Board board = boardService.create(request);
        return ResponseEntity.ok(BoardResponse.from(board));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<BoardResponse>> findAll() {
        List<BoardResponse> response = boardService.findAll()
                .stream()
                .map(BoardResponse::from)
                .toList();

        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<BoardResponse> findById(@PathVariable Long id) {
        Board board = boardService.findById(id);
        return ResponseEntity.ok(BoardResponse.from(board));
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<BoardResponse> update(@PathVariable Long id, @RequestBody BoardUpdateRequest request) {
        Board board = boardService.update(id, request);
        return ResponseEntity.ok(BoardResponse.from(board));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boardService.delete(id);
        return ResponseEntity.noContent().build();
    }
}