package com.health.board;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.health.comment.CommentEntity;
import com.health.user.UserEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer boardserial;

    @Column(length = 200)
    private String boardtitle;

    @Column(columnDefinition = "TEXT")
    private String boardcontent;

    private LocalDateTime boarddate;
    
    @Column
    private String boardtype;
    
    @OneToMany(mappedBy = "boardentity", cascade = CascadeType.REMOVE)
    private List<CommentEntity> commentList;
    
    @ManyToOne
    private UserEntity boardauthor;
}
