package com.book.nss_board.user.dto.response;

import com.book.nss_board.user.domain.User;

public record UserResponse(
         Long id,
         String name,
         String email
) {
    public static UserResponse from(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}
