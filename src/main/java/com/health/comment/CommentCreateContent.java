package com.health.comment;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentCreateContent {
    @NotEmpty(message = "������ �ʼ��׸��Դϴ�.")
    private String commentcontent;
}
