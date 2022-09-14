package com.health.board;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardCreateContent {
    @NotEmpty(message="제목은 필수항목입니다.")
    @Size(max=200)
    private String boardtitle;

    @NotEmpty(message="내용은 필수항목입니다.")
    private String boardcontent;
    
    @NotEmpty(message="유형은 필수항목입니다.")
    private String boardtype;
}
