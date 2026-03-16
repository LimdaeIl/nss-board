package com.book.nss_board.web.controller;

import com.book.nss_board.board.dto.request.BoardCreateRequest;
import com.book.nss_board.board.dto.request.BoardUpdateRequest;
import com.book.nss_board.board.service.BoardService;
import com.book.nss_board.user.dto.request.UserCreateRequest;
import com.book.nss_board.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ViewController {

    private final BoardService boardService;
    private final UserService userService;

    public ViewController(BoardService boardService, UserService userService) {
        this.boardService = boardService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("boards", boardService.findAll());
        return "index";
    }

    @GetMapping("/users/new")
    public String userCreateForm() {
        return "user-form";
    }

    @PostMapping("/users/new")
    public String createUser(@RequestParam String name,
            @RequestParam String email) {
        userService.create(new UserCreateRequest(name, email));
        return "redirect:/";
    }

    @GetMapping("/boards/new")
    public String boardCreateForm(Model model) {
        model.addAttribute("users", userService.findAll());
        return "board-form";
    }

    @PostMapping("/boards/new")
    public String createBoard(@RequestParam String title,
            @RequestParam String content,
            @RequestParam Long userId) {
        boardService.create(new BoardCreateRequest(title, content, userId));
        return "redirect:/";
    }

    @GetMapping("/boards/{id}")
    public String boardDetail(@PathVariable Long id, Model model) {
        model.addAttribute("board", boardService.findById(id));
        return "board-detail";
    }

    @GetMapping("/boards/{id}/edit")
    public String boardEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("board", boardService.findById(id));
        return "board-edit-form";
    }

    @PostMapping("/boards/{id}/edit")
    public String updateBoard(@PathVariable Long id,
            @RequestParam String title,
            @RequestParam String content) {
        boardService.update(id, new BoardUpdateRequest(title, content));
        return "redirect:/boards/" + id;
    }

    @PostMapping("/boards/{id}/delete")
    public String deleteBoard(@PathVariable Long id) {
        boardService.delete(id);
        return "redirect:/";
    }
}