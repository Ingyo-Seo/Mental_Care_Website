package com.health.board;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.health.user.UserEntity;
import com.health.user.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BoardController {
    private final BoardService boardService;
    private final UserService userService;
	
    @RequestMapping("/Board/Notice")
    public String noticelist(Model model, @RequestParam(value="page", defaultValue="0") int page) {
    	Page<BoardEntity> paging = this.boardService.getList(page);
        model.addAttribute("paging", paging);
        return "noticeboard";
    }
    
    @RequestMapping("/Board/Free")
    public String freelist(Model model, @RequestParam(value="page", defaultValue="0") int page) {
    	Page<BoardEntity> paging = this.boardService.getList(page);
        model.addAttribute("paging", paging);
        return "freeboard";
    }
    
    @RequestMapping("/Board/Anonymous")
    public String anonymouslist(Model model, @RequestParam(value="page", defaultValue="0") int page) {
    	Page<BoardEntity> paging = this.boardService.getList(page);
        model.addAttribute("paging", paging);
        return "anonymousboard";
    }
    
    @RequestMapping(value = "/Board/Detail/{boardserial}")
    public String detail(Model model, @PathVariable("boardserial") Integer boardserial) {
    	BoardEntity boardentity = this.boardService.getBoardEntity(boardserial);
        model.addAttribute("board", boardentity);
        return "boarddetail";
    }
    
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/Board/Create")
    public String boardCreate(BoardCreateContent boardcreateContent) {
        return "boardcreate";
    }
    
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/Board/Create")
    public String boardCreate(@Valid BoardCreateContent boardcreateContent, BindingResult bindingResult, Principal principal) {
        if (bindingResult.hasErrors()) {
            return "boardcreate";
        }
        UserEntity userEntity = this.userService.getUser(principal.getName());
        this.boardService.createBoard(boardcreateContent.getBoardtitle(), boardcreateContent.getBoardcontent(), boardcreateContent.getBoardtype(), userEntity);
        return "redirect:/Board/Free";
    }
}
