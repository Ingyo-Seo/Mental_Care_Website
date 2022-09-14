package com.health.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateAccount {
    @Size(min = 3, max = 25)
    @NotEmpty(message = "사용자ID는 필수항목입니다.")
    private String userid;

    @NotEmpty(message = "비밀번호는 필수항목입니다.")
    private String userpassword;

    @NotEmpty(message = "비밀번호 확인은 필수항목입니다.")
    private String userpasswordconfirm;

    @NotEmpty(message = "이메일은 필수항목입니다.")
    @Email
    private String useremail;
    
    @NotEmpty(message = "닉네임은 필수항목입니다.")
    private String usernickname;
}
