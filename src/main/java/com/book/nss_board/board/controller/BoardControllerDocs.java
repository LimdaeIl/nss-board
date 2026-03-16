package com.book.nss_board.board.controller;

import com.book.nss_board.board.dto.request.BoardCreateRequest;
import com.book.nss_board.board.dto.request.BoardUpdateRequest;
import com.book.nss_board.board.dto.response.BoardResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Board", description = "게시글 관리 API")
public interface BoardControllerDocs {

    @Operation(summary = "게시글 생성", description = "새로운 게시글을 생성합니다.")
    ResponseEntity<BoardResponse> create(@RequestBody BoardCreateRequest request);

    @Operation(summary = "게시글 전체 조회", description = "전체 게시글을 조회합니다.")
    ResponseEntity<List<BoardResponse>> findAll();

    @Operation(summary = "게시글 단건 조회", description = "ID로 게시글을 조회합니다.")
    ResponseEntity<BoardResponse> findById(@PathVariable Long id);

    @Operation(summary = "게시글 수정", description = "기존 게시글을 수정합니다.")
    ResponseEntity<BoardResponse> update(@PathVariable Long id, @RequestBody BoardUpdateRequest request);

    @Operation(summary = "게시글 삭제", description = "게시글을 삭제합니다.")
    ResponseEntity<Void> delete(@PathVariable Long id);
}