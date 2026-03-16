package com.book.nss_board.board.dto.request;

public record BoardCreateRequest(
        String title,
        String content,
        Long userId
) {

}
