package com.health.board;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardCreateContent {
    @NotEmpty(message="������ �ʼ��׸��Դϴ�.")
    @Size(max=200)
    private String boardtitle;

    @NotEmpty(message="������ �ʼ��׸��Դϴ�.")
    private String boardcontent;
    
    @NotEmpty(message="������ �ʼ��׸��Դϴ�.")
    private String boardtype;
}
