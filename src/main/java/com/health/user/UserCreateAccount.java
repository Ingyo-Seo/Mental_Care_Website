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
    @NotEmpty(message = "�����ID�� �ʼ��׸��Դϴ�.")
    private String userid;

    @NotEmpty(message = "��й�ȣ�� �ʼ��׸��Դϴ�.")
    private String userpassword;

    @NotEmpty(message = "��й�ȣ Ȯ���� �ʼ��׸��Դϴ�.")
    private String userpasswordconfirm;

    @NotEmpty(message = "�̸����� �ʼ��׸��Դϴ�.")
    @Email
    private String useremail;
    
    @NotEmpty(message = "�г����� �ʼ��׸��Դϴ�.")
    private String usernickname;
}
