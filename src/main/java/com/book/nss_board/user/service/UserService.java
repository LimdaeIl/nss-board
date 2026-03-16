package com.book.nss_board.user.service;

import com.book.nss_board.user.domain.User;
import com.book.nss_board.user.dto.request.UserCreateRequest;
import com.book.nss_board.user.dto.request.UserUpdateRequest;
import com.book.nss_board.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;


    public User create(UserCreateRequest request) {
        User user = new User(request.name(), request.email());
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
    }

    public User update(Long id, UserUpdateRequest request) {
        User user = findById(id);
        user.update(request.name(), request.email());
        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}