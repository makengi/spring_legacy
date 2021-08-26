package com.springlegacy.model.board;


import com.springlegacy.model.board.service.BoardService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class BoardServiceClient {

    private BoardService boardService;
//    private LogAdvice Log;

    @BeforeEach
    public void dbSetup(){
        ApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
        boardService = (BoardService) container.getBean("boardService");
//        Log = (LogAdvice) container.getBean("log");
    }

    @Test
    public void write(){
        BoardVO boardVO = BoardVO.builder().title("임시제목")
                        .writer("홍길동")
                        .content("임시 내용").build();
//        boardService.insertBoard(boardVO);
    }

    @Test
    public void getAll(){
        Integer seq = 1;
        BoardVO where = BoardVO.builder().seq(seq).build();
//        Log.printLog();
        Assertions.assertEquals(where.getSeq(),seq);
        List<BoardVO> boardVOList = boardService.getBoardList(where);
        for (BoardVO boardVO : boardVOList) {
            System.out.println(boardVO.toString());
        }
    }

}
