package com.book.nss_board.user.repository;

import com.book.nss_board.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}