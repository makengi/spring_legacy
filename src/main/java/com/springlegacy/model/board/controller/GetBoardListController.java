package com.springlegacy.model.board.controller;

import com.springlegacy.model.board.BoardVO;
import com.springlegacy.model.board.repository.BoardDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GetBoardListController implements Controller {

    private static Logger Log = LoggerFactory.getLogger(GetBoardListController.class);

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mav = new ModelAndView();

        if(httpServletRequest.getSession() == null){
            mav.setViewName("login");
            return mav;
        }

        Log.info("@ find board content list");

        BoardVO boardVO = BoardVO.builder().title("임시제목")
                                         .writer("홍길동")
                                          .content("임시 내용").build();
        BoardDAO boardDAO = new BoardDAO();
        List<BoardVO> boardVOList = boardDAO.getBoardList(boardVO);

        Log.info("@ boardVoList: {}",boardVOList.toString());

        mav.addObject("boardList", boardVOList);
        mav.setViewName("getBoardList");
        return mav;
    }
}
