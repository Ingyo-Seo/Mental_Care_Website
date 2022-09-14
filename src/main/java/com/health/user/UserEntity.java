package com.health.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userserial;
        
    private String userid;
    
    private String userpassword;

    @Column(unique = true)
    private String useremail;
    
    @Column(unique = true)
    private String usernickname;
}
