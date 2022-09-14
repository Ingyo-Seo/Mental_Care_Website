package com.health.comment;

import com.health.board.BoardEntity;
import com.health.user.UserEntity;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public void create(BoardEntity boardentity, String commentcontent, UserEntity userEntity) {
    	CommentEntity commententity = new CommentEntity();
    	commententity.setCommentcontent(commentcontent);
    	commententity.setCommentdate(LocalDateTime.now());
    	commententity.setBoardentity(boardentity);
    	commententity.setBoardauthor(userEntity);
        this.commentRepository.save(commententity);
    }
}