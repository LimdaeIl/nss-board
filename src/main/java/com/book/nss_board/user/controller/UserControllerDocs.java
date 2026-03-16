package com.book.nss_board.user.controller;

import com.book.nss_board.user.dto.request.UserCreateRequest;
import com.book.nss_board.user.dto.request.UserUpdateRequest;
import com.book.nss_board.user.dto.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "User", description = "사용자 관리 API")
public interface UserControllerDocs {

    @Operation(summary = "사용자 생성", description = "새로운 사용자를 생성합니다.")
    ResponseEntity<UserResponse> create(@RequestBody UserCreateRequest request);

    @Operation(summary = "사용자 전체 조회", description = "전체 사용자를 조회합니다.")
    ResponseEntity<List<UserResponse>> findAll();

    @Operation(summary = "사용자 단건 조회", description = "ID로 사용자를 조회합니다.")
    ResponseEntity<UserResponse> findById(@PathVariable Long id);

    @Operation(summary = "사용자 수정", description = "기존 사용자를 수정합니다.")
    ResponseEntity<UserResponse> update(@PathVariable Long id, @RequestBody UserUpdateRequest request);

    @Operation(summary = "사용자 삭제", description = "사용자를 삭제합니다.")
    ResponseEntity<Void> delete(@PathVariable Long id);
}