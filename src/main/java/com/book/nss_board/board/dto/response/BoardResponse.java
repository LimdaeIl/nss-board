package com.book.nss_board.board.dto.response;

import com.book.nss_board.board.domain.Board;

public record BoardResponse(
        Long id,
        String title,
        String content,
        Long userId,
        String userName
) {
    public static BoardResponse from(Board board) {
        return new BoardResponse(
                board.getId(),
                board.getTitle(),
                board.getContent(),
                board.getUser().getId(),
                board.getUser().getName()
        );
    }
}
