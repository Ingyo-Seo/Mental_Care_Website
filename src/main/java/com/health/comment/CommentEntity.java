package com.health.comment;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;

import com.health.board.BoardEntity;
import com.health.user.UserEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentserial;

    @Column(columnDefinition = "TEXT")
    private String commentcontent;

    @CreatedDate
    private LocalDateTime commentdate;
    
    @ManyToOne
    private BoardEntity boardentity;
    
    @ManyToOne
    private UserEntity boardauthor;
}