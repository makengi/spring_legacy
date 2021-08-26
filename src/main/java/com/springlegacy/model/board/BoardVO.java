package com.springlegacy.model.board;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter
@Setter
@ToString
public class BoardVO {
    private Integer seq;
    private String title;
    private String writer;
    private String content;
    private Date regDate;
    private Integer cnt;

    @Builder
    public BoardVO(Integer seq,String title,String writer,String content, Date regDate, Integer cnt){
        this.seq = seq;
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.regDate = regDate;
        this.cnt = cnt;
    }

}
