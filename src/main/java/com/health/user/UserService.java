package com.health.user;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.health.DataNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserEntity create(String userid, String userpassword, String useremail, String usernickname) {
    	UserEntity user = new UserEntity();
    	user.setUserid(userid);
    	user.setUserpassword(passwordEncoder.encode(userpassword));
        user.setUseremail(useremail);
        user.setUsernickname(usernickname);
        this.userRepository.save(user);
        return user;
    }
    
    public UserEntity getUser(String userid) {
        Optional<UserEntity> userEntity = this.userRepository.findByuserid(userid);
        if (userEntity.isPresent()) {
            return userEntity.get();
        } else {
            throw new DataNotFoundException("userEntity not found");
        }
    }
}
