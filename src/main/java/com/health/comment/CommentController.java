package com.health.comment;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.health.board.BoardEntity;
import com.health.board.BoardService;
import com.health.user.UserEntity;
import com.health.user.UserService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/Comment")
@RequiredArgsConstructor
@Controller
public class CommentController {
    private final BoardService boardService;
    private final CommentService commentService;
    private final UserService userService;

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/Create/{boardserial}")
    public String createAnswer(Model model, @PathVariable("boardserial") Integer boardserial, @RequestParam String commentcontent, 
    		@Valid CommentCreateContent commentCreateContent, BindingResult bindingResult, Principal principal) {
    	BoardEntity boardentity = this.boardService.getBoardEntity(boardserial);
    	UserEntity userentity = this.userService.getUser(principal.getName());
        if (bindingResult.hasErrors()) {
            model.addAttribute("board", boardentity);
            return "boarddetail";
        }
        this.commentService.create(boardentity, commentcontent, userentity);
        return String.format("redirect:/Board/Detail/%s", boardserial);
    }
}
