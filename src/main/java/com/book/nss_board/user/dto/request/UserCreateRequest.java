package com.book.nss_board.user.dto.request;

import lombok.Getter;

public record UserCreateRequest(
        String name,
        String email
) {
}