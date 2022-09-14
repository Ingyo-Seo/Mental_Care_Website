package com.health.care;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;

import com.health.user.UserEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CareEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer careserial;

    @CreatedDate
    private LocalDateTime caredate;
    
    @ManyToOne
    private UserEntity careauthor;
    
}
